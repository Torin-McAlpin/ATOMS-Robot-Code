package org.firstinspires.ftc.teamcode.mechanisms.servos

import com.qualcomm.robotcore.hardware.Servo
import com.rowanmcalpin.nextftc.core.Subsystem
import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.ftc.OpModeData
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition

object Arm: Subsystem() {
    lateinit var servo: Servo
    val name = "arm"

    val upPos = 0.275
    val downPos = 0.35
    val collectPos = 0.1


    val toUp: Command
        get() = ServoToPosition(
            servo, // SERVO TO MOVE
            upPos, // POSITION TO MOVE TO
            this
        )  // IMPLEMENTED SUBSYSTEM

    val toDown: Command
        get() = ServoToPosition(
            servo,
            downPos,
            this
        )

    val toCollect: Command
        get() = ServoToPosition(
            servo,
            collectPos,
            this
        )
    override fun initialize() {
        servo = OpModeData.hardwareMap!!.get(Servo::class.java, name)
    }
}