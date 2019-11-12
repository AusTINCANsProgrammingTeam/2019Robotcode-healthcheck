package frc.team2158.robot.command;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import java.util.logging.Logger;

import com.revrobotics.CANEncoder;

import frc.team2158.robot.subsystem.drive.DriveSubsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * @author Jack Lewis
 * @version 0.0.1
 * Check that the drive subsystem is working
 */

 public class DriveCheck extends Command {
    
    private static final Logger LOGGER = Logger.getLogger(DriveCheck.class.getName());
    private int counter;
    private DriveSubsystem driveSubsystem;
    private CANEncoder leftEncoder;
    private CANEncoder rightEncoder;

    public DriveCheck() {

        requires(Robot.getDriveSubsystem());
        this.driveSubsystem = Robot.getDriveSubsystem();
        leftEncoder = driveSubsystem.rightSpeedController.master.getEncoder(); // ISSUE SparkMaxGroup does not have this functionality
        rightEncoder = driveSubsystem.leftSpeedController.master.getEncoder(); // ISSUE SparkMaxGroup does not have this functionality
        
    }
 
    @Override
    protected void initialize() {

        this.counter = 0;

    }

    @Override
    protected void execute() { // NOTE : 50 * 20 ms = 1 s

        if (counter == 0) {

            LOGGER.info("[" + counter + "]" + "Gear is " + driveSubsystem.getGearMode());
            LOGGER.info("[" + counter + "]" + "Toggling gear... ");
            driveSubsystem.toggleGearMode();
            LOGGER.info("[" + counter + "]" + "Gear is now " + driveSubsystem.getGearMode());

        }
     
        if (counter == 50) {

            LOGGER.info("[" + counter + "]" + "Gear is " + driveSubsystem.getGearMode());
            LOGGER.info("[" + counter + "]" + "Toggling gear... ");
            driveSubsystem.toggleGearMode();
            LOGGER.info("[" + counter + "]" + "Gear is now " + driveSubsystem.getGearMode());

        }

        if (counter > 150 && counter < 175) {

            LOGGER.info("[" + counter + "]" + "Driving forward for half a second... ");
            driveSubsystem.tankDrive(0.1, 0.1);

        }


        if (counter > 250 && counter < 275) {

            LOGGER.info("[" + counter + "]" + "Driving backwards for half a second... ");
            driveSubsystem.tankDrive(-0.1, -0.1);


        }

        if ( ( counter == 150 ) || ( counter == 162 ) || ( counter == 175 ) || ( counter == 250 ) || ( counter == 262 ) || ( counter == 275 ) ) {
            
            LOGGER.info("[" + counter + "]" + "Left motor is at " + driveSubsystem.leftSpeedController.master.getOutputCurrent() + " amps"); // ISSUE SparkMaxGroup does not have this functionality
            LOGGER.info("[" + counter + "]" + "Right motor is at " + driveSubsystem.rightSpeedController.master.getOutputCurrent() + " amps"); // ISSUE SparkMaxGroup does not have this functionality
            

            LOGGER.info("[" + counter + "]" + "Left encoder is at " + leftEncoder.getPosition());
            LOGGER.info("[" + counter + "]" + "Right encoder is at " + rightEncoder.getPosition());
        }

        

        this.counter ++; // Increment counter that tells this function what part of the check to do. This counter increases roughly every 20 ms, the speed of the RoboRIO's ticks

    }

    @Override
    protected boolean isFinished() {

        return counter > 175; // End command when counter has reached its maximum value, when command is finished with its tasks.

    }
}
