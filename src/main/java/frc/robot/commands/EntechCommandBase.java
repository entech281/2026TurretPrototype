/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.logger.DataLogger;
import frc.robot.logger.DataLoggerFactory;
import frc.robot.subsystems.EntechSubsystem;

public class EntechCommand extends Command {

    public static final double DEFAULT_TIMEOUT_SECONDS = 33;
    protected DataLogger logger;

    public EntechCommand(EntechSubsystem sub) {
        this(sub, DEFAULT_TIMEOUT_SECONDS);
        logger = DataLoggerFactory.getLoggerFactory().createDataLogger(this.getName());
    }

    public EntechCommand(EntechSubsystem sub1, EntechSubsystem sub2) {
        addRequirements(sub1, sub2);
        logger = DataLoggerFactory.getLoggerFactory().createDataLogger(this.getName());
    }
    
    
    public EntechCommand(EntechSubsystem subsystem, double timeout) {
        addRequirements(subsystem);
    }
}