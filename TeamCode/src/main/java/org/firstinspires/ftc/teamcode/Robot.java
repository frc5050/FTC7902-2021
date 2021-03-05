package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;
    public DcMotor leftShooter;
    public DcMotor rightShooter;
    public DcMotor belt;
    public DcMotor intake;


    public Robot (){
    }

    public void init (HardwareMap hardwareMap){

        leftFront  = hardwareMap.get(DcMotor.class, "left_front");
        leftBack  = hardwareMap.get(DcMotor.class, "left_back");
        rightFront  = hardwareMap.get(DcMotor.class, "right_front");
        rightBack  = hardwareMap.get(DcMotor.class, "right_back");
        leftShooter  = hardwareMap.get(DcMotor.class, "left_shooter");
        rightShooter  = hardwareMap.get(DcMotor.class, "right_shooter");
        belt  = hardwareMap.get(DcMotor.class, "belt");
        intake  = hardwareMap.get(DcMotor.class, "intake");
        leftFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.REVERSE);
        rightFront.setDirection(DcMotor.Direction.FORWARD);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotor.Direction.FORWARD);

    }
    public void encoderDrive(double speed, double leftInches, double rightInches){
        final double COUNTS_PER_REV = 1024;
        final double WHEEL_DIAMETER_INCHES = 4;
        final double COUNTS_PER_INCH = COUNTS_PER_REV / (WHEEL_DIAMETER_INCHES * Math.PI);
        int newRightTarget = rightFront.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
        int newLeftTarget = leftFront.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
    }









}
