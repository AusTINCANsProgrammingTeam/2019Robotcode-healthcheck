package frc.team2158.robot;

import java.io.*;

public class TestDetails {

    public String name;
    public String description;
    public boolean condition;

    public TestDetails(String name, String description, boolean condition){
        this.name = name;
        this.description = description;
        this.condition = condition;
    }

    public void writeToFile(String path) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write("\nTestDetails\nName of the test : " + name + "\nDescription of a test : " + description + "\n Success : " + condition);
    }

}