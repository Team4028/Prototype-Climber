// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberMotor;


public class highBarClimb extends SequentialCommandGroup {
  ClimberMotor _i = ClimberMotor.get_instance();
  /** Add your docs here. */
  public highBarClimb() {
    addCommands(new moveGrippyArm(-.8, 50));
  }


}
