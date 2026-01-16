package frc.robot.controllers;

import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.fake.TalonAdapter;

public class TalonSpeedController extends BaseTalonController implements SpeedController {

    public TalonSpeedController(TalonAdapter talon, TalonSettings settings, boolean reversed) {
        super(talon, settings,reversed);
    }
    private double desiredSpeed = 0.0;

    @Override
    public double getDesiredSpeed() {
        return desiredSpeed;
    }

    @Override
    public double getActualSpeed() {
        return correctDirection((double)talon.getSelectedSensorVelocity(TalonSettings.PID_SLOT));
    }

    @Override
    public void setDesiredSpeed(double desiredSpeed) {
        this.desiredSpeed = desiredSpeed;
        talon.set(settings.controlMode, correctDirection(desiredSpeed));
    }
}