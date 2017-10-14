import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RobotGUI {

	public static void main(String[] args){
		final JFrame frame=new JFrame();

		
	
		
		final Thread thread = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(30000);
						frame.getContentPane().removeAll();
						Sleep shuimian = new Sleep(frame);
						shuimian.bulidSleep();
						return;
					} catch (InterruptedException e) {}
				}
			}
		});
		//make the listener to frame ,then accomplishment sleep function

		
		
		class MyMouseListener implements MouseMotionListener{
			public void mouseMoved(MouseEvent ev){
				thread.interrupt();
				System.out.println("active");
			}
			public void mouseDragged(MouseEvent ev){
				thread.interrupt();
				System.out.println("active");
			}
		}
		

	
	    frame.addMouseMotionListener(new MyMouseListener());
		thread.start();
		
		
		
		Welcome well=new Welcome(frame);
		well.buildWelcome();
		//make the first GUI, which will build welcome message

	}


	
}