package cd.litl.ball;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class BlackballListener extends MouseAdapter implements Runnable,
		KeyListener {

	private Blackball bb;
	private ArrayList<Ball> list;
	private volatile boolean pauseFlag = true, stopFlag = true;
	private Random rand = new Random();

	// 不需要画笔因为监听器这里没用到画笔

	public BlackballListener(Blackball bb, ArrayList<Ball> list) {

		this.bb = bb;
		this.list = list;

	}

	/**
	 * 发生鼠标点击动作时执行此方法
	 */
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Ball ball = new Ball(x, y, new Color(rand.nextInt(255),
				rand.nextInt(255), rand.nextInt(255)), 50, 5,5);
		list.add(ball);
		System.out.println(">>>>>" + list.size());// 输出数组大小
	}

	public void run() {

		while (stopFlag) {
			//System.out.println("start");
			if (pauseFlag) {
				bb.repaint();
				try {
					Thread.sleep(80);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case 32:// 空格 暂停
			pauseFlag = !pauseFlag;// 属性存在内存，不是寄存器，线程在寄存器里运行
			break;
		case 27:// Esc 退出线程
			stopFlag = false;
			break;
		case 82:// 'r' 重新开始
			list.clear();
			bb.repaint();
			stopFlag = true;
			pauseFlag = true;
			new Thread(this).start();
			break;

		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
}
