package com.Component.CharecterHero;

import static com.almasb.fxgl.dsl.FXGL.set;

import java.util.EmptyStackException;
import java.util.List;

import com.GameEvent.CombatScene;
import com.GameEvent.SystemEvent;
import com.Type.Enemy.EnemyType;
import com.Type.Player.PlayerType;
import com.UI.ActionButtonUI;
import com.UI.StatusUI;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.cutscene.CutsceneService;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.event.EventBus;

public class InteractComponent extends Component{

 
    private String filename;
    public EventBus eventBus;
    private ActionButtonUI actionButtonUI;
    private Entity player;
   

    public InteractComponent( String filename) {

        
        this.filename = filename;
       
    }


public void interact() {

    
    player = FXGL.getGameWorld().getEntitiesByType(PlayerType.Hero).get(0);
    if (entity.getType() == PlayerType.Hero) {

      

        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy);
        List<Entity> enemies2 = FXGL.getGameWorld().getEntitiesByType(EnemyType.HighEnemy);
      

        for (int i = 0; i < enemies.size(); i++) { 
            if (entity.distance(enemies.get(i)) < 150) {

                FXGL.set("lastPlayerX", player.getX());
                FXGL.set("lastPlayerY", player.getY());

                Cutscene cutscene = FXGL.getAssetLoader().loadCutscene("filetext.txt");
                CutsceneService cutsceneService = FXGL.getCutsceneService();
                    
                
                    //cutsceneService.startCutscene(cutscene, () -> {

                        SystemEvent.eventBus.fireEvent(new CombatScene(CombatScene.REXCOMBATMODE));
                        
                  // });
                
                
                break;
                        
            }
        }

            for (int i = 0; i < enemies2.size(); i++) { 
                if (entity.distance(enemies2.get(i)) < 150) {
    
                    FXGL.set("lastPlayerX", player.getX());
                    FXGL.set("lastPlayerY", player.getY());
    
                    Cutscene cutscene = FXGL.getAssetLoader().loadCutscene(filename);
                    CutsceneService cutsceneService = FXGL.getCutsceneService();
                        
                    
                        //cutsceneService.startCutscene(cutscene, () -> {
    
                            SystemEvent.eventBus.fireEvent(new CombatScene(CombatScene.DREGANMALRIK));
                            System.out.print("Yreah2");
                      // });
                    
                    
                    break;
                            
                }

        }
    }
        
    
}

        

   

    @Override
    public void onUpdate(double tpf) {

        
    }


}
