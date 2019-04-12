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
public class Male extends Human{
    private ImageIcon ii;
    private Image img;
    private static int numMales = 0;
    
    public Male(){
        super();
        strength = 25;
        stamina = 10;
        numMales++;
        gender = "Male";
        this.ii = new ImageIcon(getClass().getResource("/images/Male.png"));
        this.img = ii.getImage();
    }
    @Override
    public void draw(Graphics g){
        g.drawImage(img, x, y, 25, 25, null);
    }
    public static void death(){
        numMales--;
    }
    public static int getNumMales() {
        return numMales;
    }
    public void setNumMales(int numMales) {
        this.numMales = numMales;
    }
}
