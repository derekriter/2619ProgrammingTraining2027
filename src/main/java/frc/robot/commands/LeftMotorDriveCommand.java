package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TestSubsystem;

public class LeftMotorDriveCommand extends Command {
    
    private TestSubsystem testSub;
    private Joystick joystick;

    public LeftMotorDriveCommand(TestSubsystem _testSub, Joystick _joystick) {
        testSub = _testSub;
        joystick = _joystick;

        addRequirements(testSub);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        //no deadband because I'm lazy
        testSub.setLeftPower(-joystick.getY());
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
