package com.GameEvent;

import java.util.List;

import com.Combat.OrderCombat;
import com.Component.SpawnComponent;
import com.Component.CharecterHero.InteractComponent;
import com.Factory.FactoryInCombat.CombatWithRexFactory;
import com.Factory.FactoryInMain.BackgroundScene1Factory;
import com.Factory.FactoryInMain.BackgroundScene2Factory;
import com.Factory.FactoryInMain.CharacterFactory;
import com.Type.SceneType;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.UI.ActionButtonUI;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.action.Action;
import com.almasb.fxgl.entity.level.Level;
import com.almasb.fxgl.entity.level.tiled.TMXLevelLoader;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.event.EventBus;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.Texture;
import com.project.App;

import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SystemEvent {

    public static EventBus eventBus;
    private static Entity camera;
    private static Entity player;
    private static ActionButtonUI actionButtonUI = null;
    private static boolean isFactoryAdded = false;
    private static boolean isFactoryAdded2 = false;
    
      
    
            public static void combat() {
        
              eventBus = FXGL.getEventBus();
                
              eventBus.addEventHandler(CombatScene.REXCOMBATMODE, event -> {
        
                  FXGL.set("Phase", false);
                 
              
                  FXGL.setLevelFromMap("battle1.tmx");
                
                  camera = FXGL.getGameWorld().getEntitiesByType(SceneType.CombatCamera).get(0);
                  App.setPlayer(camera);
                  FXGL.getGameScene().getViewport().unbind();
                  FXGL.getGameScene().getViewport().bindToEntity(camera, FXGL.getAppWidth() /2, FXGL.getAppHeight() /2);
                  FXGL.getGameScene().getViewport().setZoom(0.75/1.05);
    
                  FXGL.set("Rex", "battle1.tmx");
                  Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("Rex"), new TMXLevelLoader());
                  int mapWidth = (int) map.getWidth();
                  int mapHeight = (int) map.getHeight();
                  FXGL.getGameScene().getViewport().setBounds(0, 0, mapWidth, mapHeight);
                  FXGL.getGameScene().setBackgroundColor(Color.BLACK);
                  actionButtonUI = new ActionButtonUI();
                  FXGL.getGameScene().addUINode(actionButtonUI.getHBox());

                  
          });

          eventBus.addEventHandler(CombatScene.DREGANMALRIK, event -> {
        
            FXGL.set("Phase", false);
           
        
            FXGL.setLevelFromMap("battle2.tmx");
            
            camera = FXGL.getGameWorld().getEntitiesByType(SceneType.Combat2Camera).get(0);
            
            FXGL.getGameScene().getViewport().unbind();
            FXGL.getGameScene().getViewport().bindToEntity(camera, FXGL.getAppWidth() /2, FXGL.getAppHeight() /2);
            FXGL.getGameScene().getViewport().setZoom(0.8);

            FXGL.set("Dregan", "battle2.tmx");
            Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("Dregan"), new TMXLevelLoader());
            int mapWidth = (int) map.getWidth();
            int mapHeight = (int) map.getHeight();
            FXGL.getGameScene().getViewport().setBounds(200, 0, mapWidth, mapHeight);
            FXGL.getGameScene().setBackgroundColor(Color.BLACK);
            actionButtonUI = new ActionButtonUI();
            FXGL.getGameScene().addUINode(actionButtonUI.getHBox());

            
    });

    eventBus.addEventHandler(CombatScene.FINALJOURNEY, event -> {
        
      FXGL.set("Phase", false);
     
  
      FXGL.setLevelFromMap("battle3.tmx");
    
      camera = FXGL.getGameWorld().getEntitiesByType(SceneType.Combat3Camera).get(0);
      
      FXGL.getGameScene().getViewport().unbind();
      FXGL.getGameScene().getViewport().bindToEntity(camera, FXGL.getAppWidth() /2, FXGL.getAppHeight() /2);
      FXGL.getGameScene().getViewport().setZoom(0.77);

     
      Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map3"), new TMXLevelLoader());
      int mapWidth = (int) map.getWidth();
      int mapHeight = (int) map.getHeight();
      FXGL.getGameScene().getViewport().setBounds(200, 0, mapWidth, mapHeight);
      FXGL.getGameScene().setBackgroundColor(Color.BLACK);
      actionButtonUI = new ActionButtonUI();
      FXGL.getGameScene().addUINode(actionButtonUI.getHBox());

      
});

    

      eventBus.addEventHandler(BackMainScene.BACKTOMAINSCENEIFWIN2, event-> {
        FXGL.set("Phase", true);

        
     
        FXGL.setLevelFromMap("scene2.tmx");

        Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map2"), new TMXLevelLoader());
        FXGL.getGameScene().setBackgroundColor(Color.BLACK);

        if(FXGL.getb("Nah") == true){

          FXGL.set("Checkd2",true);

        Entity enemy = FXGL.getGameWorld().getEntitiesByType(EnemyType.HighEnemy).get(0);
        FXGL.getGameWorld().removeEntity(enemy);

        }


        List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.ExitCombat));
      for(Entity entity : entities){
          SpawnComponent component = entity.getComponent(SpawnComponent.class);
          player = FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
          }

          App.setPlayer(player);

        FXGL.getGameScene().getViewport().unbind();
        FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map.getWidth();
        int mapHeight = (int) map.getHeight();

        FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);

        if (actionButtonUI != null) {
          actionButtonUI.remove();
          actionButtonUI = null;
      }


});

