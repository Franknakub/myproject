package com.Skill;

public class HeavyAttack implements Skill {
    private String skillName;
    private int skillDamage;
    private int manaCost;

    public HeavyAttack(int attackPower, int manaCost) {
        this.skillName = "Heavy Attack";
        this.skillDamage = attackPower;
        this.manaCost = manaCost; // กำหนดความเสียหายของสกิล
    }

    @Override
    public String getskillname() {
        return skillName;
    }

    @Override
    public int getskilldamage() {
        return skillDamage;
    }

    @Override
    public int getManacost() {
        return manaCost; // กำหนดค่ามานาที่ใช้ในการใช้สกิล
    }


    
}
