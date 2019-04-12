/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecosystem;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author 807514
 */
public class Cow extends Animal{
    private ImageIcon ii;
    private Image img;
    public static double numCows;
    
    public Cow(){
        super();
        super.typeOfAnimal = "Cow";
        numCows++;
        this.ii = new ImageIcon(getClass().getResource("/images/Cow.png"));
        this.img = ii.getImage();
    }
    @Override
    public void update(){
        if(alive){
            age += .5;
            if(age >= 22){
                die();
            }
            move();
            if(numCows > 500){
                die();
               numCows--;
            }
        }
        
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(img, x, y, 25, 25, null);
    }
    public static void hunted(){
        numCows --;
        //System.out.println(numCows);
    }
    public static double getNumCows() {
        return numCows;
    }
}
