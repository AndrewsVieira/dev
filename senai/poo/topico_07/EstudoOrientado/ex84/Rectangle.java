// Rectangle.class - class that calculates the rectangles areas and perimeters.
public class Rectangle {
	private double length;
	private double width;

	public Rectangle() {
		this.length = 1.0;
		this.width = 1.0;
	}
	
	public Rectangle(double length, double width) {
		this.length = (length >= 0.0 && length <= 20.0 ? length : 0.0);
		this.width = (width >= 0.0 && length <= 20.0 ? width : 0.0);
	}

	public void setLength(double length) {
		this.length = (length >= 0.0 && length <= 20.0 ? length : 0.0);
	}

	public double getLength() { return this.length; }

	public void setWidth(double width) {
		this.width = (width >= 0.0 && width <= 20.0 ? width : 0.0);
	}

	public double getWidth() { return this.width; }

	public double getArea() { return getLength() * getWidth(); }

	public double getPerimeter() { return (getLength() + getWidth()) * 2; }
}//end the class
