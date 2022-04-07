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
    _left = new CANSparkMax(4, MotorType.kBrushless);
    _right = new CANSparkMax(3, MotorType.kBrushless);
    _left.restoreFactoryDefaults();
    _right.restoreFactoryDefaults();
    _left.setSmartCurrentLimit(60);
    _right.setSmartCurrentLimit(60);
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

 /* public void leftMotorEncoderUp() {
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
*/
  // SmartDashboard.putNumber("Left: ", _leftEncoder.getPosition());
  public void leftMotorForward(double speed) {
    _left.set(speed);
    System.out.println((_leftEncoder.getPosition() - leftEncoderOffset));
  }

  public void leftMotorBackward(double speed) {
    _left.set(speed);
    System.out.println((_leftEncoder.getPosition() - leftEncoderOffset));
  }

  public void rightMotorForward(double speed) {
    _right.set(speed);
    System.out.println(_right.getOutputCurrent());
  }

  public void rightMotorBackward(double speed) {
    _right.set(speed);
    System.out.println((_rightEncoder.getPosition() - rightEncoderOffset));
  }

  public void slowDrop() {
    _right.set(0.25);
    _left.set(.25);
    System.out.println((_leftEncoder.getPosition() - leftEncoderOffset));
  }

  public void leftMotorOff() {
    _left.set(0.);

  }

  public void rightMotorOff() {
    _right.set(0.);

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

  public static ClimberMotor get_instance() {
    return _climber;
  }
  
  public double rightCurrent() {
   return _right.getOutputCurrent();
  }

  public void setRampRate(double rate) {
    _right.setOpenLoopRampRate(rate);
  }

  public void setRightEncoder(double val) {
    _rightEncoder.setPosition(val);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left", (_leftEncoder.getPosition() - leftEncoderOffset));
    SmartDashboard.putNumber("Right", (_rightEncoder.getPosition() - rightEncoderOffset));
    SmartDashboard.putNumber("Left curret", _left.getOutputCurrent());
    SmartDashboard.putNumber("Right current", _right.getOutputCurrent());
  }
}
