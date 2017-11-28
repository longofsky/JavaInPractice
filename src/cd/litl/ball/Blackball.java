package cd.litl.ball;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JFrame;
/*
 *@author 依米
 */
@SuppressWarnings("serial")
public class Blackball extends JFrame {

	private Image image;
	private Graphics2D g2d;
	private ArrayList<Ball> list;

	/**
	 * Blackball 入口函数
	 * @param args
	 */
	public static void main(String[] args) {
		Blackball b = new Blackball();
		b.InitUI();

	}

	public void InitUI() {
		list = new ArrayList<Ball>();
		this.setTitle("Ball Ball Ball~~~");
		this.setDefaultCloseOperation(3);
		this.setSize(500, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setVisible(true);

		BlackballListener bl = new BlackballListener(this, list);// 加监听器
		this.addMouseListener(bl);
		this.addKeyListener(bl);
		Thread t = new Thread(bl);// 实例化线程
		t.start();

	}
	public void paint(Graphics g) {
		// super.paint(g);
		// if(image==null){
		image = this.createImage(this.getWidth(), this.getHeight());
		g2d = (Graphics2D) image.getGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);// 开启画笔抗锯齿
		// }
		for (int i = 0; i < list.size(); i++) {
			Ball ball = (Ball) list.get(i);// 取出球

//			if (ball.getY() + 50 < this.getHeight()) {
				ball.clearBall(g2d, this);
				ball.moveBall();
				ball.collision(g2d, this, list);
				ball.drawBall(g2d);
//				System.out.println("ball  y:"+ball.getY());
//			}
		}
		g.drawImage(image, 0, 0, this);

	}
}






