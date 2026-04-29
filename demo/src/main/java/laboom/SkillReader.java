package laboom;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class SkillReader {

    public SkillReader() {}

    public Skill[] readSkills () {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        

        try (FileReader reader = new FileReader("Jobconfig.json")) {
            Skill[] skills = gson.fromJson(reader, Skill[].class);

            return skills;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    
}
