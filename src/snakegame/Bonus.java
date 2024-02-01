/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

import java.util.Random;

/**
 *
 * @author pinguu
 */
public class Bonus {
    private Position m_Position = new Position(0, 0);
    private int m_XMax;
    private int m_YMax;
    
    public Bonus(int Xmax, int Ymax) {
        m_XMax = Xmax;
        m_YMax = Ymax;
        
        Random randomGen = new Random();
        
        m_Position.Xpos = randomGen.nextInt(m_XMax);
        m_Position.Ypos = randomGen.nextInt(m_YMax);
    }
    
    public void ChangePosition(){
        Random randomGen = new Random();

        m_Position.Xpos = randomGen.nextInt(m_XMax);
        m_Position.Ypos = randomGen.nextInt(m_YMax);
    }
    
    public Position GetPosition() {
        return m_Position;
    }
}
