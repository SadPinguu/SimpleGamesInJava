/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snakegame;

enum Direction {
    RIGHT,
    LEFT,
    UP,
    DOWN
}

public class Position {
    int Xpos = 0;
    int Ypos = 0;
    
    public Position(int x, int y){
        Xpos = x;
        Ypos = y;
    }
    
    //@override
    public Boolean equals(Position p){
        return((this.Xpos == p.Xpos) && (this.Ypos == p.Ypos));
    }
}
