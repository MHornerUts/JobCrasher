package laboom;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Coverwriter {
    public Coverwriter() {

    }

    public void genCover(Skill[] skills) {
        try {
            File myObj = new File("Cover.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created successfully");
            } else {
                myObj.delete();
                System.out.println("File already exists");
                
            }
        } catch (IOException e) {
            System.out.println("File broke");
        }

        try (FileWriter writer = new FileWriter("Cover.txt")) {
                for (int i = 0; i< skills.length; i++) {
                    writer.write(skills[i].desc);
                    writer.write("\n\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
        }
        
        
    }

}
