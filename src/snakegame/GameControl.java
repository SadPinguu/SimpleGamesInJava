/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import javafx.animation.AnimationTimer;
import javafx.print.Collation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import snakegame.ScreenControl;

/**
 *
 * @author pinguu
 */
public class GameControl {
    private static int m_Score;
    private static Snake m_pSnake;
    private static Bonus m_Apple;
    private static ScreenControl m_pScreenControl;
    private static Colisions m_Colisions;
    
    private static int MAX_X;
    private static int MAX_Y;
    
    private static boolean m_GameOver = false;
    private static boolean m_GameWaiting = true;
    
    
    public GameControl(int maxX, int maxY, ScreenControl sc){
        m_Score = 0;
        m_pScreenControl = sc;
        MAX_X = maxX;
        MAX_Y = maxY;
        
        m_pSnake = new Snake(MAX_X / 2, MAX_Y / 2, Direction.RIGHT, 4);
        m_Apple = new Bonus(MAX_X, MAX_Y);
        m_Colisions = new Colisions (m_pSnake, MAX_X, MAX_Y);
    }
    
    private static void Reset() {
        m_Score = 0;
        m_GameOver = false;
        m_GameWaiting = true;
        m_pSnake = new Snake(MAX_X / 2, MAX_Y / 2, Direction.RIGHT, 4);
        m_Apple = new Bonus(MAX_X, MAX_Y);
        m_Colisions = new Colisions(m_pSnake, MAX_X, MAX_Y);
    }
    
    public void PlayTheGame(){
       
        //set up new screen
        UpdateScreen();
        //as screen is updated game logic can do it's thing
        if(!m_GameWaiting){
            DoGameLogic();
        }    
    }
    
    private static void UpdateScreen(){
        m_pScreenControl.ClearScreen();
        m_pScreenControl.DrawScore();

        if (m_GameOver) {
            m_pScreenControl.DrawGameOver();
        } else if (m_GameWaiting) {
            m_pScreenControl.DrawWaitingScreen();
        } else if (m_pScreenControl.m_Grid){
            m_pScreenControl.DrawGrid();
            m_pScreenControl.DrawGameFrame();
        }else {
            m_pScreenControl.DrawGameFrame();
        }
    }
    
    public static void HandleKeyPressed(KeyCode keyCode){
        if (m_GameWaiting && keyCode == KeyCode.ENTER) {
            m_GameWaiting = false;
        } else if (!m_GameOver) {
            if (keyCode == KeyCode.G) {
                m_pScreenControl.ChangeGrig();
            }else{
                m_pSnake.SetSnakeDirection(keyCode);
            }
        } else if (m_GameOver && keyCode == KeyCode.ENTER) { //reset game
            Reset();
        }
    }
    
    public static int GetScore(){
        return m_Score;
    }
    
    public static Snake GetSnake(){
        return m_pSnake;
    }
    
    public static Bonus GetBonus(){
        return m_Apple;
    }
    
    private void DoGameLogic(){
        if(m_Colisions.IsThereDeadlyCollision()){
            m_GameOver = true;
        } else if(m_Colisions.IsBonusCollected(m_Apple)){
            m_pSnake.IncreaseSnakeLenght();
            m_Score++;
            m_Apple.ChangePosition();
        }
        
        m_pSnake.MoveSnake();
    }
    
}
