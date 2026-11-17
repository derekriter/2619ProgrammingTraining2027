package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.BothMotorDriveCommand;
import frc.robot.commands.LeftMotorDriveCommand;
import frc.robot.subsystems.TestSubsystem;

public class RobotContainer {
    
    private TestSubsystem testSubsystem;

    private CommandJoystick joystick1;

    public RobotContainer() {
        testSubsystem = new TestSubsystem();

        joystick1 = new CommandJoystick(0);

        configureBindings();
    }

    public void configureBindings() {
        joystick1.button(2).onTrue(new LeftMotorDriveCommand(testSubsystem, joystick1.getHID()));

        joystick1.button(1).onTrue(new BothMotorDriveCommand(testSubsystem, joystick1.getHID()));
    }
}
