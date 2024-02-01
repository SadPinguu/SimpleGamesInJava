/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.util.List;

/**
 *
 * @author pinguu
 */
public class Colisions {
    
    private final Snake m_pSnake;
    private final int m_Xmax;
    private final int m_Ymax;
    
    
    public Colisions(Snake pSnake, int x, int y){
        m_pSnake = pSnake;
        m_Xmax = x;
        m_Ymax = y;
    }
    
    public Boolean IsThereDeadlyCollision(){
        Boolean isGameOver = IsSnakeHeadInBody();
        isGameOver |= IsSnakeInWall();
        return isGameOver;
    }
    
    public Boolean IsBonusCollected(Bonus pBonus){
        Position bonusPosition = pBonus.GetPosition();
        Position snakeHeadPosition = m_pSnake.GetSnakeHeadPosition();
        return(bonusPosition.equals(snakeHeadPosition));
    }
    
    
    private Boolean IsSnakeHeadInBody(){
        List<Position> snakePosition = m_pSnake.GetSnakePosition();
        int snakeLenght = m_pSnake.GetSnakeLenght();
        
        for(int i = 1; i < snakeLenght; i++){
            if(snakePosition.get(0).equals(snakePosition.get(i)))
            {
             return true;
            }
        }
        return false;
    }
    
    private Boolean IsSnakeInWall(){
        Position snakeHeadPosition = m_pSnake.GetSnakeHeadPosition();
        if((snakeHeadPosition.Xpos == -1) || (snakeHeadPosition.Ypos == -1) || 
                (snakeHeadPosition.Xpos == (m_Xmax + 1)) || (snakeHeadPosition.Ypos == (m_Ymax + 1)))
        {
            return true;
        }
            
        return false;
    }
    
    
}
