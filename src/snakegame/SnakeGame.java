/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package snakegame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pinguu
 */
public class SnakeGame extends Application{

    /**
     * @param args the command line arguments
     */
    
    private final int WIDTH = 50;
    private final int HEIHT = 30;
    private final int TILE_SIZE = 20;
    
    ScreenControl sc = new ScreenControl(WIDTH, HEIHT, TILE_SIZE);
    GameControl gc = new GameControl(WIDTH, HEIHT, sc);
    
    public static void main(String[] args) {

            launch(args);
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        sc.DrawGameScreen(primaryStage);
        new AnimationTimer() {
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= 100_000_000) {
                    gc.PlayTheGame();
                    lastUpdate = now;
                }
            }
        }.start();
        
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(sc.scene);
        primaryStage.show();
    }
    
}
