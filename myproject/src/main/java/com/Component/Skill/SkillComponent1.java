package com.Component.Skill;

import com.almasb.fxgl.entity.component.Component;

public class SkillComponent1 extends Component {
    private String skillName;
    private int skillDamage;
    private int manaCost;
    
    public SkillComponent1(String skillName,int  skillDamage, int manaCost) {
        this.skillName = skillName;
        this.skillDamage = skillDamage;
        this.manaCost = manaCost; // Default damage
    }

    public String getSkillName() {
        return skillName;
    }

    public int getSkillDamage() {
        return skillDamage;
    }

    public int getmanaCost(){
        return manaCost;
    }
}