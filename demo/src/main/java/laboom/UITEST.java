package laboom;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class UITEST {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel checkPanel = new JPanel();
    JPanel textPanel = new JPanel();
    JTextArea basic = new JTextArea();

    public UITEST() {
     
        JButton bt1 = new JButton("Add");



        addSkills(this.panel);
        


        checkPanel.add(bt1);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 menuTwo();    
            }
        });

        
        frame.add(panel);

        textPanel.add(basic);
        basic.setLineWrap(true);
        basic.setWrapStyleWord(true);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public void updateExample(ArrayList<Skill> selected) {
        SkillsorterList sorter = new SkillsorterList();
        sorter.bubblesort(selected);

        basic.setText("");
        for (Skill skill : selected) {
            basic.append(skill.desc);
            basic.append("\n\n");      
        } 
        frame.pack();
        
    }

    public void addExample(Skill skill, ArrayList<Skill> selected) {
        selected.add(skill);
        updateExample(selected);
    }

    public void removeExample(Skill skill, ArrayList<Skill> selected) {
        for (int i = 0 ; i < selected.size(); i++) {
                if (skill.name.equals(selected.get(i).name)) {
                    selected.remove(i);
                    break;
                }
        }
        updateExample(selected);
    }

    public void addSkills(JPanel panel) {
        SkillReader read = new SkillReader();
        Skill[] skills = read.readSkills(); 
        panel.setLayout(new GridLayout(0, 1));
        textPanel.setLayout(new GridLayout(0, 1));
        JLabel l1 = new JLabel("Example:");
        textPanel.add(l1);
        JScrollPane scroll = new JScrollPane(textPanel);
        ArrayList<Skill> selected = new ArrayList<Skill>();
        //scroll.setVerticalScrollBarPolicy(100);
        
        if (skills != null) {
            JButton bt2 = new JButton("Create");
            JCheckBox[] checks = new JCheckBox[skills.length];
                   
            for (int i = 0; i < skills.length; i++) {
                checks[i] = new JCheckBox(skills[i].name);
                JCheckBox current = checks[i];
                Skill temp = skills[i];
                current.addActionListener(new ActionListener() {
                    Skill y = temp;
//Adds text to example area in prog
                    public void actionPerformed(ActionEvent ae) {
                        
                        if (current.isSelected()) {     
                            addExample(y, selected);
                            
                        } else {
                            removeExample(y, selected);
                            
                        }
                    }
                });
                checkPanel.add(checks[i]);

            } 
        

            bt2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    int num = 0;
                    for (int i = 0; i < checks.length; i++) {
                        if (checks[i].isSelected()) {
                            num++;
                        };
                    }
                    if (num > 0) {
                        Skill[] skills2 = new Skill[num];
                        int num2 = 0;
                        for (int i = 0; i < checks.length; i++) {
                            if (checks[i].isSelected()) {
                                skills2[num2] = skills[i];
                                num2++;
                            };
                        }

                        Skillsorter sort = new Skillsorter();
                        sort.bubblesort(skills2, skills2.length);
                        Coverwriter cover = new Coverwriter();
                        cover.genCover(skills2);
                    }   
                }
            });

            //scroll.add(textPanel);
            checkPanel.add(bt2);
            panel.add(checkPanel);
            panel.add(scroll);
        }     
    }

    public void menuTwo () {
        JDialog frame = new JDialog();
        JPanel panel = new JPanel();

        JLabel l1 = new JLabel("Name:");
        JTextField name = new JTextField(10);
        JLabel l2 = new JLabel("Description:");
        JTextArea desc = new JTextArea();
        desc.setBounds(40, 75, 250, 200);
        desc.setLineWrap(true);
        desc.setWrapStyleWord(true);
        JLabel l3 = new JLabel("Weight:");
        JTextField num = new JTextField(10);
        JButton add = new JButton("Add");

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                SkillWriter write = new SkillWriter();
                try {
                    int weight = Integer.parseInt(num.getText());
                    write.writeSkill(name.getText(), desc.getText(), weight);
                    System.out.println("Something happened");
                } catch (Exception e) {
                    System.out.println("Failed");
                }

                name.setText("");
                desc.setText("");
                num.setText("");
                refreshSkills();
                
            }
        });

        panel.add(l1);
        panel.add(name);
        panel.add(l2);
        panel.add(desc);
        panel.add(l3);
        panel.add(num);
        panel.add(add);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);    
    }

    public void refreshSkills () {
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        //JTextField field = new JTextField(10);
        JButton bt1 = new JButton("Add");
        addSkills(panel);

        bt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 menuTwo();    
            }
        });

        panel.add(bt1);
        frame.add(panel);
        frame.pack();    

    }
}

