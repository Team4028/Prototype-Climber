// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ClimberMotor;
import frc.robot.subsystems.ClimberSolenoid;

/** Add your docs here. */
public class RobotContainer {
    BeakXBoxController _con = new BeakXBoxController(0);
    ClimberSolenoid _s = ClimberSolenoid.getInstance();
    ClimberMotor _m = ClimberMotor.getInstance();
  
    public RobotContainer() {
        configureButtonBindings();
    }

    public void configureButtonBindings() {
        _con.a.whenPressed(new InstantCommand(() -> _s.toggleTippySolenoid()));
        _con.left_bumper.whenPressed(new InstantCommand(() -> _m.leftMotorForward()));
        _con.start.whenPressed(new InstantCommand(() -> _m.leftMotorBackward()));

        _con.y.whenPressed(new InstantCommand(() -> _m.leftMotorForward()).alongWith(new InstantCommand(() -> _m.rightMotorForward())));
        _con.x.whenPressed(new InstantCommand(() -> _m.leftMotorBackward()).alongWith(new InstantCommand(() -> _m.rightMotorBackward())));
        
        _con.b.whenPressed(new InstantCommand(() -> _s.toggleGrippySolenoid()));
        _con.right_bumper.whenPressed(new InstantCommand(() -> _m.rightMotorForward()));
        _con.back.whenPressed(new InstantCommand(() -> _m.rightMotorBackward()));
        _con.right_stick_button.whenPressed(new InstantCommand(() -> _m.rightMotorOff()).alongWith(new InstantCommand(() -> _m.leftMotorOff())));
    }
}
