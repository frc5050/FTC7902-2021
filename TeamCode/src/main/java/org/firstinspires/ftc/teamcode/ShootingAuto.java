package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous
public class ShootingAuto extends LinearOpMode {
    Robot robot = new Robot();


    public void runOpMode() {
        robot.init(hardwareMap);

    }
}
