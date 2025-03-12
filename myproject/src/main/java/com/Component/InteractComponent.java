package com.Component;

import java.util.List;

import com.GameEvent.CombatScene;
import com.GameEvent.SystemEvent;
import com.Type.EnemyType;
import com.Type.PlayerType;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.cutscene.CutsceneService;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.event.EventBus;

public class InteractComponent extends Component{

 
    private String filename;
    
    public EventBus eventBus;
   

    public InteractComponent( String filename) {

        
        this.filename = filename;
       
    }


public void interact() {
    if (entity.getType() == PlayerType.Hero) {
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy);

        for (int i = 0; i < enemies.size(); i++) { 
            if (entity.distance(enemies.get(i)) < 150) {
                Cutscene cutscene = FXGL.getAssetLoader().loadCutscene(filename);
                    CutsceneService cutsceneService = FXGL.getCutsceneService();
                    
                
                    cutsceneService.startCutscene(cutscene, () -> {
                        SystemEvent.eventBus.fireEvent(new CombatScene(CombatScene.REXCOMBATODE));
                    });
                
                
                break;
                        
            }
            

        }
        
    }
}
        

   

    @Override
    public void onUpdate(double tpf) {

        
    }


}
