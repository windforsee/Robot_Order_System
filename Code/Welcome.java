import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Color;

public class Welcome extends RobotGUI implements ActionListener{

	JFrame frame;
	JButton button;
	public String greetingword[]=new String[4];
	
	Welcome (JFrame frame){
		this.frame = frame;
	}
	
	
	public void buildWelcome() {
		int i = (int) (Math.random()*4);
		String a1 = "Hello";
		String a2 = "Hi";
		String a3 = "How are you today?";
		String a4 = "Isn¡¯t the weather great";
		String a5 = "Hi, I hope you are having a good day!";
		String a0 = "Hello";
		String a;
		switch (i){
		case 0:
			a = a0;
			break;
		case 1:
			a = a1;
			break;
		case 2:
			a = a2;
			break;
		case 3:
			a = a3;
			break;
		case 4:
			a = a4;
			break;
		default:
			a = a5;
			break;
		}
		//random produce the greeting word
		
		
		button=new JButton(a);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 39));
		button.setBackground(new Color(102,255,204));
		button.addActionListener(this);
		frame.setBounds(100, 100, 1000, 500);
		frame.getContentPane().add(BorderLayout.CENTER,button);
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}//build the GUI of welcome
	
	public void actionPerformed(ActionEvent event){
		
		frame.getContentPane().removeAll();
		Homepage menu=new Homepage(frame);
		menu.buildHome();
		frame.setBounds(100, 100, 1000, 500);
			
	}//Click the button to come in the Menu
	
}
