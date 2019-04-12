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
public class Tree extends Plant{
    private ImageIcon ii;
    private Image img;
    public static double numTrees;
    public static double numWood;
    
    public Tree(){
        super();
        super.typeOfPlant = "Tree";
        numTrees++;
        this.ii = new ImageIcon(getClass().getResource("/images/Tree.png"));
        this.img = ii.getImage();
    }
    @Override
    public void update(){
        if(alive){
            if(life == 0){
                die();
            }
            life--;
            age++;
        }
        if(numTrees > 250){
                die();
               numTrees--;
            }
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(img, x, y, 15, 15, null);
    }
    public static void chopped(){
        numTrees--;
        numWood++;
    }
    public static void woodUsed(){
        numWood--;
    }
    public static double getNumTrees() {
        return numTrees;
    }
    public static double getNumWood() {
        return numWood;
    }
}
