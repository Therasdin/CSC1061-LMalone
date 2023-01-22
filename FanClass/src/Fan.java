
public class Fan
{
	final static int slow = 1;
	final static int medium = 2;
	final static int fast = 3;
	private int speed = slow;
	private boolean FanOn = false;
	private double radius = 5;
	String color = "Blue";

public Fan()
{
	speed = slow;
	FanOn = false;
	radius = 5;
	color = "blue";
}

public Fan(int speed, boolean fanOn, double radius, String color) {
		super();
		this.speed = speed;
		FanOn = fanOn;
		this.radius = radius;
		this.color = color;
	}

public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public boolean isFanOn() {
	return FanOn;
}
public void setFanOn(boolean fanOn) {
	FanOn = fanOn;
}
public double getRadius() {
	return radius;
}
public void setRadius(double radius) {
	this.radius = radius;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
@Override
public String toString() {
	return "Fan [speed=" + speed + ", FanOn=" + FanOn + ", radius=" + radius + ", color=" + color + "]";
}

}