package pl.heinzelman.javaDraw;

import pl.heinzelman.javaDraw.controller.Controller;
import pl.heinzelman.javaDraw.model.Model;
import pl.heinzelman.javaDraw.view.View;
import pl.heinzelman.javaDraw.view.Window;

import javax.swing.*;
import java.awt.*;

/**
 *  JavaDraw - program rysujący wykres, pobierający
 *  punkty z pliku tekstowego
 *
 *  dodatkowo program może wykorzystując inną strategię
 *  rzutowania punktów narysować sześciany w przestrzeni 3D
 *
 *  @author Piotr Heinzelman 146703
 *  Politechnika Warszawska, Okno . 19.X.2023
 *
 */
public class JavaDraw{

	/**
	 *  główny program,
	 *  przygotowuje obiekty wzorca MVC
	 *  model, widok, kontroller
	 *  oraz okno głowne programu win.
	 *
	 *  ponadto przygotowuje belkę menu górnego
	 *  i pokazuje główne okno.
	 *
	 *
	 * @param args
	 * 	jeśli args[0] zawiera nazwę istniejęcego pliku
	 *  plik zostanie wczytany.
	 */

	public static void main(String[] args) {

		Window win   = new Window(); win.setVisible(true); // win.setPreferredSize( new Dimension(1200, 700 ) );
		Model  model = new Model();
		View   view  = new View( model , win );
		Controller controller = new Controller( model, view );
		controller.draw();

		win.add(view);
		win.setVisible(true);
		while( win.isVisible() ){  }
	}
	}