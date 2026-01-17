/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.RobotConstants;
import frc.robot.subsystems.TurretSubsystem;
import frc.robot.utils.PIDControlOutputProcessor;
import frc.robot.vision.PhotonTurretAimer;

import java.util.OptionalDouble;

/**
 *
 * @author aryan
 */
public class SnapToVisionTargetCommand extends EntechCommand {

    private TurretSubsystem turret;
    private PIDController controller;
    private double offset;
    private double output = 0.0;
    private PhotonTurretAimer aimer;
    public static final double TIMEOUT_SECONDS=2;
    private int count = 0;
    private double TOLERANCE = 5;

    public SnapToVisionTargetCommand(TurretSubsystem turret) {
        super(turret,TIMEOUT_SECONDS);
        this.turret = turret;
        this.aimer = new PhotonTurretAimer(RobotConstants.DEFAULTS.VISION.CAMERA_NAME, RobotConstants.DEFAULTS.VISION.APRILTAG_ID);
        this.controller = new PIDController(RobotConstants.PID.AUTO_TURN.P,
            RobotConstants.PID.AUTO_TURN.I,
            RobotConstants.PID.AUTO_TURN.D);
    }
    @Override
    public void initialize(){
        controller.setSetpoint(0);
        controller.setTolerance(2);
    }

    @Override
    public void execute(){
        OptionalDouble yawOpt = aimer.getYawOffsetDegrees();
        if (yawOpt.isPresent()) {
            offset = yawOpt.getAsDouble();
            output = controller.calculate(offset);
            output = PIDControlOutputProcessor.constrainWithMinBounds(output, 0.2, 0.0);
            turret.turnTurret(output);
        }
/*
            if (offset < -TOLERANCE){
                turret.adjustTurretClockwise();
            }
            else if (offset > TOLERANCE){
                turret.adjustTurretCounterClockwise();
            }
            else{
                turret.reset();
            }
*/
    }

    @Override
    public boolean isFinished(){
        if(controller.atSetpoint()){
            count += 1;
        } else {
            count = 0;
        }
        boolean hasTarget = aimer.getYawOffsetDegrees().isPresent();
        return count > 3 || !hasTarget;
    }

}
