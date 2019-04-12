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
public class Pig extends Animal{
    private ImageIcon ii;
    private Image img;
    public static double numPigs;
    
    public Pig(){
        super();
        super.typeOfAnimal = "Pig";
        numPigs++;
        this.ii = new ImageIcon(getClass().getResource("/images/Pig.png"));
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
            if(numPigs > 500){
                die();
                numPigs--;
            }
        }
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(img, x, y, 20, 20, null);
    }
    public static void hunted(){
        numPigs--;
        //System.out.println(numPigs);
    }
    public static double getNumPigs() {
        return numPigs;
    }
}
