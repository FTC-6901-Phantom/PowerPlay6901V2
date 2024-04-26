package BlueWing;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MiddleBW{
        public static void main(String[] args) {
    MeepMeep meepMeep = new MeepMeep(800);

    RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
            // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
            .setConstraints(30, 30, Math.toRadians(180), Math.toRadians(180), 7.55)
            .setDimensions(11,14.5)
            .followTrajectorySequence(drive ->
                    drive.trajectorySequenceBuilder(new Pose2d(-29, 60, Math.toRadians(90)))
                            .back(29)
                            .forward(24)
                            .turn(Math.toRadians(-90))
                            .forward(78)
                            .strafeRight(19)
                            .waitSeconds(1)
                            .strafeLeft(28)
                            .build()
            );

    meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
            .setDarkMode(true)
            .setBackgroundAlpha(0.95f)
            .addEntity(myBot)
            .start();
}
}
