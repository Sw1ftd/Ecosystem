/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystem;

/**
 *
 * @author 807514
 */
public abstract class Plant extends Living{
    protected int life;
    protected double age;
    protected boolean alive;
    protected String typeOfPlant = "";
    
    public Plant(){
        this.life = 100;
        this.age = 0;
        this.alive = true;
        super.x = (int) (Math.random() * 1100);
        super.y = (int) (Math.random() * 800);
    }
    public void die(){
        alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
    public String getTypeOfPlant() {
        return typeOfPlant;
    }
}
