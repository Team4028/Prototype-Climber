// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ClimberMotor;
import frc.robot.subsystems.ClimberSolenoid;


public class highBarClimb extends SequentialCommandGroup {
  ClimberMotor _i = ClimberMotor.get_instance();
  ClimberSolenoid _s = ClimberSolenoid.getInstance();
  /** Add your docs here. */
  public highBarClimb() {
    addCommands(new MoveLeftArm(-.8, 8), 
    new WaitCommand(.25),
    new MoveLeftArm(0.25, 45), 
    new WaitCommand(.25), 
    new MoveLeftArm(0.8, 60),  
    new WaitCommand(.5), 
    new ToggleGrippySoliniod(),  
    new WaitCommand(3), 
    new MoveLeftArm(0.8, 180),  
    new WaitCommand(1),  
    new ToggleGrippySoliniod(),  
    new WaitCommand(1), 
    new MoveLeftArm(-0.8, 30), 
    new WaitCommand(.25), 
    new MoveLeftArm(0.25, 70), 
    new WaitCommand(.25),  
    new MoveLeftArm(-0.8, 15), 
    new WaitCommand(.25), 
    new MoveLeftArm(0.25, 40));  
    //instant command for solenoids
    //,command,new command, new command, new command
  }


}
