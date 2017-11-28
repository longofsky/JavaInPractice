package cd.litl.ball;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ball {
	private int x, y, movex, movey;
	private Color color;
	private int size;

	public Ball(int x, int y, Color color, int size, int movex, int movey) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.movex = movex;
		this.movey = movey;
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

	public int getMoveX() {
		return movex;
	}

	public void setMoveX(int movex) {
		this.movex = movex;
	}

	public int getMoveY() {
		return movey;
	}

	public void setMoveY(int movey) {
		this.movey = movey;
	}

	public void clearBall(Graphics g, Blackball bb) {// 清除小球
		g.setColor(bb.getContentPane().getBackground());
		g.fillOval(x - 1, y - movey, size + 1, size + 1);

	}

	public void drawBall(Graphics g) {// 画小球
		g.setColor(color);
		g.fillOval(x, y, size, size);

	}

	public void moveBall() {// 移动小球
		x += movex;
		y += movey;

	}

	public void collision(Graphics g, Blackball bb, ArrayList<Ball> list) {

		/*
		 * if (x + size >= 500) {// 窗体右侧边框反弹 movex = -movex; } if (y + size >=
		 * 700) {// 窗体底部反弹 movey = -movey; } if (x <= 0) {// 窗体左边反弹 movex =
		 * -movex; } if (y <= 25) {// 窗体顶部反弹 movey = -movey; }
		 */
		/*
		 * //如果x越界 if (x <= 0 || x + size >= 500) { movex = -movex;// x速度反向 if
		 * (x < 0) x = 0; else if (x + size>=500 ) x = bb.getWidth() - size;
		 * 
		 * } // 如果y越界 if (y <= 25 || y + size >= bb.getHeight()) { movey =
		 * -movey;// y速度反向 if (y < 0) y = 0; else if (y + size> bb.getHeight() )
		 * y = bb.getHeight() - size;
		 * 
		 * }
		 */

		if (x + 50 >= bb.getWidth() || x <= 0) {
			movex = -movex;// x速度反向
		}
		if (y <= 25 || y + size >= bb.getHeight()) {
			movey = -movey;// y速度反向

		}
		// 小球和小球碰撞处理，比较圆心之间距离，遍历数组队列，找出当前球与其他球的圆心距离
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i);
			if (ball != this) {

				int xx = Math.abs(this.x - ball.x);
				int yy = Math.abs(this.y - ball.y);
				int xy = (int) Math.sqrt(xx * xx + yy * yy);// 两球圆心的距离
				int tempx = 0;
				int tempy = 0;

				if (xy <= (this.size / 2 + ball.size / 2)) {// 距离与相切的圆心距相比较，两球相碰
					tempx = this.movex;
					tempy = this.movey;
					this.movex = ball.movex;// 交换速度
					this.movey = ball.movey;
					ball.movey = tempx;
					ball.movex = tempy;

				}
			}
		}
	}
}