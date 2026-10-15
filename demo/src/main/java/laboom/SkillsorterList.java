package laboom;
import java.util.ArrayList;

public class SkillsorterList {
    public void bubblesort(ArrayList<Skill> skills) {
        int i , j;
        Skill temp;
        boolean swapped;
        for (i = 0; i < skills.size() - 1; i++) {
            swapped = false;
            for (j = 0; j < skills.size() - i - 1; j++){
                if (skills.get(j).weight > skills.get(j+1).weight) {
                    temp = skills.get(j);
                    skills.set(j, skills.get(j+1));
                    skills.set(j+1, temp);
                    swapped = true; 
                }
            }

            if (swapped == false)
                break;
        }
    }

}
