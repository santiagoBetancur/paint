/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;
import java.awt.Graphics;

abstract  class Figura extends javax.swing.JFrame{
    private String Color; //variable que guarda el color
	private String Etiqueta; //variable que guarda el nombre
	private int x1, y1;  //variables del primer click
	private int x2, y2;  //variables del segundo click largo
	
	public Figura(int x1, int y1, int x2, int y2) //constructor por defecto sin 
	{ //nombre ni color definido por el usuario
		Color = new String("Negro");
		Etiqueta = new String("Sin nombre");
		this.x1 = x1; 
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public Figura(int x1, int y1, int x2, int y2, String Color, String Etiqueta)
	{//constructor con valores definidos por el usuario
		this.Color = new String(Color);
		this.Etiqueta = new String(Etiqueta);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public String getColor()
	{ //obtiene el color
		return new String(Color);
	}
	
	public String getEtiqueta()
	{ //obtiene el nombre
		return new String(Etiqueta);
	}
	
	public int getX1()
	{ //obtiene el primer eje x
		return x1;
	}
	
	public int getY1()
	{ //obtiene el primer eje y
		return y1;
	}
		
	public int getX2()
	{ //obtiene el segundo eje x o el lado en el caso del cuadrado o ancho rect
	//o el radio en el caso del circulo
		return x2;
	}
	
	public int getY2()
	{ //obtiene el segundo eje y o el largo en el caso del rectangulo
		return y2;
	}
	
	public abstract void dibujar( Graphics g);
	public abstract boolean Esta_en_las_Coordenadas(int x, int y);
    
}
