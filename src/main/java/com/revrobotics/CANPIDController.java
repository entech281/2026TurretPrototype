package com.revrobotics;

public class CANPIDController {
    private final CANSparkMax spark;
    public enum AccelStrategy { kTrapezoidal }

    public CANPIDController(CANSparkMax spark){ this.spark = spark; }

    public void setOutputRange(double min, double max) {}
    public void setFF(double f, int slot) {}
    public void setI(double i, int slot) {}
    public void setP(double p, int slot) {}
    public void setD(double d, int slot) {}
    public void setIZone(int i, int slot) {}
    public void setSmartMotionAccelStrategy(AccelStrategy s, int slot) {}
    public void setSmartMotionAllowedClosedLoopError(int err, int slot) {}
    public void setSmartMotionMaxAccel(int accel, int slot) {}
    public void setSmartMotionMaxVelocity(int vel, int slot) {}
    public void setReference(double value, ControlType type) {}
    public void setReference(double value, ControlType type, int slot) {}
}
