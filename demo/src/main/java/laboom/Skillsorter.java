package laboom;

public class Skillsorter {
    public void bubblesort(Skill[] skills, int n) {
        int i , j;
        Skill temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++){
                if (skills[j].weight > skills[j+1].weight) {
                    temp = skills[j];
                    skills[j] = skills[j+1];
                    skills[j+1] = temp;
                    swapped = true; 
                }
            }

            if (swapped == false)
                break;
        }
    }

}
