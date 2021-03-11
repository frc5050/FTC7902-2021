package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous

public class DriveOntoLineAndShoot extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Robot robot = new Robot();
        robot.init(hardwareMap);

        waitForStart();
        int startEncoderCount = robot.rightBack.getCurrentPosition();
        double hitLineTime = 0;
        boolean haveHitLine = false;
        while (opModeIsActive()) {
            double cpr = 1024;
            double wheelDiameter = 4; // inches
            double wheelCircumference = wheelDiameter * Math.PI;
            double desiredDistance = 18 * 2;
            double desiredRevs = desiredDistance / wheelCircumference;
            int desiredEncoderCount = (int) (desiredRevs * cpr);
            int currentEncoderCount = robot.rightBack.getCurrentPosition() - startEncoderCount;
            if (currentEncoderCount < desiredEncoderCount) {
                robot.setSpeeds(0.3, 0.3);
            } else {
                if (haveHitLine == false) {
                    hitLineTime = System.currentTimeMillis();
                }
                robot.setSpeeds(0, 0);
                if (System.currentTimeMillis()-hitLineTime > 2000) {
                    robot.intake.setPower(1);
                    robot.belt.setPower(1);
                }

                robot.rightShooter.setPower(.6);
                robot.leftShooter.setPower(.6);
                haveHitLine = true;
            }
            telemetry.addData("rightBackEncoder", robot.rightBack.getCurrentPosition());
            telemetry.addData("leftBackEncoder", robot.leftBack.getCurrentPosition());
            telemetry.addData("rightFrontEncoder", robot.rightFront.getCurrentPosition());
            telemetry.addData("leftFrontEncoder", robot.leftFront.getCurrentPosition());
            telemetry.update();

        }
    }
}
