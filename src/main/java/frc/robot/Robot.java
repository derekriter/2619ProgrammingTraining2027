// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
    
    private TalonSRX motor;
    private Joystick joystick;

    public Robot() {
        motor = new TalonSRX(2);
        motor.setInverted(InvertType.InvertMotorOutput);
        motor.enableCurrentLimit(true);
        motor.configContinuousCurrentLimit(15);

        joystick = new Joystick(0);
    }
    
    @Override
    public void robotPeriodic() {}
    
    @Override
    public void autonomousInit() {}
    
    @Override
    public void autonomousPeriodic() {}
    
    @Override
    public void teleopInit() {
        
    }
    
    @Override
    public void teleopPeriodic() {
        double rawVal = joystick.getY();
        double yVal = -MathUtil.clamp(rawVal * 50, -1, 1);

        if(Math.abs(rawVal) < 0.1) {
            yVal = 0;
        }

        motor.set(TalonSRXControlMode.PercentOutput, yVal);
    }
    
    @Override
    public void disabledInit() {
        // motor.set(TalonSRXControlMode.PercentOutput, 0);
        motor.neutralOutput();
    }
    
    @Override
    public void disabledPeriodic() {}
    
    @Override
    public void testInit() {}
    
    @Override
    public void testPeriodic() {}
    
    @Override
    public void simulationInit() {}
    
    @Override
    public void simulationPeriodic() {}
}
