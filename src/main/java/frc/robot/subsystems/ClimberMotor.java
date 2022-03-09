// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberMotor extends SubsystemBase {
  CANSparkMax _left;
  CANSparkMax _right;
  double counter = 0;
  private double rightEncoderOffset = 0, leftEncoderOffset = 0;
  RelativeEncoder _leftEncoder, _rightEncoder;
  private static ClimberMotor _climber = new ClimberMotor();
  private boolean leftEncoderFinished = false, rightEncoderFinished = false;

  /** Creates a new ClimberMotor. */
  public ClimberMotor() {
    //1 = production motor
    _left = new CANSparkMax(1, MotorType.kBrushless);
    _right = new CANSparkMax(4, MotorType.kBrushless);
    _left.restoreFactoryDefaults();
    _right.restoreFactoryDefaults();
    _left.setSmartCurrentLimit(40);
    _right.setSmartCurrentLimit(40);
    _left.setIdleMode(IdleMode.kBrake);
    _right.setIdleMode(IdleMode.kBrake);
    _leftEncoder = _left.getEncoder();
    _rightEncoder = _right.getEncoder();

    _leftEncoder.setPosition(0.);
    resetLeftEncoder();

    _rightEncoder.setPosition(0.);
    resetRightEncoder();
  }

  public double getLeftEncoderPosition() {
    return (_leftEncoder.getPosition() - leftEncoderOffset);
  }

  public double getRightEncoderPosition() {
    return (_rightEncoder.getPosition() - rightEncoderOffset);
  }

  public void resetLeftEncoder() {
    leftEncoderOffset = _leftEncoder.getPosition();
  }

  public void resetRightEncoder() {
    rightEncoderOffset = _rightEncoder.getPosition();
  }

  public void leftMotorEncoderUp() {
    if (getLeftEncoderPosition() < 50) {
      leftMotorForward();
    } else {
      leftMotorOff();
    }
  }

  public void leftMotorEncoderDown() {
    if (getLeftEncoderPosition() > -50) {
      leftMotorBackward();
      
      System.out.println(getLeftEncoderPosition());
    } else {
      leftMotorOff();
    }
  }

  public void rightMotorEncoderUp() {
    if (getRightEncoderPosition() < 50) {
      rightMotorForward();
    } else {
      rightMotorOff();
    }
  }

  public void rightMotorEncoderDown() {
    if (getRightEncoderPosition() > -50) {
      rightMotorBackward();
    } else {
      rightMotorOff();
    }
  }

  // SmartDashboard.putNumber("Left: ", _leftEncoder.getPosition());
  public void leftMotorForward() {
    _left.set(0.6);
    System.out.println(_leftEncoder.getPosition());
  }

  public void leftMotorBackward() {
    _left.set(-0.6);
    System.out.println(_leftEncoder.getPosition());
  }

  public void rightMotorForward() {
    _right.set(0.6);
    System.out.println(_rightEncoder.getPosition());
  }

  public void rightMotorBackward() {
    _right.set(-0.6);
    System.out.println(_rightEncoder.getPosition());
  }

  public void leftMotorOff() {
    _left.set(0.);
    resetLeftEncoder();
    leftEncoderFinished = true;
  }

  public void rightMotorOff() {
    _right.set(0.);
    resetRightEncoder();
    rightEncoderFinished = true;
  }

  public boolean getLeftEncoderFinished() {
    return leftEncoderFinished;
  }

  public boolean getRightEncoderFinished() {
    return rightEncoderFinished;
  }

  public void setLeftEncoderFinished(boolean value) {
    leftEncoderFinished = value;
  }

  public void setRightEncoderFinished(boolean value) {
    rightEncoderFinished = value;
  }

  public static ClimberMotor getInstance() {
    return _climber;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left", _leftEncoder.getPosition());
    SmartDashboard.putNumber("Right", _rightEncoder.getPosition());
  }
}
