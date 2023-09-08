/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.util.Vector;

class Area_de_Dibujo extends Canvas {

    private int x1, y1, x2, y2, x3, y3;
    private int Cont_click;
    private String NombreColor;
    private Color FiguraColor;
    public static String Etiqueta;
    private int TipoFigura;
    public static String NombreTipo, Tipo;
    private Figura l;
    private boolean permiso;
    private Vector v;

    //constructor del area de dibujo
    public Area_de_Dibujo() {
        v = new Vector();

    }

    //cambio del tipo de figura escogida
    public void setTipoFigura(String dato) {

        NombreTipo = dato;
        tipoFigura fig = tipoFigura.valueOf(NombreTipo);

        switch (fig) {
            case Circulo:
                TipoFigura = 1;
                break;
            case Cuadrado:
                TipoFigura = 2;
                break;
            case Linea:
                TipoFigura = 3;
                break;
            case Rectangulo:
                TipoFigura = 4;
                break;
        }
		

    }

    //Cambia el color escogido por el usuario
    public void setColorFigura(String nombre, Color c) {
        NombreColor = nombre;
        FiguraColor = c;
    }

    //inicia la cuenta de los clicks
    public void iniciaCuentaClick() {
        Cont_click = 0;
    }

    //dibuja y redibuja en pantalla las figuras
    @Override
    public void paint(Graphics g) {
        g.setColor(FiguraColor); //cambia el color de la figura

        // a continuacion se dibuja e instancia un objeto dependiendo del tipo escogido
        if (TipoFigura == 1) {
            l = new Circulo(x1, y1, x2, y2, NombreColor, Etiqueta);
            l.dibujar(g);
        }

        if (TipoFigura == 2) {
            l = new Cuadrado(x1, y1, x2, y2, NombreColor, Etiqueta);
            l.dibujar(g);
        }

        if (TipoFigura == 3) {
            l = new Linea(x1, y1, x2, y2, NombreColor, Etiqueta);
            l.dibujar(g);
        }

        if (TipoFigura == 4) {
            l = new Rectangulo(x1, y1, x2, y2, NombreColor, Etiqueta);
            l.dibujar(g);
        }

        v.add(l); //se añade el nuevo objeto a una clase vector
        Etiqueta = "";  //se limpia el Nombre del objeto ingresado
        TipoFigura = 6;  //se utiliza un tipo figura no existente para verificar 
        for (int i = 0; i < v.size(); i++) { //reimprime todos los objetos en el Canvas para que no se borren 
            //cuando se agranda o pasa una aplicacion sobre ella
            if (v.get(i) instanceof Circulo) {
                l = (Circulo) v.get(i);
            }

            if (v.get(i) instanceof Linea) {
                l = (Linea) v.get(i);
            }

            if (v.get(i) instanceof Cuadrado) {
                l = (Cuadrado) v.get(i);
            }

            if (v.get(i) instanceof Rectangulo) {
                l = (Rectangulo) v.get(i);
            }

            if (l.getColor().equals("Negro")) {
                g.setColor(Color.black);

            } else if (l.getColor().equals("Blanco")) {
                g.setColor(Color.white);
            } else if (l.getColor().equals("Azul")) {
                g.setColor(Color.blue);
            } else if (l.getColor().equals("Verde")) {
                g.setColor(Color.green);
            } else if (l.getColor().equals("Rojo")) {
                g.setColor(Color.red);
            } else if (l.getColor().equals("Gris")) {
                g.setColor(Color.gray);
            } else if (l.getColor().equals("Cafe")) {
                g.setColor(Color.magenta);
            } else if (l.getColor().equals("Anaranjado")) {
                g.setColor(Color.orange);
            } else if (l.getColor().equals("Amarillo")) {
                g.setColor(Color.yellow);
            }
            l.dibujar(g);//dibuja otra vez el objeto
        }//fin del ciclo
        Etiqueta = ""; //limpia nuevamente el nombre del objeto
        TipoFigura = 6; //figura no viable
    }

    public void update(Graphics g) //actualiza todos los dibujos sin borrarlos
    {
        paint(g);
    }

    public boolean mouseDown(Event e, int x, int y) {  //clic abajo del mouse

        if (TipoFigura == 6) {  //si no es figura se procede a verificar si las coordenadas pertenecen
            //a un objeto creado anteriormente
            for (int i = (v.size() - 1); i >= 0; i--) { //recorre el arreglo a la inversa para verificar ultimas figuras dibujadas
                if (v.get(i) instanceof Rectangulo) {//si es de tipo rectangulo la clase 
                    l = (Figura) v.get(i);//para instanciar a clases inferiores
                    if (l instanceof Circulo) //verifica si es circulo
                    {
                        Tipo = new String("Circulo"); //nombra al tipo
                        l = (Circulo) v.get(i); //la clase polimorfica apunta a una clase derivada
                    } //y asume su comportamiento
                    else //lo mismo para los siguientes casos
                    if (l instanceof Cuadrado) {
                        Tipo = new String("Cuadrado");
                        l = (Cuadrado) v.get(i);
                    } else {
                        Tipo = new String("Rectangulo");
                        l = (Rectangulo) v.get(i);
                    }

                }
                if (v.get(i) instanceof Linea) {
                    Tipo = new String("Linea");
                    l = (Linea) v.get(i);
                }

            }
        }

        x1 = x; //captura x1 para el resto de figuras
        y1 = y;; //captura y1 para el resto de figuras
        return true;
    }

    public boolean mouseUp(Event e, int x, int y) {
        if (TipoFigura != 5) //Cuando suelta el click se captura la siguiente coordenada
        { //para todas las figuras menos el triangulo
            x2 = x;
            y2 = y;
            repaint(); //y se manda a dibujar
        }
        return true;
    }

}
