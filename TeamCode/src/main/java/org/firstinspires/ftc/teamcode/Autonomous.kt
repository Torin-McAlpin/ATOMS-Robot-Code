package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.command.groups.ParallelGroup
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup
import com.rowanmcalpin.nextftc.ftc.NextFTCOpMode
import com.rowanmcalpin.nextftc.ftc.components.GamepadComponent
import com.rowanmcalpin.nextftc.ftc.components.SubsystemComponent
import com.rowanmcalpin.nextftc.ftc.driving.MecanumDriverControlled
import com.rowanmcalpin.nextftc.ftc.gamepad.GamepadManager
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx
import com.rowanmcalpin.nextftc.pedro.PedroComponent
import com.rowanmcalpin.nextftc.pedro.PedroData.follower
import org.firstinspires.ftc.teamcode.mechanisms.motors.Extension
import org.firstinspires.ftc.teamcode.mechanisms.motors.Intake
import org.firstinspires.ftc.teamcode.mechanisms.motors.Lift
import org.firstinspires.ftc.teamcode.mechanisms.motors.Pivot
import org.firstinspires.ftc.teamcode.mechanisms.servos.Arm
import org.firstinspires.ftc.teamcode.mechanisms.servos.Claw
import org.firstinspires.ftc.teamcode.routines.AutoRoutines

@Autonomous(name = "Autonomous")
class Autonomous: NextFTCOpMode(
    SubsystemComponent(Claw, Lift, Arm, Pivot, Intake, Extension),
    PedroComponent(FConstants::class.java, LConstants::class.java)) {

    val frontLeftName = "front_left"
    val frontRightName = "front_right"
    val backLeftName = "back_left"
    val backRightName = "back_right"

    lateinit var frontLeftMotor: MotorEx
    lateinit var frontRightMotor: MotorEx
    lateinit var backLeftMotor: MotorEx
    lateinit var backRightMotor: MotorEx

    lateinit var motors: Array<MotorEx>


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
        AutoRoutines.specAuto()
    }
}