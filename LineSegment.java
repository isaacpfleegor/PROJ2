import java.util.*;

public class LineSegment
{

    // members
    private double _m; // slope of the line 
    private double _b; // y intercept of the line
    private double _maxx, _maxy, _minx, _miny;

    // methods
    //  name: constructor
    //  desc: uses two coord objects to find the equation of a line
    //  params:  Coord p1, Coord p1
    //  return: n/a
    //  1) find the slope of the line
    //  2) find the y intercept 
    public LineSegment(Coord p1, Coord p2)
    {
	_m = p1.slope( p2 );
	_b = p1.y_intercept(_m);

	_maxx = max( p1.get_x(), p2.get_x() );
	_maxy = max( p1.get_y(), p2.get_y() );
	_minx = min( p1.get_x(), p2.get_x() );
	_miny = min( p1.get_y(), p2.get_y() );

	//	System.out.printf("slope is %f, b is %f\n", _m, _b);
    }

    public double max(double a, double b)
    {
	if ( a > b )
	    return a;

	return b;
    }

    public double min(double a, double b)
    {
	if ( a < b )
	    return a;

	return b;
    }

    //  name: intersection
    //  desc: find the intersection of this line with the 
    //   parameter.  
    //  params: LineSegment other
    //  return: Coord - pointer to a coord object with the intercept
    //  1) calculate the difference between this's intercept 
    //  other's intercept
    //  2) calculate the differece between other's slope and this's
    //  slope
    //  3) divide the result of 1 by 2.  this is the x coordinate of the 
    //  intercept.  
    //  4) multiple the slope by the result of 3, add the intercept.
    //  this is the y coordinate of the slope
    //  5) create a new coord ojbect with the x,y of the intercept.
    //  6) return the new coord object.  
    public boolean intersect(LineSegment other)
    {

	if ( _m == other._m && _b == other._b )
	    return true;

	double di = _b - other._b; // step 1
	double dm = other._m - _m; // step 2
	double xinter,yinter;

	xinter = di/dm; // step 3
	yinter = _m * xinter + _b; // step 4

	return on_segment(xinter,yinter) &&
	    other.on_segment(xinter,yinter);
    }

    public boolean on_segment(double x, double y)
    {
	return x <= _maxx && x >= _minx &&
	    y <= _maxy && y >= _miny;
    }

}