eventBus.addEventHandler(BackMainScene.BACKTOMAINSCENEIFWIN, event-> {


  FXGL.set("Phase", true);

  

  FXGL.setLevelFromMap("scene1.tmx");

  Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map1"), new TMXLevelLoader());
  FXGL.getGameScene().setBackgroundColor(Color.BLACK);

  if(FXGL.getb("Nah") == true){
  Entity enemy = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy).get(0);
  FXGL.getGameWorld().removeEntity(enemy);
  }

  player = FXGL.spawn("Reid", FXGL.getd("lastPlayerX"), FXGL.getd("lastPlayerY"));
  App.setPlayer(player);

  FXGL.getGameScene().getViewport().unbind();
  FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
  FXGL.getGameScene().getViewport().setZoom(1.5);
  int mapWidth = (int) map.getWidth();
  int mapHeight = (int) map.getHeight();

  FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
  FXGL.getGameScene().getViewport().setLazy(true);

  if (actionButtonUI != null) {
    actionButtonUI.remove();
    actionButtonUI = null;
}


});

    eventBus.addEventHandler(NextScene.NEXTSCENE, event-> {

      FXGL.set("Phase", true);
      
      FXGL.set("scene", 2);

      FXGL.setLevelFromMap("scene2.tmx");
      Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map2"), new TMXLevelLoader());
      FXGL.getGameScene().setBackgroundColor(Color.BLACK);

      if(FXGL.getb("Checkd2") == true){
        System.out.print("event");
        List<Entity> rexEntities = FXGL.getGameWorld().getEntitiesByType((EnemyType.HighEnemy));
      for (Entity rex : rexEntities) {
        rex.getViewComponent().clearChildren();
        rex.setPosition(new Point2D(500, 300));
       
        
      }
        }
      


      List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.SpawnPoints));
      for(Entity entity : entities){
          SpawnComponent component = entity.getComponent(SpawnComponent.class);
          player = FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
          }
      

      App.setPlayer(player);

        FXGL.getGameScene().getViewport().unbind();
        FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map.getWidth();
        int mapHeight = (int) map.getHeight();

        FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);


    });

    eventBus.addEventHandler(NextScene.SCENE2TO1, event-> {
      
      FXGL.set("Phase", true);

      FXGL.set("scene", 1);
   
      FXGL.setLevelFromMap("scene1.tmx");

      Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map1"), new TMXLevelLoader());
      FXGL.getGameScene().setBackgroundColor(Color.BLACK);


      List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.Scene2to1));
      for(Entity entity : entities){
          SpawnComponent component = entity.getComponent(SpawnComponent.class);
          player = FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
          }   

     
      List<Entity> rexEntities = FXGL.getGameWorld().getEntitiesByType((EnemyType.LowEnemy));
      for (Entity rex : rexEntities) {
        rex.getViewComponent().clearChildren();
        rex.setPosition(new Point2D(500, 300));
       
        
      }
      App.setPlayer(player);

        FXGL.getGameScene().getViewport().unbind();
        FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map.getWidth();
        int mapHeight = (int) map.getHeight();

        FXGL.getGameScene().getViewport().setBounds(-100/2, 0, mapWidth+150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);
    });

    eventBus.addEventHandler(NextScene.SCENE2TO3, event-> {

      System.out.print("event");

      FXGL.set("Phase", true);

      FXGL.set("scene", 3);
   
      FXGL.setLevelFromMap("scene3.tmx");

      

      Level map3 = FXGL.getAssetLoader().loadLevel(FXGL.gets("map3"), new TMXLevelLoader());
      FXGL.getGameScene().setBackgroundColor(Color.BLACK);
     


      List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.SpawnPoint3));
      for(Entity entity : entities){
          SpawnComponent component = entity.getComponent(SpawnComponent.class);
          player = FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
          
          }   

     
    
      App.setPlayer(player);

        FXGL.getGameScene().getViewport().unbind();
        FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map3.getWidth();
        int mapHeight = (int) map3.getHeight();

        FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);


    });

    eventBus.addEventHandler(NextScene.SCENE3TO2, event-> {
      
      FXGL.set("Phase", true);

      FXGL.set("scene", 2);
   
      FXGL.setLevelFromMap("scene2.tmx");

      Level map = FXGL.getAssetLoader().loadLevel(FXGL.gets("map2"), new TMXLevelLoader());
      FXGL.getGameScene().setBackgroundColor(Color.BLACK);


      List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.BackScene));
      for(Entity entity : entities){
          SpawnComponent component = entity.getComponent(SpawnComponent.class);
          player = FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
          }   

     
      List<Entity> rexEntities = FXGL.getGameWorld().getEntitiesByType((EnemyType.HighEnemy));
      for (Entity rex : rexEntities) {
        rex.getViewComponent().clearChildren();
        rex.setPosition(new Point2D(500, 300));
       
        
      }
      App.setPlayer(player);

        FXGL.getGameScene().getViewport().unbind();
        FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
        FXGL.getGameScene().getViewport().setZoom(1.5);
        int mapWidth = (int) map.getWidth();
        int mapHeight = (int) map.getHeight();

        FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
        FXGL.getGameScene().getViewport().setLazy(true);
    });

    eventBus.addEventHandler(BackMainScene.BACKTOMAINSCENEIFWIN3, event-> {

      FXGL.set("Phase", true);
            
      if(FXGL.getb("Nah") == true){     
      Button exitButton = new Button("You Are Winner");
      exitButton.setFont(Font.font(100)); 
      exitButton.setStyle("-fx-background-color: white; -fx-text-fill: black;");
      exitButton.setPrefSize(FXGL.getAppWidth() , FXGL.getAppHeight() ); 
      exitButton.setOnAction(e -> FXGL.getGameController().exit());
      FXGL.getGameScene().addUINode(exitButton);
        
      }else{

        FXGL.setLevelFromMap("scene3.tmx");

      Level map3 = FXGL.getAssetLoader().loadLevel(FXGL.gets("map3"), new TMXLevelLoader());
      FXGL.getGameScene().setBackgroundColor(Color.BLACK);

      
      List<Entity> entities = FXGL.getGameWorld().getEntitiesByType((SceneType.FleeFromJourney));
      for(Entity entity : entities){
          SpawnComponent component = entity.getComponent(SpawnComponent.class);
          player = FXGL.spawn(component.getName(),new SpawnData(component.getPosition()));     
          
      }

      App.setPlayer(player);

      FXGL.getGameScene().getViewport().unbind();
      FXGL.getGameScene().getViewport().bindToEntity(player,FXGL.getAppWidth()/2, FXGL.getAppHeight()/2);
      FXGL.getGameScene().getViewport().setZoom(1.5);
      int mapWidth = (int) map3.getWidth();
      int mapHeight = (int) map3.getHeight();

      FXGL.getGameScene().getViewport().setBounds(-10000/2, 0, mapWidth+150, mapHeight);
      FXGL.getGameScene().getViewport().setLazy(true);



    }

    if (actionButtonUI != null) {
      actionButtonUI.remove();
      actionButtonUI = null;
  }
  

    });
  
}
}
