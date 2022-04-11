// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.RightZeroSequence;
import frc.robot.commands.LeftZeroSequence;
import frc.robot.commands.MotorDownEncoder;
import frc.robot.commands.MotorUpEncoder;
import frc.robot.commands.TraversalBarClimb;
import frc.robot.commands.RightCurrentZero;
import frc.robot.commands.highBarClimb;
import frc.robot.commands.MoveLeftArm;
import frc.robot.subsystems.ClimberMotor;
import frc.robot.subsystems.ClimberSolenoid;

/** Add your docs here. */
public class RobotContainer {
    BeakXBoxController _con = new BeakXBoxController(0);
    ClimberSolenoid _s = ClimberSolenoid.getInstance();
    ClimberMotor _climberMotor = ClimberMotor.get_instance();
  
    public RobotContainer() {
        configureButtonBindings();
    }

    public void configureButtonBindings() {
        _con.a.whenPressed(new InstantCommand(() -> _s.toggleTippySolenoid()));
        _con.left_bumper.whileHeld(new InstantCommand(() -> _climberMotor.leftMotorForward(.12)));
        _con.left_bumper.whenReleased(new InstantCommand(() -> _climberMotor.leftMotorOff()));
        _con.start.whileHeld(new InstantCommand(() -> _climberMotor.rightMotorBackward(-.12)));
        _con.start.whenReleased(new InstantCommand(() -> _climberMotor.rightMotorOff()));

        _con.y.whileHeld(new InstantCommand(() -> _climberMotor.leftMotorForward(.12)).alongWith(new InstantCommand(() -> _climberMotor.rightMotorForward(.12))));
        _con.y.whenReleased(new InstantCommand(() -> _climberMotor.leftMotorOff()).alongWith(new InstantCommand(() -> _climberMotor.rightMotorOff())));
        _con.x.whileHeld(new InstantCommand(() -> _climberMotor.leftMotorBackward(-.12)).alongWith(new InstantCommand(() -> _climberMotor.rightMotorBackward(-.12))));
        _con.x.whenReleased(new InstantCommand(() -> _climberMotor.leftMotorOff()).alongWith(new InstantCommand(() -> _climberMotor.rightMotorOff())));
       
        _con.b.whenPressed(new InstantCommand(() -> _s.toggleGrippySolenoid()));
        _con.right_bumper.whileHeld(new InstantCommand(() -> _climberMotor.rightMotorForward(.06)));
        _con.right_bumper.whenReleased(new InstantCommand(() -> _climberMotor.rightMotorOff()));
        _con.back.whileHeld(new InstantCommand(() -> _climberMotor.leftMotorBackward(-.06)));
        _con.back.whenReleased(new InstantCommand(() -> _climberMotor.leftMotorOff()));
        _con.right_stick_button.whenPressed(new RightZeroSequence());
        _con.right_stick_button.whenPressed(new LeftZeroSequence());
        //_con.left_stick_button.toggleWhenPressed(new MotorDownEncoder());
        //_con.left_stick_button.whenPressed(new highBarClimb());
        //_con.left_stick_button.whenReleased(new InstantCommand(() -> _climberMotor.leftMotorOff()));
        //_con.left_stick_button.whenReleased(new InstantCommand(() -> _climberMotor.rightMotorOff()));
    }
    }

