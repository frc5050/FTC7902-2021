package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        org.firstinspires.ftc.teamcode.Robot robot = new org.firstinspires.ftc.teamcode.Robot();
        robot.init(hardwareMap);

        waitForStart();
        while (opModeIsActive()) {
            double leftPower;
            double rightPower;
            boolean intakePower;
            boolean beltPower;
            boolean shooterPowerHigh;
            boolean shooterPowerLow;
            boolean reverseIntakePower;
            boolean reverseBeltPower;
            double shooterPowerMiddle;

            leftPower = -gamepad1.left_stick_y;
            rightPower = -gamepad1.right_stick_y;
            intakePower = gamepad2.a;
            beltPower = gamepad2.b;
            shooterPowerHigh = gamepad2.left_bumper;
            shooterPowerLow = gamepad2.right_bumper;
            shooterPowerMiddle = gamepad2.right_trigger;


            reverseIntakePower = gamepad2.x;
            reverseBeltPower = gamepad2.y;


            robot.leftFront.setPower(leftPower);
            robot.leftBack.setPower(leftPower);
            robot.rightFront.setPower(rightPower);
            robot.rightBack.setPower(rightPower);

            if (intakePower == true) {
                robot.intake.setPower(1);
            } else if (reverseIntakePower == true) {
                robot.intake.setPower(-1);
            } else {
                robot.intake.setPower(0);
            }

            if (beltPower == true) {
                robot.belt.setPower(1);
            } else if (reverseBeltPower == true) {
                robot.belt.setPower(-1);
            } else {
                robot.belt.setPower(0);
            }

            if (shooterPowerHigh == true) {
                robot.rightShooter.setPower(.55);
                robot.leftShooter.setPower(.55);
            } else if (shooterPowerLow == true) {
                robot.rightShooter.setPower(.30);
                robot.leftShooter.setPower(.30);
            } else if (shooterPowerMiddle >= 0.1) {
                robot.rightShooter.setPower(.40);
                robot.leftShooter.setPower(.40);
            } else {
                robot.rightShooter.setPower(0);
                robot.leftShooter.setPower(0);
            }

            idle();


        }
    }
}
