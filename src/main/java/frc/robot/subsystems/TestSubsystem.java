package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TestSubsystem extends SubsystemBase {

    private TalonSRX leftMotor1;
    private TalonSRX rightMotor1;

    public TestSubsystem() {
        leftMotor1 = new TalonSRX(2);
        rightMotor1 = new TalonSRX(13);

        configureHardware();
    }

    public void setLeftPower(double power) {
        power = MathUtil.clamp(power, -1, 1);

        leftMotor1.set(TalonSRXControlMode.PercentOutput, power);
    }

    public void setRightPower(double power) {
        power = MathUtil.clamp(power, -1, 1);

        rightMotor1.set(TalonSRXControlMode.PercentOutput, power);
    }

    public void stop() {
        leftMotor1.neutralOutput();
        rightMotor1.neutralOutput();
    }

    private void configureHardware() {
        leftMotor1.configContinuousCurrentLimit(20);
        leftMotor1.setInverted(false);

        rightMotor1.configContinuousCurrentLimit(20);
        rightMotor1.setInverted(true);
    }
}