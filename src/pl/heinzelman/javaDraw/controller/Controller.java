package pl.heinzelman.javaDraw.controller;

import pl.heinzelman.javaDraw.model.Model;
import pl.heinzelman.javaDraw.view.View;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 *  Kontroler z modelu MVC,
 *  manipuluje modelem i wywołuje metody obiekty widok
 *  by narysować obraz danych z modelu.
 *  ustawia strategię rysowania, oraz parametry rysowania
 *  czyli kolor linii i jej grubość
 *
 *  @author Piotr Heinzelman
 */
public class Controller {
    public static final JFileChooser CH = new JFileChooser();
    public final Model model;
    public final View  view;

    /**
     * Konstruktor
     * @param model - referencja do obiekt modelu MVC
     * @param view  - referencja do obiektu widoku
     */
    public Controller( Model model, View view ) {
        this.model = model;
        this.view = view;
    }

    public void draw(){
        model.clearAll();
        model.refreshPixels();
        view.repaint();
    }

}
