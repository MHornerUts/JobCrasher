package laboom;

import java.io.*;
import java.util.Arrays;

import com.google.gson.Gson;

public class SkillWriter {

    public SkillWriter () {}

    public void writeSkill (String name, String desc, int weight) {
        Gson gson = new Gson();

         try {
            File myObj = new File("Jobconfig.json");
            if (myObj.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                System.out.println("FIle already exists");
                
            }
        } catch (IOException e) {
            System.out.println("File");
        }

        SkillReader reader = new SkillReader();

        if (reader.readSkills() != null) {
            Skill[] skills = Arrays.copyOf(reader.readSkills(), reader.readSkills().length + 1);
            skills[skills.length-1] = new Skill(name, desc, weight);
            
            String jsonInput = gson.toJson(skills);

            try (FileWriter file = new FileWriter("Jobconfig.json")) {
                file.write(jsonInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Skill skill = new Skill(name, desc, weight);
            Skill[] skills = {skill};
            String jsonInput = gson.toJson(skills);

            try (FileWriter file = new FileWriter("Jobconfig.json")) {
                file.write(jsonInput);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
       
    }
}
