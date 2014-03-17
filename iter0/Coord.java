import java.util.*;


public class Coord
{
    
    // members
    private double _x;
    private double _y;
    
    // methods
    
    //  name: constructor
    //  desc: sets the members passed on the params
    //  params: int x, int y
    //  return: n/a
    //  1) store x in _x
    //  2) store y in _y
    public Coord(double x, double y)
    {
	_x = x;
	_y = y;
    }
    
    public Coord(Coord c)
    {
	_x = c._x;
	_y = c._y;
    }

    public Coord(Random gen, int maxx, int minx, int maxy, int miny)
    {
	random(gen, maxx, minx, maxy, miny);
    }
    
    public void random(Random gen, int maxx, int minx, int maxy, int miny)
    {
	//	_x = Math.abs(gen.nextInt()) %(maxx-minx+1) + minx;
	//	_y = Math.abs(gen.nextInt()) %(maxy-miny+1) + miny;

	_x = gen.nextDouble() * (maxx-minx) + minx;
	_y = gen.nextDouble() * (maxy-miny) + miny;
    }


    //  name: slope
    //  desc: calculates the slope of a line between this
    //  object and the parameter
    //  params: Coord c
    //  return: double - the slope
    //  1) calculate the change in y coords
    //  2) calculate the change in x coords
    //  3) return the change in y divided by change in x
    public double slope(Coord c)
    {
	return (_y - c._y) / (_x - c._x );
    }
    
    
    //  name: y_intercept
    //  desc: calculate the y intercept of a line through
    //  this point with with a given slope.
    //  params: double slope 
    //  1) return _y - slope * _x;
    public double y_intercept(double slope)
    {
     return _y - slope * _x;
    }

    public double distance(Coord c)
    {
	return Math.sqrt(  Math.pow( _x - c._x, 2) + 
			   Math.pow( _y - c._y, 2) );
    }

    public String toString()
    {
	return _x + " " + _y;
    }

    public double get_x() { return _x; }
    public double get_y() { return _y; }
    
}