package frc.robot.fake;

/**
 * Minimal Talon adapter used only to satisfy compilation for the turret/hood
 * throwaway migration. Methods are stubs and intentionally minimal — they
 * provide the same names/overloads used by the original code so the project
 * compiles against 2026 dependencies without needing the full CTRE API.
 */
public class TalonAdapter {

    public TalonAdapter(int id) {
        // no-op constructor for the adapter
    }

    public void selectProfileSlot(int profile, int pid) {}

    public void setSelectedSensorPosition(int pos, int pid, int timeout) {}

    public void setSelectedSensorPosition(int pos) {}

    public void configSelectedFeedbackSensor(Object device, int pid, int timeout) {}

    public void configSelectedFeedbackSensor(Object device) {}

    public void setStatusFramePeriod(Object frame, int millis, int timeout) {}

    public void setStatusFramePeriod(Object frame, int millis) {}

    public void setSensorPhase(boolean phase) {}

    public void setInverted(boolean inverted) {}

    public void configNominalOutputForward(double v, int timeout) {}
    public void configNominalOutputReverse(double v, int timeout) {}
    public void configPeakOutputForward(double v, int timeout) {}
    public void configPeakOutputReverse(double v, int timeout) {}

    public void configPeakCurrentLimit(int amps, int timeout) {}
    public void configPeakCurrentLimit(int amps) {}
    public void configPeakCurrentDuration(int ms, int timeout) {}
    public void configPeakCurrentDuration(int ms) {}
    public void configContinuousCurrentLimit(int amps, int timeout) {}
    public void configContinuousCurrentLimit(int amps) {}
    public void enableCurrentLimit(boolean on) {}

    public void setNeutralMode(Object mode) {}

    public void configClosedloopRamp(double v, int timeout) {}
    public void configOpenloopRamp(double v, int timeout) {}
    public void configNeutralDeadband(double v, int timeout) {}

    public void config_kF(int slot, double f, int timeout) {}
    public void config_kP(int slot, double p, int timeout) {}
    public void config_kI(int slot, double i, int timeout) {}
    public void config_kD(int slot, double d, int timeout) {}

    public void config_kF(int slot, double f) {}
    public void config_kP(int slot, double p) {}
    public void config_kI(int slot, double i) {}
    public void config_kD(int slot, double d) {}

    public void configMotionCruiseVelocity(int v, int timeout) {}
    public void configMotionAcceleration(int a, int timeout) {}
    public void configAllowableClosedloopError(int slot, int err, int timeout) {}

    public void set(Object controlMode, double value) {}

    public void configForwardLimitSwitchSource(Object src, Object normal, int param) {}
    public void configReverseLimitSwitchSource(Object src, Object normal, int param) {}
    public void overrideLimitSwitchesEnable(boolean enable) {}

    public SensorCollection getSensorCollection() { return new SensorCollection(); }

    public int isFwdLimitSwitchClosed() { return getSensorCollection().isFwdLimitSwitchClosed() ? 1 : 0; }
    public int isRevLimitSwitchClosed() { return getSensorCollection().isRevLimitSwitchClosed() ? 1 : 0; }

    public int getSelectedSensorPosition() { return 0; }

    public int getSelectedSensorVelocity(int pidSlot) { return 0; }

    public int getClosedLoopError(int slot) { return 0; }

    public void feed() {}

    public static class SensorCollection {
        public boolean isFwdLimitSwitchClosed() { return false; }
        public boolean isRevLimitSwitchClosed() { return false; }
    }
}
