package com.Save;

import java.util.ArrayList;

import com.Component.StatusComponent;
import com.almasb.fxgl.core.serialization.Bundle;
import com.almasb.fxgl.entity.component.Component;

public class PlayerData extends Component{

     public String name;
    public double PositionX;
    public double PositionY;
    public int PhaseCutsence;

    public PlayerData(String name,double PositionX,double PositionY){
        this.name = name;
        this.PositionX = PositionX;
        this.PositionY = PositionY;
     
    }
    
    public double getPositionX(){
        return this.PositionX;
    }
    public double getPositionY(){
        return this.PositionY;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public void onUpdate(double tpf) {
        super.onUpdate(tpf);

        
        PositionX = getEntity().getX();
        PositionY = getEntity().getY();
    }


   
}
    

