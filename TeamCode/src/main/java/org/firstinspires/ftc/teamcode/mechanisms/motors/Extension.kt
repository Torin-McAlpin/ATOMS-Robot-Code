package org.firstinspires.ftc.teamcode.mechanisms.motors

import com.rowanmcalpin.nextftc.core.Subsystem
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.control.coefficients.PIDCoefficients
import com.rowanmcalpin.nextftc.core.control.controllers.PIDController
import com.rowanmcalpin.nextftc.core.control.controllers.PIDFController
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.RunToPosition

object Extension: Subsystem() {
    lateinit var motor: MotorEx

    val controller = PIDFController(PIDCoefficients(0.005, 0.0, 0.0))

    val name = "extension"

    val toOut: Command
        get() = RunToPosition(
            motor, // MOTOR TO MOVE
            -132.0,
            controller, // CONTROLLER TO IMPLEMENT
            this
        ) // IMPLEMENTED SUBSYSTEM

    val toIn: Command
        get() = RunToPosition(
            motor, // MOTOR TO MOVE
            -4.0, // TARGET POSITION, IN TICKS
            controller, // CONTROLLER TO IMPLEMENT
            this
        ) // IMPLEMENTED SUBSYSTEM


    override fun initialize() {
        motor = MotorEx(name)
    }
}