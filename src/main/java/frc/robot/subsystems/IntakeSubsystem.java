package frc.robot.subsystems;

import frc.robot.fake.TalonAdapter;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.RobotConstants;
import static frc.robot.RobotConstants.*;
import frc.robot.controllers.*;

public class IntakeSubsystem extends EntechSubsystem {

    private TalonAdapter intakeMotor;
    private TalonSpeedController intakeMotorController;
    private DoubleSolenoid deployIntakeSolenoids;
    private DoubleSolenoid.Value currentStateIntake;
    private double intakeSpeed = 0.0;

    public static final double INTAKE_ON= 1.0;
    public static final double INTAKE_OFF=0.0;

    @Override
    public void initialize() {

    intakeMotor = new TalonAdapter(RobotConstants.CAN.INTAKE_MOTOR);
    intakeMotorController = new TalonSpeedController(intakeMotor, MOTOR_SETTINGS.INTAKE,false);
        intakeMotorController.configure();
        intakeMotorController.setDesiredSpeed(0);

    deployIntakeSolenoids = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, RobotConstants.CAN.FORWARD, RobotConstants.CAN.REVERSE);
        currentStateIntake = DoubleSolenoid.Value.kReverse;
        updateIntakeSolenoidPosition();
    }

    @Override
    public void periodic() {
	    if (DriverStation.isDisabled()) {
	        // nothing to do at the moment
	    }
        intakeMotorController.setDesiredSpeed(intakeSpeed);
        updateIntakeSolenoidPosition();

        logger.log("Current command", getCurrentCommand());
    }

    public void deployAndStart(){
        deployIntakeArms();
        intakeOn();
    }

    public void raiseAndStop(){
        raiseIntakeArms();
        intakeOff();
    }

    private void deployIntakeArms(){
        currentStateIntake = DoubleSolenoid.Value.kForward;
    }

    private void raiseIntakeArms(){
        currentStateIntake = DoubleSolenoid.Value.kReverse;
    }

    public void intakeOn(){
        setIntakeMotorSpeed(INTAKE_ON);
    }

    public void intakeOff(){
        setIntakeMotorSpeed(INTAKE_OFF);
    }

    public void toggleIntakeArms(){
        if (currentStateIntake == DoubleSolenoid.Value.kForward) {
            currentStateIntake = DoubleSolenoid.Value.kReverse;
        } else {
            currentStateIntake = DoubleSolenoid.Value.kForward;
        }
        if (isIntakeOn()) {
            intakeOff();
        } else {
            intakeOn();
        }
    }

    public boolean isIntakeOn(){
        return intakeMotorController.getDesiredSpeed() != 0;
    }

    public void setIntakeMotorSpeed(double desiredSpeed) {
        intakeSpeed = desiredSpeed;
    }

    public void updateIntakeSolenoidPosition() {
        if ( deployIntakeSolenoids.get() != currentStateIntake ){
            deployIntakeSolenoids.set(currentStateIntake);
        }
    }

}
