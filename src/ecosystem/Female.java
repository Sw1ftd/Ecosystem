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
public class Female extends Human{
    private ImageIcon ii;
    private Image img;
    private static int numFemales = 0;
    
    public Female(){
        super();
        strength = 15;
        stamina = 5;
        numFemales++;
        gender = "Female";
        this.ii = new ImageIcon(getClass().getResource("/images/Female.png"));
        this.img = ii.getImage();
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(img, x, y, 27, 27, null);
    }
    public static void death(){
        numFemales--;
    }
    public static int getNumFemales() {
        return numFemales;
    }
    public void setNumFemales(int numFemales) {
        this.numFemales = numFemales;
    }
}
