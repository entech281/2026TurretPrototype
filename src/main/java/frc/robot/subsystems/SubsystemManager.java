package frc.robot.subsystems;

import java.util.Arrays;

import frc.robot.pose.FieldPose;
import frc.robot.pose.FieldPoseManager;
import frc.robot.pose.PoseSource;
import frc.robot.pose.RobotPose;
import frc.robot.pose.RobotPoseManager;

public class SubsystemManager implements PoseSource{

    boolean hasClimb = false;

    public SubsystemManager() {
    }

    // public DriveSubsystem getDriveSubsystem() {
    //     return driveSubsystem;
    // }

    // public ElevatorSubsystem getElevatorSubsystem() {
    //     return elevatorSubsystem;
    // }

    public IntakeSubsystem getIntakeSubsystem() {
        return intakeSubsystem;
    }

    // public ClimbSubsystem getClimbSubsystem() {
    //     return climbSubsystem;
    // }

    public ShooterSubsystem getShooterSubsystem() {
        return shooterSubsystem;
    }

    public VisionSubsystem getVisionSubsystem(){
    // disabled for throwaway migration
    return null;
    }

    public HoodSubsystem getHoodSubsystem() {
        return hoodSubsystem;
    }

    public TurretSubsystem getTurretSubsystem() {
        return turretSubsystem;
    }

    // private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;
    // private ElevatorSubsystem elevatorSubsystem;
    private ShooterSubsystem shooterSubsystem;
    // private ClimbSubsystem climbSubsystem;
    private HoodSubsystem hoodSubsystem;
    private TurretSubsystem turretSubsystem;

    private final RobotPoseManager robotPoseManager = new RobotPoseManager();
    private final FieldPoseManager fieldPoseManager = new FieldPoseManager();
    public void setHoodSubsystem(HoodSubsystem hoodSubsystem) {
        this.hoodSubsystem = hoodSubsystem;
    }

    public void initAll() {
        // driveSubsystem = new DriveSubsystem();
        intakeSubsystem = new IntakeSubsystem();
        shooterSubsystem = new ShooterSubsystem();
        hoodSubsystem  = new HoodSubsystem();
        turretSubsystem = new TurretSubsystem();

        Arrays.asList(
            intakeSubsystem,
            shooterSubsystem,
            hoodSubsystem,
            turretSubsystem).forEach(subsystem -> subsystem.initialize());

    }
    public void updatePoses() {
        // reduced/disabled in throwaway migration
    }
    public void updateFieldPoses() {
        // no-op
    }

    @Override
    public RobotPose getRobotPose() {
        return robotPoseManager.getCurrentPose();
    }

    @Override
    public FieldPose getFieldPose() {
        return fieldPoseManager.getCurrentPose();
    }

    @Override
    public String getVisionFieldPath() {
        return fieldPoseManager.getCurrentVisionFieldPath();
    }
}
