package pl.heinzelman.javaDraw.model;


import java.util.ArrayList;
import java.util.List;
/**
 *  Obiekt MODEL w rozumieniu wzorca MVC
 *  przechowuje dane stanu aplikacji
 *  udostępnia controlerowi i widokowi
 *  niezbędnemy im do pracy
 *
 *  @author Piotr Heinzelman
 *
 */
public class Model {

    private List<Pixel> pixels = new ArrayList<>();
    private Double d = 220.0;
    private Pixel viewTopLeft;
    private Pixel viewBottomRight;
    public void clearAll(){
        clearPixels();
    };



    // Pixels
    public List<Pixel> getPixels()                   { return pixels;        }
    public void        setPixels( List<Pixel> pixels ) { this.pixels = pixels; }
    public void        clearPixels()                 { pixels = new ArrayList<>(); }

    public void  refreshPixels(){
        pixels.add( new Pixel( 1,1 ) );
        pixels.add( new Pixel( 2,2 ) );
        pixels.add( new Pixel( 3,3 ) );
        pixels.add( new Pixel( 4,4 ) );
        pixels.add( new Pixel( 5,5 ) );
    }

}
