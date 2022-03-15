// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotor;

public class MotorUpEncoder extends CommandBase {
  ClimberMotor _m = ClimberMotor.get_instance();
  /** Creates a new ToggleMotorEncoder. */
  public MotorUpEncoder() {
    addRequirements(_m);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _m.setLeftEncoderFinished(false);
    _m.setRightEncoderFinished(false);
    //_m.leftMotorEncoderUp();
    //_m.rightMotorEncoderUp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //_m.leftMotorEncoderUp();
    //_m.rightMotorEncoderUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _m.leftMotorOff();
    _m.rightMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _m.getLeftEncoderFinished();
  }
}
