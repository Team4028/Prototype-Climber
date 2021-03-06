// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ClimberMotor;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RightZeroSequence extends SequentialCommandGroup {
  /** Creates a new CurrentZeroSequence. */
  public RightZeroSequence() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new RightCurrentZero(),
      new InstantCommand(() -> ClimberMotor.get_instance().setRightEncoder(0.)),
      new MoveRightArm(0.1, 10),
      new InstantCommand(() -> ClimberMotor.get_instance().setRightEncoder(0.))
    );
  }
}
