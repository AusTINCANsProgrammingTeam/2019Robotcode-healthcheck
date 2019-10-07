package frc.team2158.robot.command;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import java.util.logging.Logger;
import frc.team2158.robot.command.DriveCheck;
// import frc.team2158.robot.command.LiftCheck;
import edu.wpi.first.wpilibj.command.CommandGroup;
// import frc.team2158.robot.command.CheckIntake;

/**
* @author Jack Lewis
* @version 0.0.1
* Runs individual subsystems' diagnostic checks
*/

public class HealthCheck extends CommandGroup {
    public HealthCheck() {
    	addSequential(new DriveCheck());
        // addSequential(new CheckIntake());
        // addSequential(new LiftCheck());
    }
}