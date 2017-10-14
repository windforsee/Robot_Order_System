import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sleep extends RobotGUI implements ActionListener{
	
	JFrame frame;
	JButton button=new JButton("When you back, touch me ~");
	JLabel label=new JLabel("I'm sleeping now...z z Z",JLabel.CENTER);
	Font bigFont=new Font("serif",Font.BOLD,39);
	Thread thread1;

	
	Sleep(JFrame frame){
		this.frame=frame;

	}
	
	public void bulidSleep(){
		button.setFont(bigFont);
		label.setFont(bigFont);
		frame.getContentPane().setBackground(new Color(102,255,204));
		button.setBackground(new Color(245,245,224));
		button.addActionListener(this);
		
		frame.getContentPane().add(BorderLayout.CENTER,label);
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.setVisible(true);
	}//build the sleep GUI

	
	
	
	public void actionPerformed(ActionEvent event){
		button.setVisible(false);
		label.setVisible(false);
		
		class MyMouseListener implements MouseMotionListener{
			public void mouseMoved(MouseEvent ev){
				thread1.interrupt();
				System.out.println("active");
			}
			public void mouseDragged(MouseEvent ev){
				thread1.interrupt();
				System.out.println("active");
			}
		}//check the active
		
		
		
		thread1 = new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10000);
						Sleep shuimian = new Sleep(frame);
						shuimian.bulidSleep();
						return;
					} catch (InterruptedException e) {}
				}
			}
		});
		frame.addMouseMotionListener(new MyMouseListener());
		thread1.start();
		
		
		frame.getContentPane().removeAll();
		Homepage miku = new Homepage(frame);
		miku.buildHome();
		//when customer come back, wake the Robot up
	}
	
	

}