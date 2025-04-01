package com.Skill;

public class InfinityEdge implements Skill {
    private String skillName;
    private int skillDamage;
    private int manaCost;

    public InfinityEdge(int attackPower, int manaCost) {
        this.skillName = "Infinity Edge";
        this.skillDamage = attackPower; // กำหนดความเสียหายของสกิล
        this.manaCost = manaCost; // กำหนดค่ามานาที่ใช้ในการใช้สกิล
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
    public int getmanacost() {
        return manaCost; // กำหนดค่ามานาที่ใช้ในการใช้สกิล
    }
    
}
