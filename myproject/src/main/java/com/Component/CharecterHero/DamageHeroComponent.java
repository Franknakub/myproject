package com.Component.CharecterHero;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.Component.Skill.SkillComponent1;
import com.Component.Skill.SkillComponent2;
import com.Component.Skill.SkillComponent3;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.action.Action;
import com.almasb.fxgl.entity.component.Component;
import com.GameEvent.BackMainScene;
import com.GameEvent.SystemEvent;
import com.Type.Player.PlayerType;
import com.UI.ActionButtonUI;

public class DamageHeroComponent extends Component {
    private static int attack;
    private static Entity targetEnemy; 
    private static Entity player;

    public DamageHeroComponent(int attack) {
        this.attack = attack;
        
    }


 

    public static int getDamage() {
        return attack;
    }

    public void setDamage(int  damage) {
        this.attack = damage;
    }

    


     public static void decreaseHP() {

            targetEnemy = OrderCombat.getTargetEnemy();

            

            player = OrderCombat.getPlayer();


            DamageHeroComponent attack = player.getComponent(DamageHeroComponent.class);

            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);

            status.setHPCharacter(status.getHPCharacter() - attack.getDamage());
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }
        }
        public static void useSkill1() {

            targetEnemy = OrderCombat.getTargetEnemy();

            player = OrderCombat.getPlayer();
            
            SkillComponent1 damage = player.getComponent(SkillComponent1.class);
            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);

             status.setHPCharacter(status.getHPCharacter() - damage.getSkillDamage());
          
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }           
         }

         public static void useSkill2() {

            targetEnemy = OrderCombat.getTargetEnemy();

            player = OrderCombat.getPlayer();
            
            SkillComponent2 damage = player.getComponent(SkillComponent2.class);
            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);

             status.setHPCharacter(status.getHPCharacter() - damage.getSkillDamage());
          
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }
 
            
         }
         public static void useSkill3() {

            targetEnemy = OrderCombat.getTargetEnemy();

            player = OrderCombat.getPlayer();
            
            SkillComponent3 damage = player.getComponent(SkillComponent3.class);
            StatusComponent status = targetEnemy.getComponent(StatusComponent.class);

             status.setHPCharacter(status.getHPCharacter() - damage.getSkillDamage());
          
            if (status.getHPCharacter() <= 0) {
                FXGL.getGameWorld().removeEntity(targetEnemy);
                FXGL.getNotificationService().pushNotification("💀 " + status.getName() + " has been defeated!");

            }
 
            
         }
 
 

       
}
