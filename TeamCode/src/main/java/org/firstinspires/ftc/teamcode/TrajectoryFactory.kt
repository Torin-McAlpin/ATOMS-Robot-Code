package org.firstinspires.ftc.teamcode

import com.pedropathing.pathgen.BezierCurve
import com.pedropathing.pathgen.BezierLine
import com.pedropathing.pathgen.PathBuilder
import com.pedropathing.pathgen.PathChain
import com.pedropathing.pathgen.Point


object TrajectoryFactory {
    private var builder = PathBuilder()

    // region Specimen Paths

    var scorePreloadSpec: PathChain = builder
        .addPath(
            BezierLine(
                Point(8.000, 54.125, Point.CARTESIAN),
                Point(39.500, 66.727, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var pushFirstSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(39.500, 66.727, Point.CARTESIAN),
                Point(25.310, 2.876, Point.CARTESIAN),
                Point(54.252, 62.211, Point.CARTESIAN),
                Point(90.695, 27.228, Point.CARTESIAN),
                Point(15.531, 18.791, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var pushSecondSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(15.531, 18.791, Point.CARTESIAN),
                Point(83.601, 35.856, Point.CARTESIAN),
                Point(73.822, 4.602, Point.CARTESIAN),
                Point(15.531, 18.791, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var pushThirdSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(15.531, 18.791, Point.CARTESIAN),
                Point(93.571, 9.779, Point.CARTESIAN),
                Point(71.521, 11.505, Point.CARTESIAN),
                Point(1.342, 4.218, Point.CARTESIAN),
                Point(4.794, 9.204, Point.CARTESIAN),
                Point(10.000, 22.250, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var scoreFirstSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(10.000, 22.250, Point.CARTESIAN),
                Point(30.100, 70.750, Point.CARTESIAN),
                Point(39.500, 69.795, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var pickupSecondSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(39.500, 69.795, Point.CARTESIAN),
                Point(30.100, 70.750, Point.CARTESIAN),
                Point(10.000, 22.250, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var scoreSecondSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(10.000, 22.250, Point.CARTESIAN),
                Point(30.100, 75.000, Point.CARTESIAN),
                Point(39.500, 73.055, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var pickupThirdSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(39.500, 73.055, Point.CARTESIAN),
                Point(30.100, 75.000, Point.CARTESIAN),
                Point(10.000, 22.250, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var scoreThirdSpec: PathChain = builder
        .addPath(
            BezierCurve(
                Point(10.000, 22.250, Point.CARTESIAN),
                Point(30.100, 79.574, Point.CARTESIAN),
                Point(39.308, 78.232, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(90.0))
        .build()

    var specPark: PathChain = builder
        .addPath(
            BezierCurve(
                Point(39.308, 78.232, Point.CARTESIAN),
                Point(18.599, 132.495, Point.CARTESIAN),
                Point(90.120, 121.566, Point.CARTESIAN),
                Point(84.176, 94.913, Point.CARTESIAN)
            )
        )
        .setLinearHeadingInterpolation(Math.toRadians(90.0), Math.toRadians(0.0))
        .build()

    // endregion

    // region Sample Paths

    var pushFirstSample: PathChain = builder
        .addPath(
            BezierCurve(
                Point(8.000, 111.979, Point.CARTESIAN),
                Point(108.144, 104.501, Point.CARTESIAN),
                Point(13.997, 126.935, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(0.0))
        .build()

    var pushSecondSample: PathChain = builder
        .addPath(
            BezierCurve(
                Point(13.997, 126.935, Point.CARTESIAN),
                Point(79.190, 104.309, Point.CARTESIAN),
                Point(66.727, 137.672, Point.CARTESIAN),
                Point(13.806, 130.770, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(0.0))
        .build()

    var pushThirdSample: PathChain = builder
        .addPath(
            BezierCurve(
                Point(13.806, 130.770, Point.CARTESIAN),
                Point(74.397, 126.551, Point.CARTESIAN),
                Point(69.220, 138.248, Point.CARTESIAN),
                Point(13.614, 134.029, Point.CARTESIAN)
            )
        )
        .setConstantHeadingInterpolation(Math.toRadians(0.0))
        .build()

    var samplePark: PathChain = builder
        .addPath(
            BezierCurve(
                Point(13.614, 134.029, Point.CARTESIAN),
                Point(92.037, 118.690, Point.CARTESIAN),
                Point(83.409, 94.913, Point.CARTESIAN)
            )
        )
        .setLinearHeadingInterpolation(Math.toRadians(0.0), Math.toRadians(90.0))
        .build()

    // endregion

}