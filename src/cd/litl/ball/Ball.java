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

	public void clearBall(Graphics g, Blackball bb) {// ���С��
		g.setColor(bb.getContentPane().getBackground());
		g.fillOval(x - 1, y - movey, size + 1, size + 1);

	}

	public void drawBall(Graphics g) {// ��С��
		g.setColor(color);
		g.fillOval(x, y, size, size);

	}

	public void moveBall() {// �ƶ�С��
		x += movex;
		y += movey;

	}

	public void collision(Graphics g, Blackball bb, ArrayList<Ball> list) {

		/*
		 * if (x + size >= 500) {// �����Ҳ�߿򷴵� movex = -movex; } if (y + size >=
		 * 700) {// ����ײ����� movey = -movey; } if (x <= 0) {// ������߷��� movex =
		 * -movex; } if (y <= 25) {// ���嶥������ movey = -movey; }
		 */
		/*
		 * //���xԽ�� if (x <= 0 || x + size >= 500) { movex = -movex;// x�ٶȷ��� if
		 * (x < 0) x = 0; else if (x + size>=500 ) x = bb.getWidth() - size;
		 * 
		 * } // ���yԽ�� if (y <= 25 || y + size >= bb.getHeight()) { movey =
		 * -movey;// y�ٶȷ��� if (y < 0) y = 0; else if (y + size> bb.getHeight() )
		 * y = bb.getHeight() - size;
		 * 
		 * }
		 */

		if (x + 50 >= bb.getWidth() || x <= 0) {
			movex = -movex;// x�ٶȷ���
		}
		if (y <= 25 || y + size >= bb.getHeight()) {
			movey = -movey;// y�ٶȷ���

		}
		// С���С����ײ�����Ƚ�Բ��֮����룬����������У��ҳ���ǰ�����������Բ�ľ���
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i);
			if (ball != this) {

				int xx = Math.abs(this.x - ball.x);
				int yy = Math.abs(this.y - ball.y);
				int xy = (int) Math.sqrt(xx * xx + yy * yy);// ����Բ�ĵľ���
				int tempx = 0;
				int tempy = 0;

				if (xy <= (this.size / 2 + ball.size / 2)) {// ���������е�Բ�ľ���Ƚϣ���������
					tempx = this.movex;
					tempy = this.movey;
					this.movex = ball.movex;// �����ٶ�
					this.movey = ball.movey;
					ball.movey = tempx;
					ball.movex = tempy;

				}
			}
		}
	}
}