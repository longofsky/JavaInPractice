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

	// ����Ҫ������Ϊ����������û�õ�����

	public BlackballListener(Blackball bb, ArrayList<Ball> list) {

		this.bb = bb;
		this.list = list;

	}

	/**
	 * �������������ʱִ�д˷���
	 */
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Ball ball = new Ball(x, y, new Color(rand.nextInt(255),
				rand.nextInt(255), rand.nextInt(255)), 50, 5,5);
		list.add(ball);
		System.out.println(">>>>>" + list.size());// ��������С
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
		case 32:// �ո� ��ͣ
			pauseFlag = !pauseFlag;// ���Դ����ڴ棬���ǼĴ������߳��ڼĴ���������
			break;
		case 27:// Esc �˳��߳�
			stopFlag = false;
			break;
		case 82:// 'r' ���¿�ʼ
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
