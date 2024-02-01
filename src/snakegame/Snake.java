/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.input.KeyCode;

/**
 *
 * @author pinguu
 */

public class Snake {
    private List<Position> m_SnakePosition = new ArrayList<Position>();
    private Direction m_SnakeHeadDirection;
    private int m_SnakeLenght;

    public Snake(int startXPos, int startYPos, Direction startDirection, int startSnakeLenght){
        m_SnakeHeadDirection = startDirection;
        m_SnakeLenght = startSnakeLenght;
        m_SnakePosition.addFirst(new Position(startXPos, startYPos));
        for (int i = 1; i < m_SnakeLenght; i++){
            switch (m_SnakeHeadDirection) {
                case UP:
                    m_SnakePosition.addLast(new Position(startXPos, startYPos--));
                    break;
                case DOWN:
                    m_SnakePosition.addLast(new Position(startXPos, startYPos++));
                    break;
                case RIGHT:
                    startXPos = startXPos - 1;
                    m_SnakePosition.addLast(new Position(startXPos, startYPos));
                    break;
                case LEFT:
                    m_SnakePosition.addLast(new Position(startXPos++, startYPos--));
                    break;
            }
        }
        
        
    }
    
    public List<Position> GetSnakePosition(){
        return m_SnakePosition;
    }
    
    public int GetSnakeLenght() {
        return m_SnakeLenght;
    }
    
    public Position GetSnakeHeadPosition(){
        return m_SnakePosition.get(0);
    }

    public Direction GetSnakeHeadDirection(){
        return m_SnakeHeadDirection;
    }
    
    public void SetSnakeDirection(KeyCode keyCode){
        switch (keyCode) {
            case UP:
                if (m_SnakeHeadDirection != Direction.DOWN) {
                    m_SnakeHeadDirection = Direction.UP;
                }
                break;
            case DOWN:
                if (m_SnakeHeadDirection != Direction.UP) {
                    m_SnakeHeadDirection = Direction.DOWN;
                }
                break;
            case LEFT:
                if (m_SnakeHeadDirection != Direction.RIGHT) {
                    m_SnakeHeadDirection = Direction.LEFT;
                }
                break;
            case RIGHT:
                if (m_SnakeHeadDirection != Direction.LEFT) {
                    m_SnakeHeadDirection = Direction.RIGHT;
                }
                break;
        }
    }

    
    public void MoveSnake(){
        
        Position prev = m_SnakePosition.get(0);
        
        switch (m_SnakeHeadDirection) {
            case UP:
                m_SnakePosition.set(0, new Position(prev.Xpos, prev.Ypos - 1));
                break;
            case DOWN:
                
                m_SnakePosition.set(0, new Position(prev.Xpos, prev.Ypos + 1));
                break;
            case RIGHT:
                m_SnakePosition.set(0, new Position(prev.Xpos + 1, prev.Ypos));
                break;
            case LEFT:
                m_SnakePosition.set(0, new Position(prev.Xpos - 1, prev.Ypos));
                break;
        }
        
        for(int i = m_SnakeLenght - 1; i > 0; i--){
            System.out.println("preX: " + m_SnakePosition.get(i).Xpos + " preY: " + m_SnakePosition.get(i).Ypos);
            m_SnakePosition.set(i, m_SnakePosition.get(i - 1));
            System.out.println("X: " + m_SnakePosition.get(i).Xpos + " Y: " + m_SnakePosition.get(i).Ypos);
        }
        
        m_SnakePosition.set(1, prev);
        
       
        System.out.println("X: " + m_SnakePosition.get(0).Xpos + " Y: " + m_SnakePosition.get(0).Ypos);
        System.out.println();
    }
    
    public void IncreaseSnakeLenght(){
        m_SnakeLenght++;
        m_SnakePosition.addLast(new Position(0,0));
    }
}
