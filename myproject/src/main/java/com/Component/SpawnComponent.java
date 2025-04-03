package com.Component;

import com.almasb.fxgl.entity.component.Component;

import javafx.geometry.Point2D;

public class SpawnComponent extends Component{
    private String name;
    private double PositionX;
    private double PositionY;
   
    public SpawnComponent(String name,double PositionX,double PositionY){
        this.PositionX = PositionX;
        this.PositionY = PositionY;
       
        this.name = name;
    }


    public Point2D getPosition(){
        return new Point2D(this.PositionX, this.PositionY);
    }
    
    public String getName(){
        return name;
    }
   
}
