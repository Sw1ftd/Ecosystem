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
public abstract class Human extends Living{
    
    protected int life;
    protected int food;
    protected int water;
    protected double age;
    protected int intelligence;
    protected int strength;
    protected int stamina;
    protected int numCookedFood;
    protected int numUncookedFood;
    protected String gender;
    protected boolean alive;
    
    public Human (){
        this.life = 100;
        this.food = 100;
        this.water = 100;
        this.age = 0;
        this.intelligence = 1;
        this.numCookedFood = 100;
        this.numUncookedFood = 0;
        this.alive = true;
        super.x = (int) (Math.random() * 1100);
        super.y = (int) (Math.random() * 800);
    }
    @Override
    public void update() {
        int numHumans = Male.getNumMales() + Female.getNumFemales();
        if(numHumans > 750){
            die();
        }
        //System.out.println(numHumans);
        if(alive == true){
            food -= (int)(Math.random() * 5) + 5;
            water -= (int)(Math.random() * 10) + 10;
            age += .001;
            if(life <= 0){
                die();
            }
            if((food == 0 || water == 0) && life > 0){
                die();
            }
            if((food < 25 || water < 50) && life > 0){
                life--;
            }
            if((food > 40 && water > 70) && life < 100){
                life += 10;
            }
            if(numUncookedFood <= 100){
                hunt();
            }
            if(numCookedFood <= 100){
                cook();
            }
            if(food <= 20 && (Cow.getNumCows() > 0 || Pig.getNumPigs() > 0) && numCookedFood > 0){
                eat();
            }
            if(water <= 45){
                drink();
            }
            if( ((int)(Math.random() * 40)) + age >= 100){
                life = 0;
                die();
            }
            move();
            if(x >= 1200 || y >= 960 || y <= 0 || x <= 0){
                die();
            }
            if(life <= 50){
                System.out.println(life);
            }
        }
    }
    public void die(){
        alive = false;
        if(gender.equals("Male")){
            Male.death();
        }
        if(gender.equals("Female")){
            Female.death();
        }
    }
    public void eat(){
        food += (int)(Math.random() * 30) + 25;
        if(food > 100){
            food = 100;
        }
    }
    public void drink(){
        water += (int)(Math.random() * 50) + 50;
        if(water > 100){
            water = 100;
        }
    }
    public void hunt(){
        if((int)(Math.random() * 10) + stamina >= 15){
            if( (int)(Math.random() * 10) + strength >= 30){
                Pig.hunted();
                numUncookedFood += 100;
                if(gender.equalsIgnoreCase("male")){
                    strength += 1;
                    stamina += .5;
                }
                if(gender.equalsIgnoreCase("female")){
                    strength += .5;
                    stamina += .25;
                }
            }
        }
        if( (int)(Math.random() * 5) + stamina >= 30){
            if( (int)(Math.random() * 5) + strength >= 75){
                Cow.hunted();
                numUncookedFood += 500;
                if(gender.equalsIgnoreCase("male")){
                    strength += 5;
                    stamina += 2.5;
                }
                if(gender.equalsIgnoreCase("female")){
                    strength += 2.5;
                    stamina += 1.25;
                }
            }
        }
    }
    public void cook(){
        if(Tree.getNumWood() < 0 && strength > 10){
            Tree.chopped();
        }
        if(Tree.getNumWood() > 0){
            Tree.woodUsed();
            numUncookedFood -= 100;
            numCookedFood += 100;
        }
    }
    //public abstract void gainInt();
    //public abstract void gainStr();
    //public abstract void gainStam();
    public double getAge() {
        return age;
    }
    public int getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public String getGender() {
        return gender;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
