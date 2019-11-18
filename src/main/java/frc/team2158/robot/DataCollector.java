package frc.team2158.robot;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DataCollector{

    public static void writeToFileJSON(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Data data = createDataObject();
        String json = gson.toJson(data);

        try{
            PrintWriter pw = new PrintWriter("tests.json", "UTF-8");
            pw.println(json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Data createDataObject(){
        Data data = new Data();

        data.setStartingTime(LocalDateTime.now());
        data.setJob("IntakeCheck");
        data.setJobDescription("Checks Double solenoid and SpeedController for Intake Subsystem");
        data.setResult(true);
        data.setEndingTime(LocalDateTime.now());

        return data;
    }



}