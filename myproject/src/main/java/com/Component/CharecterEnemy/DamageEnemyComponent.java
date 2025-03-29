package com.Component.CharecterEnemy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.GameEvent.BackMainScene;
import com.GameEvent.SystemEvent;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class DamageEnemyComponent extends Component {
    private static int attack;

     private static Entity Hero;

    private static Entity targetEnemy; 


    public DamageEnemyComponent(int attack) {
        this.attack = attack;
    }

    public static int getDamage() {
        return attack;
    }

    public static void setDamage(int damage) {
       attack = damage;
    }

    public static void decreaseHP() {

        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy, EnemyType.HighEnermy, EnemyType.BossMonster)
                    .stream()
                    .filter(enemy -> enemy.getComponent(StatusComponent.class).getHPCharacter() > 0)
                    .collect(Collectors.toList());

        List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero ,PlayerType.Combat)
                    .stream()
                    .filter(player -> player.getComponent(StatusComponent.class).getHPCharacter() > 0)
                    .collect(Collectors.toList());

        

        for(Entity enemy : enemies) { 

        Random random = new Random();
        Entity targetPlayer = players.get(random.nextInt(players.size()));
        StatusComponent playerStatus = targetPlayer.getComponent(StatusComponent.class);
        DamageEnemyComponent enemyStatus = enemy.getComponent(DamageEnemyComponent.class);
        int attacks = enemyStatus.getDamage();

        FXGL.set("HP", playerStatus.getHPCharacter() - attacks);
        playerStatus.setHPCharacter(playerStatus.getHPCharacter() - attacks);
        FXGL.getNotificationService().pushNotification("💥 Enemy attacks you with " + attacks + " damage!");    
       
        
        if (playerStatus.getHPCharacter() <= 0) {
            FXGL.getGameWorld().removeEntity(Hero);
            FXGL.getNotificationService().pushNotification("💀 " + playerStatus.getName() + " has been defeated!!");
            SystemEvent.eventBus.fireEvent(new BackMainScene(BackMainScene.BACKTOMAINSCENE));
            OrderCombat.setPlayerTurn (true);

            
        } 
        
    }
    
        if(players.isEmpty()){

            FXGL.getGameController().startNewGame();
        }


}

}
