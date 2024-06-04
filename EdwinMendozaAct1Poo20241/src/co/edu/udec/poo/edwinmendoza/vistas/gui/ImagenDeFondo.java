/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.vistas.gui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Edwin
 */
public class ImagenDeFondo extends JPanel{
    private Image imagen;
        
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/co/edu/udec/poo/edwinmendoza/vistas/gui/iconos/Fondo.png")).getImage();
            g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }

}
