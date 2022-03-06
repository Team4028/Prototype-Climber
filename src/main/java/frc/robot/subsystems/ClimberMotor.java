// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberMotor extends SubsystemBase {
  CANSparkMax _m1;
  CANSparkMax _m2;
  double counter = 0;
  private static ClimberMotor _i = new ClimberMotor();
  /** Creates a new ClimberMotor. */
  public ClimberMotor() {
    _m1 = new CANSparkMax(1, MotorType.kBrushless);
    _m2 = new CANSparkMax(4, MotorType.kBrushless);
    _m1.restoreFactoryDefaults();
    _m2.restoreFactoryDefaults();
    _m1.setSmartCurrentLimit(40);
    _m2.setSmartCurrentLimit(40);
    _m1.setIdleMode(IdleMode.kBrake);
    _m2.setIdleMode(IdleMode.kBrake);
  }

  public void leftMotorForward() {
    _m1.set(0.2);
    System.out.println("leftmotorforward");
  }

  public void leftMotorBackward() {
    _m1.set(-0.5);
  }

  public void leftMotorOff() {
    _m1.set(0.);
  }

  public void rightMotorForward() {
    _m2.set(0.2);
    System.out.println("rightmotorforward");
  }

  public void rightMotorBackward() {
    _m2.set(-0.5);
  }

  public void rightMotorOff() {
    _m2.set(0.);
  }

  public static ClimberMotor getInstance() {
    return _i;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (counter > 200){
    System.out.println("Left Motor Current" + Double.toString(_m1.getOutputCurrent() * 1000.0));
    System.out.println("Right Motor Current" + Double.toString(_m2.getOutputCurrent() * 1000.0));
    counter = 0;
    }
    counter++;
  }
}
