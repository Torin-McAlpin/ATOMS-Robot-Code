package org.firstinspires.ftc.teamcode

import com.pedropathing.follower.FollowerConstants
import com.pedropathing.localization.Localizers

object FConstants { // This is how we change Follower Constants.
    init {
        // Select our localizer
        FollowerConstants.localizers = Localizers.TWO_WHEEL

        // We can change the value of any variable/constant of FollowerConstants.
        FollowerConstants.mass = 10.0 // TODO: Tune (KG)
    }
}

