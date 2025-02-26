package org.firstinspires.ftc.teamcode

import com.pedropathing.localization.Encoder
import com.pedropathing.localization.constants.TwoWheelConstants
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot


object LConstants { // This is how we change ThreeWheelConstants.
    init {
        TwoWheelConstants.forwardTicksToInches = .001989436789 // TODO: Tune
        TwoWheelConstants.strafeTicksToInches = .001989436789 // TODO: Tune
        TwoWheelConstants.forwardY = 1.0 // TODO: Tune
        TwoWheelConstants.strafeX = -2.5// TODO: Tune
        TwoWheelConstants.forwardEncoder_HardwareMapName = "LF"
        TwoWheelConstants.strafeEncoder_HardwareMapName = "RB"
        TwoWheelConstants.forwardEncoderDirection = Encoder.REVERSE // TODO: Tune
        TwoWheelConstants.strafeEncoderDirection = Encoder.FORWARD // TODO: Tune
        TwoWheelConstants.IMU_HardwareMapName = "imu"
        TwoWheelConstants.IMU_Orientation = RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.UP,
            RevHubOrientationOnRobot.UsbFacingDirection.RIGHT
        )
    }
}

