package com.Component.CharecterHero;

import com.almasb.fxgl.entity.component.Component;

public class CheckTurnComponent extends Component {
    private static boolean isPlayerTurn = true; // Default to player turn

    public static boolean isPlayerTurn() {
        return isPlayerTurn;
    }

    public static void setPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    public static void toggleTurn() {
        isPlayerTurn = !isPlayerTurn;
    }

    
    
}
