// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSolenoid extends SubsystemBase {

  // NOTE: tippy is the small one that doesn't extend
  // grippy is the tall one that does extend
  private Solenoid _stippy;
  private Solenoid _sgrippy;

  private static ClimberSolenoid _i = new ClimberSolenoid();
  /** Creates a new Sneed. */
  public ClimberSolenoid() {
    _stippy = new Solenoid(PneumaticsModuleType.CTREPCM, 1);
    _sgrippy = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  }

  public void toggleTippySolenoid() {
    _stippy.set(!_stippy.get());
  }

  public void toggleGrippySolenoid() {
    _sgrippy.set(!_sgrippy.get());
  }

  public static ClimberSolenoid getInstance() {
    return _i;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
