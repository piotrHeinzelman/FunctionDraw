package pl.heinzelman.javaDraw.view;

import pl.heinzelman.javaDraw.model.Model;
import pl.heinzelman.javaDraw.model.Pixel;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.util.List;

/**
 *  Implementacja obiektu Canvas realizująca rysowanie
 *  spełnia funkcję obiektu View w modelu MVC.
 *
 *  @author Piotr Heinzelman
 */

public class View extends Canvas {


    private final Model model;
    private final Window parent;

    private Color bgcolor    = new Color( 0x20,0x20,0x20 );
    private Color axisColor  = new Color( 0x00,0x50,0x00 );
    private Color color      = new Color( 0x00,0xa0,0xf0 );
    private Graphics2D g2d   = null;
    private int strokeWidth = 1;

    private BasicStroke stroke = new BasicStroke( 2 );
    private Boolean isAxis=true;
    private Boolean isPoint=true;

    /**
     *  Ustawienie startowej wielkości okna
     */
    private void setMySize(){
        setSize( 1200, 800 );
        parent.pack();
    }


    /**
     * Konstruktor, zapisuje obiekty:
     *  model (MVC)
     *  parent (Parent Window)
     *  w zmiennych prywatnych potrzebnych do dalszej pracy.
     *
     * @param model
     * @param parent
     */
    public View( Model model , Window parent ) {
        this.model = model;
        this.parent = parent;
        setMySize();
        setVisible(true);
    }


    /**
     * Funkcja rysująca i odrysowująca obiekt
     * używana przez system przy odświeżaniu
     * okna
     * za wyświetlanie grup odpowiadają wartości
     * isPoint, isEdge, isWall.
     *
     * @param g   the specified Graphics context
     */
    public void paint( Graphics g )
    {
        super.paint(g);
        g2d = ( Graphics2D ) g;
        setMySize();

        // clean
        g2d.setColor( axisColor );
        g2d.fillRect( 0, 0, getWidth(), getHeight() );
        g2d.setColor( bgcolor );
        g2d.fillRect( 1, 1, getWidth()-2, getHeight()-2 );

        // axis ?
        if ( isAxis || true ) {
            g2d.setStroke( new BasicStroke( 1 ) );
            g2d.setColor( axisColor );
            drawAxis( g2d );
        }


        // points ? !
        if ( isPoint ) {
            g2d.setStroke(new BasicStroke( strokeWidth +2 ));
            g2d.setColor( color );
            drawListOfPixel( model.getPixels() );
        }


    }

    /**
     * rysowanie osi
     *
     * @param g2 - obiekt graficzny domyślny
     */
    private void drawAxis( Graphics2D g2 ){
        g2.setStroke(new BasicStroke( 1 ));
        g2.setColor( axisColor );
    }

    /**
     * rysowanie piskela
     * @param p piksel do narysowania
     */
    public void drawPixel( Pixel p ){
        g2d.drawLine( p.getX(), p.getY(), p.getX(), p.getY());
    }

    /**
     * rysowanie listy pikseli
     * @param list - lista pikseli do narysowania
     */
    public void drawListOfPixel( List<Pixel> list ){
        for ( Pixel pix : list ){
            drawPixel( pix );
        }
    }


    /**
     * rysowanie linii
     * @param p1 - początek linii
     * @param p2 - koniec linii
     *           do narysowania
     */
    public void drawLine( Pixel p1, Pixel p2 ){
        g2d.drawLine( p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }



}
