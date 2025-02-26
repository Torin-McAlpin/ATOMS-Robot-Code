package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.command.groups.ParallelGroup
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand
import com.rowanmcalpin.nextftc.core.command.utility.NullCommand
import com.rowanmcalpin.nextftc.ftc.NextFTCOpMode
import com.rowanmcalpin.nextftc.ftc.components.GamepadComponent
import com.rowanmcalpin.nextftc.ftc.components.SubsystemComponent
import com.rowanmcalpin.nextftc.ftc.driving.MecanumDriverControlled
import com.rowanmcalpin.nextftc.ftc.gamepad.Button
import com.rowanmcalpin.nextftc.ftc.gamepad.GamepadManager
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx
import com.rowanmcalpin.nextftc.pedro.PedroComponent
import org.firstinspires.ftc.teamcode.mechanisms.motors.Extension
import org.firstinspires.ftc.teamcode.mechanisms.motors.Intake
import org.firstinspires.ftc.teamcode.mechanisms.motors.Lift
import org.firstinspires.ftc.teamcode.mechanisms.motors.Pivot
import org.firstinspires.ftc.teamcode.mechanisms.servos.Arm
import org.firstinspires.ftc.teamcode.mechanisms.servos.Claw
import org.firstinspires.ftc.teamcode.mechanisms.servos.Stopper
import org.firstinspires.ftc.teamcode.routines.MechanismRoutines

@TeleOp(name = "TeleOp")
class TeleOp: NextFTCOpMode(
    SubsystemComponent(Claw, Lift, Arm, Pivot, Intake, Extension, Stopper),
    GamepadComponent()) {

    val frontLeftName = "LF"
    val frontRightName = "RF"
    val backLeftName = "LB"
    val backRightName = "RB"

    lateinit var frontLeftMotor: MotorEx
    lateinit var frontRightMotor: MotorEx
    lateinit var backLeftMotor: MotorEx
    lateinit var backRightMotor: MotorEx

    lateinit var motors: Array<MotorEx>

    var previousCommand: Command = NullCommand()

    lateinit var driverControlled: Command

    override fun onInit() {
        frontLeftMotor = MotorEx(frontLeftName)
        backLeftMotor = MotorEx(backLeftName)
        backRightMotor = MotorEx(backRightName)
        frontRightMotor = MotorEx(frontRightName)

        // Change your motor directions to suit your robot.
        frontLeftMotor.direction = DcMotorSimple.Direction.REVERSE
        backLeftMotor.direction = DcMotorSimple.Direction.REVERSE
        frontRightMotor.direction = DcMotorSimple.Direction.FORWARD
        backRightMotor.direction = DcMotorSimple.Direction.FORWARD

        motors = arrayOf(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor)
    }

    override fun onStartButtonPressed() {
        driverControlled = MecanumDriverControlled(motors, GamepadManager.gamepad1)
        driverControlled()

        GamepadManager.gamepad2.dpadUp.pressedCommand = { stateMachine(GamepadManager.gamepad2.dpadUp) }
        GamepadManager.gamepad2.dpadDown.pressedCommand = { stateMachine(GamepadManager.gamepad2.dpadDown) }
        GamepadManager.gamepad2.rightBumper.pressedCommand = { stateMachine(GamepadManager.gamepad2.rightBumper) }
        GamepadManager.gamepad2.leftBumper.pressedCommand = { stateMachine(GamepadManager.gamepad2.leftBumper) }
    }

    private fun setPreviousCommand(command: Command): Command {
        return InstantCommand({ previousCommand = command })
    }


    private fun stateMachine(gamepadButton: Button): Command {
        return when (gamepadButton) {
            GamepadManager.gamepad2.dpadUp -> {
                ParallelGroup(MechanismRoutines.toSpecScore, setPreviousCommand(MechanismRoutines.toSpecScore))
            }
            GamepadManager.gamepad2.dpadDown -> {
                SequentialGroup(MechanismRoutines.specPickup, setPreviousCommand(MechanismRoutines.specPickup))
            }
            GamepadManager.gamepad2.rightBumper -> {
                if (previousCommand == MechanismRoutines.toSpecScore) {
                    SequentialGroup(MechanismRoutines.confirmScore, MechanismRoutines.outToIntake, setPreviousCommand(MechanismRoutines.outToIntake))
                } else {
                    SequentialGroup(MechanismRoutines.outToIntake, setPreviousCommand(MechanismRoutines.outToIntake))
                }
            }
            GamepadManager.gamepad2.leftBumper -> {
                return if (previousCommand == MechanismRoutines.toSpecScore) {
                    SequentialGroup(MechanismRoutines.confirmScore, MechanismRoutines.outtake, setPreviousCommand(MechanismRoutines.outtake))
                } else {
                    SequentialGroup(MechanismRoutines.outtake, setPreviousCommand(MechanismRoutines.outtake))
                }
            }
            else -> {
                return NullCommand()
            }
        }
    }
}