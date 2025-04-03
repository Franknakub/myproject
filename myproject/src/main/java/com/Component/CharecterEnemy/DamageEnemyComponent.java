package com.Component.CharecterEnemy;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.Combat.OrderCombat;
import com.Component.StatusComponent;
import com.GameEvent.BackMainScene;
import com.GameEvent.CombatScene;
import com.GameEvent.SystemEvent;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.UI.ActionButtonUI;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.cutscene.CutsceneService;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class DamageEnemyComponent extends Component {
    private static int attack;

     private static Entity Hero;

    private static Entity targetEnemy; 

    private static ActionButtonUI actionButtonUI;


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

        List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Combat, PlayerType.Mage)
                    .stream()
                    .filter(player -> player.getComponent(StatusComponent.class).getHPCharacter() > 0)
                    .collect(Collectors.toList());


        Random random = new Random();
        Entity targetPlayer = players.get(random.nextInt(players.size()));
        StatusComponent playerStatus = targetPlayer.getComponent(StatusComponent.class);
        

        FXGL.set(playerStatus.getNameHPCharacter(), playerStatus.getHPCharacter() - attack);
        playerStatus.setHPCharacter(playerStatus.getHPCharacter() - attack);  

        FXGL.getNotificationService().pushNotification("💥 " + playerStatus.getName() + " takes " + attack + " damage!");
       
        
        if (playerStatus.getHPCharacter() <= 0) {
            FXGL.getGameWorld().removeEntity(targetPlayer);
            FXGL.getNotificationService().pushNotification("💀 " + playerStatus.getName() + " has been defeated!!");

            if(players.isEmpty()){
              
            OrderCombat.setPlayerTurn (true);
           
            }

            
        } 
        
       CheckHPPlayer();
    
      


}

    public static void CheckHPPlayer() {
        List<Entity> players = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero ,PlayerType.Combat, PlayerType.Mage)
                .stream()
                .filter(player -> player.getComponent(StatusComponent.class).getHPCharacter() > 0)
                .collect(Collectors.toList());

                
              
                   
        if (players.isEmpty()) {

            triggerGameOverCutscene();
            
            OrderCombat.setPlayerTurn (true);
        }
    }


    private static void triggerGameOverCutscene() {
     
  

       
        Button exitButton = new Button("Game Over");
        exitButton.setFont(Font.font(100)); 
        exitButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        exitButton.setPrefSize(FXGL.getAppWidth() , FXGL.getAppHeight() ); 


        exitButton.setOnAction(e -> FXGL.getGameController().exit());

        
        FXGL.getGameScene().addUINode(exitButton);
     
            
             
        OrderCombat.setPlayerTurn(true);
    }
    
}
    

