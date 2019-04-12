/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystem;

import java.awt.Graphics;

/**
 *
 * @author jword
 */
public abstract class Living {
    //Fields
    protected int x;
    protected int y;
    protected int vx;
    protected int vy;
    
    //Constructor
    public Living(int x, int y) {
        this.x = x;
        this.y = y;
        this.vx = 3;
        this.vy = 3;
    }

    public Living() {
        this(50,50);
    }
    public abstract void draw(Graphics g);
    public abstract void update();
    public void move() {
        vx = (int) ((Math.random() * -4.0) + 2.0);
        vy = (int) ((Math.random() * -4.0) + 2.0);
        x += vx;
        y += vy;
    }
}
