/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



/**
 *
 * @author pinguu
 */
public class ScreenControl {
    
    private final int GRID_WIDTH;
    private final int TILE_SIZE;
    private final int GRID_HEIGHT;
    
    public boolean m_Grid = false;
    
    private Text startMessage;
    
    private GraphicsContext gc;
    
    public Scene scene;
    
    public ScreenControl(int width, int height, int tileSize){
        GRID_WIDTH = width;
        GRID_HEIGHT = height;
        TILE_SIZE = tileSize;
    }
    
   public void DrawGameScreen(Stage primaryStage){
       StackPane root = new StackPane();
        scene = new Scene(root, GRID_WIDTH * TILE_SIZE, GRID_HEIGHT * TILE_SIZE);

       Canvas canvas = new Canvas(GRID_WIDTH * TILE_SIZE, GRID_HEIGHT * TILE_SIZE);
       root.getChildren().add(canvas);
       root.setStyle("-fx-background-color: black");

       startMessage = new Text("Press Enter to Start");
       startMessage.setFill(Color.WHITE);
       startMessage.setFont(Font.font("Arial", FontWeight.BOLD, 20));
       root.getChildren().add(startMessage);

       gc = canvas.getGraphicsContext2D();

       scene.setOnKeyPressed(e -> GameControl.HandleKeyPressed(e.getCode()));

   }
   
    public void ChangeGrig() {
        if (m_Grid) {
            m_Grid = false;
        } else {
            m_Grid = true;
        }
    }
    
    private void DrawSnake(){
        gc.setFill(Color.GREEN);
        List<Position> body = GameControl.GetSnake().GetSnakePosition();
        for (Position pos : body) {
            gc.fillRect(pos.Xpos * TILE_SIZE, pos.Ypos * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        }
    }
    
    private void DrawBonus(){
        gc.setFill(Color.RED);
        Position pos = GameControl.GetBonus().GetPosition();
        gc.fillRect(pos.Xpos * TILE_SIZE, pos.Ypos * TILE_SIZE, TILE_SIZE, TILE_SIZE);
    }
    
    public void DrawWaitingScreen(){
        startMessage.setText("Press Enter to Start");
        StackPane.setAlignment(startMessage, Pos.CENTER);
    } 
    
    
    
    public void DrawGrid() {
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(0.2);

        // Vertical lines
        for (int i = 0; i <= GRID_WIDTH; i++) {
            gc.strokeLine(i * TILE_SIZE, 0, i * TILE_SIZE, GRID_HEIGHT * TILE_SIZE);
        }

        // Horizontal lines
        for (int i = 0; i <= GRID_HEIGHT; i++) {
            gc.strokeLine(0, i * TILE_SIZE, GRID_WIDTH * TILE_SIZE, i * TILE_SIZE);
        }
    }
    
    public void DrawScore() {
        gc.setFill(Color.WHITE);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        gc.setTextAlign(TextAlignment.LEFT);
        gc.fillText("Score: " + GameControl.GetScore(), 10, 20);
    }

    public void DrawGameOver() {
        System.out.println("GAME OVER");
        gc.setFill(Color.RED);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("GAME OVER\n press ENTER to restart", GRID_WIDTH * TILE_SIZE / 2, GRID_HEIGHT * TILE_SIZE / 2);
    }

    public void ClearScreen() {
        startMessage.setText("");
        gc.clearRect(0, 0, GRID_WIDTH * TILE_SIZE, GRID_HEIGHT * TILE_SIZE);
    }
    
    public void DrawGameFrame(){
        DrawSnake();
        DrawBonus();
    }

}
