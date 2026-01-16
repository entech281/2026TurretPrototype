package com.revrobotics;

public class CANSparkMax {
    public CANSparkMax(int deviceId, Object motorType) {}

    public void restoreFactoryDefaults() {}

    public CANPIDController getPIDController() { return new CANPIDController(this); }

    public void setSmartCurrentLimit(int amps) {}

    public void setClosedLoopRampRate(double seconds) {}

    public void setOpenLoopRampRate(double seconds) {}

    public void setInverted(boolean inverted) {}

    public void setIdleMode(Object mode) {}

    public Encoder getEncoder() { return new Encoder(); }

    public void set(double value) {}

    public static class Encoder {
        public double getPosition() { return 0.0; }
        public void setPosition(double pos) {}
        public double getVelocity() { return 0.0; }
    }

    public static enum IdleMode {
        kBrake,
        kCoast
    }
}
