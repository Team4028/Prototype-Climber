// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.security.DrbgParameters.Reseed;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberMotor extends SubsystemBase {
  CANSparkMax _leftClimberMotor;
  CANSparkMax _rightClimberMotor;
  double counter = 0;
  private double encoderOffset = 0;
  RelativeEncoder _GrippyEncoderLeft;
   RelativeEncoder _GrippyEncoderRight;
  private static ClimberMotor _climber = new ClimberMotor();
  /** Creates a new ClimberMotor. */
  public ClimberMotor() {
    _leftClimberMotor = new CANSparkMax(1, MotorType.kBrushless);
    _rightClimberMotor = new CANSparkMax(4, MotorType.kBrushless);
    _leftClimberMotor.restoreFactoryDefaults();
    _rightClimberMotor.restoreFactoryDefaults();
    _leftClimberMotor.setSmartCurrentLimit(40);
    _rightClimberMotor.setSmartCurrentLimit(40);
    _leftClimberMotor.setIdleMode(IdleMode.kBrake);
    _rightClimberMotor.setIdleMode(IdleMode.kBrake);
    _GrippyEncoderLeft = _leftClimberMotor.getEncoder();
    _GrippyEncoderRight = _rightClimberMotor.getEncoder();
    
  }

  public void leftMotorForward() {
    _leftClimberMotor.set(0.5);
    System.out.println("leftmotorforward");
  }

  public void leftMotorBackward() {
    _leftClimberMotor.set(-0.5);
  }
  public double getEncoderPosition()
  {
    return (_GrippyEncoderLeft.getPosition() - encoderOffset);
  }
  
  public void resetEncoder(){
    encoderOffset = _GrippyEncoderLeft.getPosition();
  }
  public void leftMotorEncoderUp() {
    if (_GrippyEncoderLeft.getPosition() < 15) {
      _leftClimberMotor.set(.5);
    } else {
      _leftClimberMotor.set(0);
      resetEncoder();
    }
  }
  public void leftMotorEncoderDown() {
    if (_GrippyEncoderLeft.getPosition() < 15) {
      _leftClimberMotor.set(-.5);
    } else {
      _leftClimberMotor.set(0);
      resetEncoder();
    }
  }
  public void rightMotorEncoderUp() {
    if (_GrippyEncoderRight.getPosition() < 15){
      _rightClimberMotor.set(.5);
    } else {
      _rightClimberMotor.set(0);
      resetEncoder();
    }
  }
  public void rightMotorEncoderDown() {
    if (_GrippyEncoderRight.getPosition() < 15) {
      _rightClimberMotor.set(-.5);
    } else {
      _rightClimberMotor.set(0);
      resetEncoder();
    }
  }
  public void leftMotorOff() {
    _leftClimberMotor.set(0.);
  }
  

  public void rightMotorForward() {
    _rightClimberMotor.set(-0.5);
    System.out.println("rightmotorforward");
  }

  public void rightMotorBackward() {
    _rightClimberMotor.set(0.5);
  }

  public void rightMotorOff() {
    _rightClimberMotor.set(0.);
  }

  public static ClimberMotor getInstance() {
    return _climber;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (counter > 200){
    System.out.println("Left Motor Current" + Double.toString(_leftClimberMotor.getOutputCurrent() * 1000.0));
    System.out.println("Right Motor Current" + Double.toString(_rightClimberMotor.getOutputCurrent() * 1000.0));
    counter = 0;
    }
    counter++;
  }
}
