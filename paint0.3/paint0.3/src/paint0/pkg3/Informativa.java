/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;

class Informativa extends Frame {
     //despliega un mensaje de advertencia
	private Label Informacion;
	private Font fondo;

	public Informativa()
	{
		super(" ADVERTENCIA ");
		
		fondo = new Font( "Courier", Font.ITALIC,25);
		
		Informacion = new Label("¡Debe de digitar un nombre para la Figura!");
		Informacion.setFont(fondo);
		
		setLayout(new FlowLayout());
		add("Center", Informacion);
	
		resize(600,100);
	
		setBackground(Color.red);

	}
	
//        @Override
//	public boolean handleEvent(Event e)
//	{
//		if (e.id == Event.WINDOW_DESTROY)
//		{
//			hide();  //ocultar el marco
//			dispose();
//			return true;
//		}
//		
//		return super.handleEvent(e);
//	}
}


