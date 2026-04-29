package laboom;

public class Skill {
    String name;
    String desc;
    int weight;

    public Skill (String name, String desc, int weight) {
        this.name = name;
        this.desc = desc;
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        String aboutSkill = "Name: " + this.name + "desc: " + this.desc;
        return aboutSkill;
    }

}
