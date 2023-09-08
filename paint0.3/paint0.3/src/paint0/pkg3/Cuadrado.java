/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;

import java.awt.Graphics;

class Cuadrado extends Figura{
    protected int lado;
	
	public Cuadrado(int x1, int y1, int x2, int y2)
	{ //constructor sin el nombre y el color definidos por el usuario
		super(x1, y1, x2, y2);
                
		lado = Math.abs(x1 - x2);
	
	}
	
	public Cuadrado(int x1, int y1, int x2, int y2, String Color, String Etiqueta)
	{ //construtor con el nombre y el color definidos por el usuario
		
		super(x1, y1, x2, y2, Color, Etiqueta);
		lado = Math.abs(x1 - x2);
		
	}

	public  void dibujar( Graphics g)
	{ //metodo que dibuja un cuadrado
		g.fillRect (getX1(), getY1(), lado, lado);
	}
	
	public boolean Esta_en_las_Coordenadas(int x, int y)
	{ //averigua si las coordenas estan en el Cuadrado
		double Ytotal;		
		if ((x >= getX1()) && ((getX1() + lado) >= x))
		{
			if ((y >=  getY1()) && ((getY1() + lado) >= y))
				return true;
			else
				return false;
		}
		return false;
	}
}
