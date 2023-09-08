/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;

import java.awt.Graphics;


public class Linea extends Figura {
    public Linea(int x1, int y1, int x2, int y2)
	{//constructor sin el nombre y el color definidos por el usuario
		super(x1, y1, x2, y2);
	}
	
	public Linea(int x1, int y1, int x2, int y2, String Color, String Etiqueta)
	{ //construtor con el nombre y el color definidos por el usuario
		super(x1, y1, x2, y2, Color, Etiqueta);
	}

	public void dibujar( Graphics g)
	{ //metodo que dibuja una linea
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
	
	public boolean Esta_en_las_Coordenadas(int x, int y)
	{ //localiza si las coordenas pertenecen al area del objeto
		double Ytotal;
		if ((getX1() == getX2()) && (getY1() == getY2()))
			return true;
			
		//si es de tipo linea recta vertical
		if (getX1() == getX2())
		{
			if ( getY1() > getY2())
			{
				if (( y < getY1()) && (y > getY2()))
					return true;
			}
			else
				if ( getY2() > getY1())				{
					if (( y < getY2()) && (y > getY1()))
						return true;
				}
		}
		else	//si es de tipo horizontal	
		if (getY1() == getY2())
		{
			if ( getX1() > getX2())
			{
				if (( x < getX1()) && (x > getX2()))
					return true;
			}
			else
				if (getX2() > getX1())
				{
					if ((x < getX2()) && (x > getX1()))
						return true;
				}
		}
		else //si es inclinada
		{
		 	Ytotal = (((getY2() - getY1())/(getX2()-getX1())) * (x - getX1()) + getY1());
		 	if ( y == Ytotal)
		 		return true;
		}
		
		return false;	
	}

  
}
