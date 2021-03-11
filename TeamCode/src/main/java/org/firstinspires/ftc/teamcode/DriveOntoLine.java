package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous

public class DriveOntoLine extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        org.firstinspires.ftc.teamcode.Robot robot = new org.firstinspires.ftc.teamcode.Robot();
        robot.init(hardwareMap);

        waitForStart();
        int startEncoderCount = robot.rightBack.getCurrentPosition();
        while (opModeIsActive()) {
            double cpr = 1024;
            double wheelDiameter = 4; // inches
            double wheelCircumference = wheelDiameter * Math.PI;
            double desiredDistance = 18*2;
            double desiredRevs = desiredDistance / wheelCircumference;
            int desiredEncoderCount = (int) (desiredRevs * cpr);
            int currentEncoderCount = robot.rightBack.getCurrentPosition()-startEncoderCount;
            if (currentEncoderCount < desiredEncoderCount) {
                robot.setSpeeds(0.3, 0.3);
            }else {
                robot.setSpeeds(0, 0);
            }
            telemetry.addData("rightBackEncoder", robot.rightBack.getCurrentPosition());
            telemetry.addData("leftBackEncoder", robot.leftBack.getCurrentPosition());
            telemetry.addData("rightFrontEncoder", robot.rightFront.getCurrentPosition());
            telemetry.addData("leftFrontEncoder", robot.leftFront.getCurrentPosition());
            telemetry.update();

        }
    }
}
