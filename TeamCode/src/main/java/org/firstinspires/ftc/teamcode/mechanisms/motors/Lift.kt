package org.firstinspires.ftc.teamcode.mechanisms.motors

import com.rowanmcalpin.nextftc.core.Subsystem
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.control.coefficients.PIDCoefficients
import com.rowanmcalpin.nextftc.core.control.controllers.PIDController
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition

object Lift: Subsystem() {
    lateinit var motor: MotorEx

    val controller = PIDFController(PIDCoefficients(0.005, 0.0, 0.0))

    val name = "lift"

    val toUp: Command
        get() = RunToPosition(
            motor, // MOTOR TO MOVE
            445.0, // TARGET POSITION, IN TICKS
            controller, // CONTROLLER TO IMPLEMENT
            this
        ) // IMPLEMENTED SUBSYSTEM
    val toDown: Command
        get() = RunToPosition(
            motor, // MOTOR TO MOVE
            0.0, // TARGET POSITION, IN TICKS
            controller, // CONTROLLER TO IMPLEMENT
            this
        ) // IMPLEMENTED SUBSYSTEM
    val toClearIntake: Command
        get() = RunToPosition(
            motor, // MOTOR TO MOVE
            100.0, // TARGET POSITION, IN TICKS
            controller, // CONTROLLER TO IMPLEMENT
            this
        ) // IMPLEMENTED SUBSYSTEM
    val toScore: Command
        get() = RunToPosition(
            motor, // MOTOR TO MOVE
            75.0, // TARGET POSITION, IN TICKS
            controller, // CONTROLLER TO IMPLEMENT
            this
        ) // IMPLEMENTED SUBSYSTEM

    override fun initialize() {
        motor = MotorEx(name)
    }
}