// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimberMotor;

public class ZeroWithCurrent extends CommandBase {
  /** Creates a new ZeroWithCurrent. */
  public ZeroWithCurrent() {
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // ClimberMotor.get_instance().setRampRate(10.);
    ClimberMotor.get_instance().rightMotorForward(-.05);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    ClimberMotor.get_instance().rightMotorForward(-.05);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // ClimberMotor.get_instance().setRampRate(0.);
  // ClimberMotor.get_instance().rightMotorForward(0);
  //new moveGrippyArm(0.1, ClimberMotor.get_instance().getRightEncoderPosition() + 10).schedule();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
 
    return ClimberMotor.get_instance().rightCurrent() > 5;
  }
}
