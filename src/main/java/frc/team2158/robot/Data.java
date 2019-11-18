package frc.team2158.robot;

import java.time.LocalDateTime;

public class Data {

    public LocalDateTime startingTime;
    public LocalDateTime endingTime;
    public String job;
    public String jobDescription;
    public  boolean result;


    public Data(/*boolean result, LocalDateTime startingTime, LocalDateTime endingTime, String job, String jobDescription*/){
        /*this.result = result;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.job = job;
        this.jobDescription = jobDescription;*/
    }

    public void setResult(boolean result){
        this.result = result;
    }

    public void setStartingTime(LocalDateTime startingTime){
        this.startingTime = startingTime;
    }

    public void setEndingTime(LocalDateTime endingTime){
        this.endingTime = endingTime;
    }

    public void setJob(String job){
        this.job = job;
    }

    public void setJobDescription(String jobDescription){
        this.jobDescription = jobDescription;
    }

}