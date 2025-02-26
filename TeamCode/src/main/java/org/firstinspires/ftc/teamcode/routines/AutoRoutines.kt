package org.firstinspires.ftc.teamcode.routines

import com.rowanmcalpin.nextftc.core.command.Command
import com.rowanmcalpin.nextftc.core.command.groups.ParallelGroup
import com.rowanmcalpin.nextftc.core.command.groups.SequentialGroup
import com.rowanmcalpin.nextftc.core.command.utility.delays.Delay
import com.rowanmcalpin.nextftc.pedro.FollowPath
import org.firstinspires.ftc.teamcode.TrajectoryFactory

object AutoRoutines {
    val specAuto: Command
        get() = SequentialGroup(
            ParallelGroup(
                FollowPath(TrajectoryFactory.scorePreloadSpec),
                MechanismRoutines.toSpecScore
            ),
            ParallelGroup(
                MechanismRoutines.confirmScore,
                SequentialGroup(
                    Delay(1.0),
                    FollowPath(TrajectoryFactory.pushFirstSample)
                )
            ),
            FollowPath(TrajectoryFactory.pushSecondSpec),
            ParallelGroup(
                FollowPath(TrajectoryFactory.pushThirdSpec),
                MechanismRoutines.autoSpecPickup,
            ),
            ParallelGroup(
                FollowPath(TrajectoryFactory.scoreFirstSpec),
                MechanismRoutines.toSpecScore
            ),
            MechanismRoutines.confirmScore,
            ParallelGroup(
                FollowPath(TrajectoryFactory.pickupSecondSpec),
                MechanismRoutines.autoSpecPickup
            ),
            ParallelGroup(
                MechanismRoutines.toSpecScore,
                FollowPath(TrajectoryFactory.scoreSecondSpec)
            ),
            MechanismRoutines.confirmScore,
            ParallelGroup(
                FollowPath(TrajectoryFactory.pickupThirdSpec),
                MechanismRoutines.autoSpecPickup
            ),
            ParallelGroup(
                MechanismRoutines.toSpecScore,
                FollowPath(TrajectoryFactory.scoreThirdSpec)
            ),
            MechanismRoutines.confirmScore,
            ParallelGroup(
                FollowPath(TrajectoryFactory.specPark),
                MechanismRoutines.autoPark
            )

        )
}