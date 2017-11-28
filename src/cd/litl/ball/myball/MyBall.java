package cd.litl.ball.myball;

import java.awt.Color;

public class MyBall {
	
	private int x,y,movex,movey;
	
	private Color color;
	
	private int size;
	
	
	

	public MyBall(int x, int y, int movex, int movey, Color color, int size) {
		super();
		this.x = x;
		this.y = y;
		this.movex = movex;
		this.movey = movey;
		this.color = color;
		this.size = size;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getMovex() {
		return movex;
	}

	public void setMovex(int movex) {
		this.movex = movex;
	}

	public int getMovey() {
		return movey;
	}

	public void setMovey(int movey) {
		this.movey = movey;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void clearBall () {
		
	}
	

}
