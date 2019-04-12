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
public abstract class Animal extends Living{
    protected int life;
    protected double age;
    protected boolean alive;
    protected String typeOfAnimal = "";
    
    public Animal(){
        this.life = 100;
        this.age = 0;
        this.alive = true;
        super.x = (int) (Math.random() * 1100);
        super.y = (int) (Math.random() * 800);
    }
    public void die(){
        alive = false;
    }

    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age = age;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public String getTypeOfAnimal() {
        return typeOfAnimal;
    }

    public void setTypeOfAnimal(String typeOfAnimal) {
        this.typeOfAnimal = typeOfAnimal;
    }
    
}
