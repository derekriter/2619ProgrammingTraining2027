package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TestSubsystem;

public class BothMotorDriveCommand extends Command {
    
    private TestSubsystem testSub;
    private Joystick joystick;

    public BothMotorDriveCommand(TestSubsystem _testSub, Joystick _joystick) {
        testSub = _testSub;
        joystick = _joystick;

        addRequirements(testSub);
    }

    @Override
    public void execute() {
        double power = -joystick.getY();

        testSub.setLeftPower(power);
        testSub.setRightPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        testSub.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
