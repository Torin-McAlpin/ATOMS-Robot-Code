package org.firstinspires.ftc.teamcode.mechanisms.servos

import com.qualcomm.robotcore.hardware.Servo
import com.rowanmcalpin.nextftc.core.Subsystem
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.ftc.OpModeData
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition

object Claw: Subsystem() {
    lateinit var servo: Servo

    val name = "claw"

    val openPos = 0.4
    val closePos = 0.15


    val open: Command
        get() = ServoToPosition(
            servo, // SERVO TO MOVE
            openPos, // POSITION TO MOVE TO
            this
        )  // IMPLEMENTED SUBSYSTEM

    val close: Command
        get() = ServoToPosition(
            servo, // SERVO TO MOVE
            closePos, // POSITION TO MOVE TO
            this
        ) // IMPLEMENTED SUBSYSTEM

    override fun initialize() {
        servo = OpModeData.hardwareMap!!.get(Servo::class.java, name)
    }
}