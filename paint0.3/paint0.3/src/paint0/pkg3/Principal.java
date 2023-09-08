/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

class Principal extends javax.swing.JFrame {

    private final Button Cuadrado;
    private final Button Circulo;
    private final Button Rectangulo;
    private final Button Linea;
    private CheckboxGroup radio;
    private Checkbox radioNegro;
    private Checkbox radioAzul;
    private Checkbox radioVerde;
    private Checkbox radioRojo;
    private Checkbox radioAmarillo;
    private Checkbox radioBlanco;
    private Checkbox radioNaranja;
    private Checkbox radioCafe;
    private Checkbox radioGris;
    private Panel panelColores;
    private Panel panelFiguras;
    private Panel panelLienzo;
    private Panel panelGeneral;
    private Panel panelEtiqueta;
    private Area_de_Dibujo Graficos;
    private TextField Captura_eti;
    private Label Etique;
    private Font fondo;
    private Font fondo2;
    private Informativa Mensaje;

    public Principal() {
        Cuadrado = new Button("Cuadrado");
        Circulo = new Button("Circulo");
        Rectangulo = new Button("Rectangulo");
        Linea = new Button("Linea");

        radio = new CheckboxGroup();

        radioNegro = new Checkbox("Negro", radio, true);
        radioAzul = new Checkbox("Azul", radio, false);
        radioVerde = new Checkbox("Verde", radio, false);
        radioRojo = new Checkbox("Rojo", radio, false);
        radioAmarillo = new Checkbox("Amarillo", radio, false);
        radioBlanco = new Checkbox("Blanco", radio, false);
        radioNaranja = new Checkbox("Anaranjado", radio, false);
        radioCafe = new Checkbox("Cafe", radio, false);
        radioGris = new Checkbox("Gris", radio, false);

        Graficos = new Area_de_Dibujo();
        Graficos.setBackground(Color.lightGray);
        Graficos.setSize(700, 500);

        fondo = new Font("Courier", Font.BOLD, 20);
        fondo2 = new Font("Courier", Font.ITALIC, 12);

        Captura_eti = new TextField(30);
        Captura_eti.setFont(fondo2);
        Captura_eti.setBackground(Color.yellow);

        Etique = new Label("Digite el nombre de la figura");
        Etique.setFont(fondo);

        panelColores = new Panel();
        panelColores.add(radioNegro);
        panelColores.add(radioAzul);
        panelColores.add(radioVerde);
        panelColores.add(radioRojo);
        panelColores.add(radioAmarillo);
        panelColores.add(radioBlanco);
        panelColores.add(radioNaranja);
        panelColores.add(radioCafe);
        panelColores.add(radioGris);
        panelColores.add(radioBlanco);
       

        panelEtiqueta = new Panel();
        panelEtiqueta.setLayout(new BorderLayout(10, 10));
        panelEtiqueta.add("Center", Etique);
        panelEtiqueta.add("South", Captura_eti);
        panelEtiqueta.add("North", panelColores);

        panelFiguras = new Panel();
        panelFiguras.add(Circulo);
        panelFiguras.add(Cuadrado);
        panelFiguras.add(Linea);
        panelFiguras.add(Rectangulo);

        panelLienzo = new Panel();
        panelLienzo.add(Graficos);

        panelGeneral = new Panel();
        panelGeneral.setLayout(new BorderLayout(10, 10));
        panelGeneral.add("North", panelFiguras);
        panelGeneral.add("South", panelEtiqueta);
        panelGeneral.add("Center", panelLienzo);

        setSize(900, 700);
        add(panelGeneral);
    }

    @Override
    public boolean action(Event e, Object o) {

        if (Mensaje != null) {
            Mensaje.hide();   //ocultar el marco
            Mensaje.dispose();  //liberar los recursos
            Captura_eti.setBackground(Color.yellow);
        }
        //compara si se digito nombre para la figura	
        if (!(Captura_eti.getText().compareTo("") == 0)) {
            Area_de_Dibujo.Etiqueta = Captura_eti.getText();
            if (e.target == Cuadrado)//verifica que boton se presiono
            {
                Graficos.setTipoFigura("Cuadrado");  //cambia el nombre del tipo
                Graficos.iniciaCuentaClick();  //incia la cuenta de click
                Captura_eti.setText("");  //limpia el area de captura del nombre
            } else if (e.target == Circulo) {
                Graficos.setTipoFigura("Circulo");
                Graficos.iniciaCuentaClick();
                Captura_eti.setText("");
            } else if (e.target == Linea) {
                Graficos.setTipoFigura("Linea");;
                Graficos.iniciaCuentaClick();
                Captura_eti.setText("");
            } else if (e.target == Rectangulo) {
                Graficos.setTipoFigura("Rectangulo");
                Graficos.iniciaCuentaClick();
                Captura_eti.setText("");
            }

        } else { //sino se digita nada se manda un mensaje de advertencia
            Captura_eti.setBackground(Color.red);
            Mensaje = new Informativa();
            Mensaje.show();
        }

//********************************************************************************
//en esta parte se captura el color escogido por el usuario
        if (radioNegro.getState() == true) {
            Graficos.setColorFigura("Negro", Color.black);
        } else if (radioBlanco.getState() == true) {
            Graficos.setColorFigura("Blanco", Color.white);
        } else if (radioAzul.getState() == true) {
            Graficos.setColorFigura("Azul", Color.blue);
        } else if (radioVerde.getState() == true) {
            Graficos.setColorFigura("Verde", Color.green);
        } else if (radioRojo.getState() == true) {
            Graficos.setColorFigura("Rojo", Color.red);
        } else if (radioGris.getState() == true) {
            Graficos.setColorFigura("Gris", Color.gray);
        } else if (radioCafe.getState() == true) {
            Graficos.setColorFigura("Cafe", Color.MAGENTA);
        } else if (radioNaranja.getState() == true) {
            Graficos.setColorFigura("Anaranjado", Color.orange);
        } else if (radioAmarillo.getState() == true) {
            Graficos.setColorFigura("Amarillo", Color.yellow);
        }

        return true;
    }
}
