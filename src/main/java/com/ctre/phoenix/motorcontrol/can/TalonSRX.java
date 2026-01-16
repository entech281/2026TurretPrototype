package com.ctre.phoenix.motorcontrol.can;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class TalonSRX {
    public TalonSRX(int id) {}

    public ErrorCode configPeakCurrentLimit(int limit) { return ErrorCode.OK; }

    public void selectProfileSlot(int slot, int pid) {}
    public void setSelectedSensorPosition(int pos, int pid, int timeoutMs) {}
    public void configSelectedFeedbackSensor(Object device, int pid, int timeoutMs) {}
    public void setStatusFramePeriod(int frame, int ms, int timeoutMs) {}
    public void setSensorPhase(boolean phase) {}
    public void setInverted(boolean inverted) {}
    public void configNominalOutputForward(double value, int timeoutMs) {}
    public void set(int control, double value) {}
    public void set(com.ctre.phoenix.motorcontrol.ControlMode mode, double value) {}
    public double getSelectedSensorPosition() { return 0; }
    public int getSelectedSensorVelocity(int pidSlot) { return 0; }
    public int isRevLimitSwitchClosed() { return 0; }
    public int isFwdLimitSwitchClosed() { return 0; }
}
