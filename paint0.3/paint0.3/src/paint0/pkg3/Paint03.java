/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint0.pkg3;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Paint03 {

    public static void main(String[] args) {
        Principal ventana = new Principal();
        ventana.setVisible(true);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //Este método finaliza el programa una vez que el usuario hace clic en el botón de cierre.
                System.exit(0);
            }
        });
    }

}
