package frc.team2158.robot.command;

import java.util.logging.Logger;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import frc.team2158.robot.Robot;
import frc.team2158.robot.TestDetails;
import frc.team2158.robot.subsystem.intake.IntakeSubsystem;

//Bohdan Khoruzhenko 

public class IntakeCheck extends Command{

    private IntakeSubsystem intakeSubsystem;

    private static final Logger LOGGER = Logger.getLogger(IntakeCheck.class.getName());

    public IntakeCheck(){
        //requires(Robot.getIntakeSubsystem());
        intakeSubsystem = Robot.getIntakeSubsystem();
    }

    @Override
    protected void execute() {
        doubleSolenoidCheck();
        speedControllerCheck();

    }

    public TestDetails speedControllerCheck(){
        boolean result;
        double speed1 = intakeSubsystem.getLeftSC().get();
        LOGGER.info("Speeding up ...");
        intakeSubsystem.getLeftSC().set(0.1);
        double speed2 = intakeSubsystem.getLeftSC().get();

        if(speed1 == speed2){
            result = false;
        }
        
        result = true;
        return new TestDetails("SpeedControllerIntake", "Speed - " + speed2, result);
    }

    public TestDetails doubleSolenoidCheck(){
        boolean result;

        DoubleSolenoid.Value stateA = intakeSubsystem.getSolenoidState();

        LOGGER.info("Current state: " + stateA);
        intakeSubsystem.toggleSolenoidState();
        LOGGER.info("Toggling double solenoid ...");

        DoubleSolenoid.Value stateB = intakeSubsystem.getSolenoidState();

        if(stateA == stateB){
            result = false;
        }

        result = true;

        return new TestDetails("DoubleSolenoidIntake", "State - " + stateB, result);

    } 







    @Override
    protected boolean isFinished() {
        return true;
    }


}