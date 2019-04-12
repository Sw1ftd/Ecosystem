/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author jword
 */
public class Ecosystem extends JPanel {

    private Timer timer;
    private ArrayList<Human> humans;
    private ArrayList<Animal> animals;
    private ArrayList<Plant> plants;
        
    public Ecosystem() {
        super();
        humans = new ArrayList<>();
        animals = new ArrayList<>();
        plants = new ArrayList<>();
        spawner();
        setSize(1200, 960);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/24);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.LIGHT_GRAY);
        try{
        for(Human human: humans){
            if(human.isAlive()){
                human.draw(g);
            }
        }}catch(Exception ConcurrentModificationException){}
        try{
        for(Animal animal: animals){
            if(animal.isAlive()){
                animal.draw(g);
            }
        }}catch(Exception ConcurrentModificationException){}
        try{
        for(Plant plant: plants){
            if(plant.isAlive()){
                plant.draw(g);
            }
        }}catch(Exception ConcurrentModificationException){}
    }
    
    private class ScheduleTask extends TimerTask {
        
        @Override
        public void run() {
            for(Human human: humans){
                human.update();
            }
            for(Animal animal: animals){
                animal.update();
            }
            for(Plant plant: plants){
                plant.update();
            }
            try{
            for(Human human: humans){
                if( human.getGender().equals("Male") && human.isAlive()){
                    reproduce();
                }
            }}catch(Exception ConcurrentModificationException){}
            try{
            for(Animal animal: animals){
                if(animal.isAlive()){
                    reproduceA();
                }
            }}catch(Exception ConcurrentModificationException){}
            try{
            for(Plant plant: plants){
                if(plant.isAlive()){
                    reproduceP();
                }
            }
            }catch(Exception ConcurrentModificationException){}
            repaint();
        }
    }
    public void reproduce(){
        boolean repro = true;
        for(Human human: humans){
            if( human.getGender().equals("Female") && repro && human.isAlive()) {
                int rand = (int)(Math.random() * 100);
                if( Cow.getNumCows() <= 0){
                    rand -= 40;
                }
                if(rand >= 60){
                    humans.add( new Male() );
                    repro = false;
                }
                if(rand <= 50){
                    humans.add( new Female() );
                    repro = false;
                }
            }
        }
    }
    public void reproduceA(){
        int loopA = 0;
        int sizeA = animals.size();
        for(int i = 0; i < sizeA; i++){
            Animal animal = animals.get(i);
            if(animal.isAlive() && loopA < 10){
                if(animal.getTypeOfAnimal().equals("Cow") && Cow.getNumCows() > 0){
                    animals.add( new Cow() );
                    loopA++;
                }
                if(animal.getTypeOfAnimal().equals("Pig") && Pig.getNumPigs() > 0){
                    animals.add( new Pig() );
                    loopA++;
                }
            }
        }
    }
    public void reproduceP(){
        int loopP = 0;
        int sizeP = plants.size();
        for(int i = 0; i < sizeP; i++){
            Plant plant = plants.get(i);
            if(plant.isAlive() && loopP < 10){
                if(plant.getTypeOfPlant().equals("Tree")){
                    plants.add( new Tree() );
                    loopP++;
                }
            }
        }
    }
    public void spawner(){
        humans.add( new Male() );
        humans.add( new Female() );
        animals.add( new Cow() );
        animals.add( new Pig() );
        plants.add(new Tree() );
    }
}