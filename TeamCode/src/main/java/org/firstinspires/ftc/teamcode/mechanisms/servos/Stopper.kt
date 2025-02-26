package org.firstinspires.ftc.teamcode.mechanisms.servos

import com.qualcomm.robotcore.hardware.Servo
import com.rowanmcalpin.nextftc.core.Subsystem
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.ftc.OpModeData
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition

object Stopper: Subsystem() {
    lateinit var servo: Servo
    val name = "stopper"

    val restPos = 0.1
    val scorePos = 1.0


    val toScore: Command
        get() = ServoToPosition(
            servo, // SERVO TO MOVE
            scorePos, // POSITION TO MOVE TO
            this
        )  // IMPLEMENTED SUBSYSTEM

    val toRest: Command
        get() = ServoToPosition(
            servo,
            restPos,
            this
        )
    override fun initialize() {
        servo = OpModeData.hardwareMap!!.get(Servo::class.java, name)
    }
}