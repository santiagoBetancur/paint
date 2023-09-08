/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;

import java.awt.Graphics;

/**
 *
 * @author mecho
 */
public class Circulo extends Figura {
    
   public Circulo (int x1, int y1, int x2, int y2)
	{//constructor sin el nombre y el color definidos por el usuario
		super(x1, y1, x2, y2);
	}
	
	public Circulo(int x1, int y1, int x2, int y2, String Color, String Etiqueta)
	{ //construtor con el nombre y el color definidos por el usuario
		super(x1, y1, x2, y2, Color, Etiqueta);
	}
	
	public void dibujar( Graphics g)
	{ //metodo que dibuja un circulo
		g.fillOval (getX1(), getY1(), getX2(), getY2());
	}	
	public boolean Esta_en_las_Coordenadas(int x, int y)
	{   //averigua si las coordenas estan en el Circulo
		double Ytotal;		
		if ((x >= getX1()) && ((getX1() + getX2()) >= x))
		{
			if ((y >=  getY1()) && ((getY1() + getY2()) >= y))
				return true;
			else
				return false;
		}
		return false;
	} 
}
