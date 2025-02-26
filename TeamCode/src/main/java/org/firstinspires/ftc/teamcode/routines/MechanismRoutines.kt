package org.firstinspires.ftc.teamcode.routines

import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.command.groups.ParallelGroup
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup
import com.rowanmcalpin.nextftc.core.command.utility.delays.Delay
import org.firstinspires.ftc.teamcode.mechanisms.motors.Extension
import org.firstinspires.ftc.teamcode.mechanisms.motors.Intake
import org.firstinspires.ftc.teamcode.mechanisms.motors.Lift
import org.firstinspires.ftc.teamcode.mechanisms.motors.Pivot
import org.firstinspires.ftc.teamcode.mechanisms.servos.Arm
import org.firstinspires.ftc.teamcode.mechanisms.servos.Claw
import org.firstinspires.ftc.teamcode.mechanisms.servos.Stopper

object MechanismRoutines {
    val outToIntake: Command
        get() = SequentialGroup(
            Lift.toClearIntake,
            ParallelGroup(
                Pivot.toOut,
                Extension.toOut,
                Intake.start
            )
        )
    val extensionIn: Command
        get() = SequentialGroup(
            Lift.toClearIntake,
            ParallelGroup(
                Pivot.toIn,
                Extension.toIn,
                Intake.stop,
                Arm.toUp
            ),
            Lift.toDown
        )


    val outtake: Command
        get() = SequentialGroup(
            Lift.toClearIntake,
            Pivot.toOut,
            Intake.reverse
        )

    val specPickup: Command
        get() = SequentialGroup(
            Lift.toClearIntake,
            Pivot.toOut,
            Intake.reverse,
            Delay(1.0),
            ParallelGroup(
                Intake.stop,
                Extension.toIn,
                Pivot.toIn,
                Claw.open
            ),
            ParallelGroup(
                Arm.toCollect,
                Lift.toDown
            )
        )

    val toSpecScore: Command
        get() = SequentialGroup(
            Claw.close,
            Lift.toClearIntake,
            ParallelGroup(
                Intake.stop,
                Extension.toIn,
                Pivot.toIn,
                Stopper.toRest
            ),
            Arm.toDown,
            Lift.toUp
        )

    val confirmScore: Command
        get() = SequentialGroup(
            Stopper.toScore,
            Lift.toScore,
            Claw.open,
            Stopper.toRest,
            Lift.toDown,
            Arm.toUp
        )

    val autoSpecPickup: Command
        get() = ParallelGroup(
                    Arm.toCollect,
                    Lift.toDown
                )

    val autoPark: Command
        get() = SequentialGroup(
            Arm.toCollect,
            Lift.toClearIntake
        )
}