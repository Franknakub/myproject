package com.Component.CharecterHero;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.GameEvent.BackMainScene;
import com.GameEvent.SystemEvent;
import com.Skill.Skill;
import com.Type.Player.PlayerType;

public class DamageHeroComponent extends Component {
    private static int attack;
    private static Entity targetEnemy; 
    private Skill skill;
    private static Entity player;

    public DamageHeroComponent(int attack,Skill skill) {
        this.attack = attack;
        this.skill = skill;
    }

    public int getSkillDamage() {
        return skill.getskilldamage();
    }

    public void setSkillDamage(Skill skill) {
        this.skill = skill;
    }

    public String getSkillName() {
        return skill.getskillname();
    }

    public int getManacost() {
        return skill.getManacost();
    }

    public static int getDamage() {
        return attack;
    }

    public void setDamage(int  damage) {
        this.attack = damage;
    }

    


     public static void decreaseHP() {

            targetEnemy = OrderCombat.getTargetEnemy();

            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);
            status.setHPCharacter(status.getHPCharacter() - attack);
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }
        }
        public static void useSkill() {

            targetEnemy = OrderCombat.getTargetEnemy();
            player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Combat).get(0);
            DamageHeroComponent damage = player.getComponent(DamageHeroComponent.class);
            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);
            status.setHPCharacter(status.getHPCharacter() - damage.getSkillDamage());
            System.out.println("Skill Damage: " + damage.getSkillDamage());
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }
 
            
         }
 

       
}
