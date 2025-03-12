package com.Component;

import java.util.List;

import com.GameEvent.SystemEvent;
import com.Type.EnemyType;
import com.Type.PlayerType;
import com.almasb.fxgl.cutscene.Cutscene;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;

public class InteractComponent extends Component{

 
    private String filename;
    SystemEvent scene = new SystemEvent();

    public InteractComponent( String filename) {

        
        this.filename = filename;
        this.scene = scene;
    }


public void interact() {
    if (entity.getType() == PlayerType.Hero) {
        List<Entity> enemies = FXGL.getGameWorld().getEntitiesByType(EnemyType.LowEnemy);
        for (int i = 0; i < enemies.size(); i++) { 
            if (entity.distance(enemies.get(i)) < 150) {
                Cutscene cutscene = FXGL.getAssetLoader().loadCutscene("filetext.txt");
                FXGL.getCutsceneService().startCutscene(cutscene);
                
                scene.combat();

                break;

            }
            

        }
    }
}
        

    @Override
    public void onUpdate(double tpf) {

        
    }


}
