import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NullDishes extends RobotGUI {
	JTextField field;
	JFrame frame;
	JLabel please;
	JPanel menulist = new JPanel();
	JPanel option = new JPanel();
	String restart;
	
	NullDishes(JFrame frame,String choose){
		this.frame = frame;
		this.restart = choose;
	}

	public void buildrestartGUI(){

		/**
		 * produce the menu option button
		 */
		
		String fishMenu[] = new String[6];
		Scanner input = null;
		File fishfile = new File("Files/FishDishes.txt");
		try {
			input = new Scanner(fishfile);
			int i = 0;
			while(input.hasNext()) {
				fishMenu[i] = input.nextLine();
				i++;
				}//random produce the greeting word
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JButton a = new JButton(fishMenu[0]);
		JButton b = new JButton(fishMenu[1]);
		JButton c = new JButton(fishMenu[2]);
		JButton d = new JButton(fishMenu[3]);
		JButton e = new JButton(fishMenu[4]);
		JButton f = new JButton(fishMenu[5]);

		frame.getContentPane().setBackground(new Color(102,255,204));//make the background color to be sky blue

		please = new JLabel("The choice is not available.Please select again :");//make word in top frame
		frame.getContentPane().add(BorderLayout.NORTH,please);
		
		Font bigFont=new Font("serif",Font.BOLD,39);
		please.setFont(bigFont);//make the top word bigger

		menulist.add(a);
		menulist.add(b);
		menulist.add(c);
		menulist.add(d);
		menulist.add(e);
		menulist.add(f);

		GridLayout method=new GridLayout(2,3);//make select in center frame
		int w = menulist.getWidth();
		int h = menulist.getHeight();
		menulist.setLayout(method);
		a.setSize(w/2,h/2);
		a.setBackground(new Color(65,105,225));
		b.setSize(w/2,h/2);
		b.setBackground(new Color(218,165,32));
		c.setSize(w/2,h/2);
		c.setBackground(new Color(0,191,255));
		d.setSize(w/2,h/2);
		d.setBackground(new Color(255,250,179));
		e.setSize(w/2,h/2);
		e.setBackground(new Color(238,130,238));
		f.setSize(w/2,h/2);
		f.setBackground(new Color(90,243,195));
		a.setFont(bigFont);//make the option word bigger
		b.setFont(bigFont);
		c.setFont(bigFont);
		d.setFont(bigFont);
		e.setFont(bigFont);
		f.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.CENTER,menulist);
		//set the basic seting

		JLabel optionword=new JLabel("Option selected:",JLabel.RIGHT);//make option in bottom frame
		optionword.setFont(bigFont);
		field=new JTextField(5);
		field.addActionListener(new getnum());


		option.setBackground(new Color(102,255,204));
		option.add(optionword);
		option.add(field);
		frame.getContentPane().add(BorderLayout.SOUTH,option);
		
		frame.setSize(1000,500);
		frame.setVisible(true);
	}

	class getnum implements ActionListener{
		public void actionPerformed(ActionEvent event){
		String choose = field.getText();
		int choiceT = Integer.parseInt(choose);
		System.out.println(choose);
		please.setVisible(false);
		ConfirmMenu now = new ConfirmMenu(frame,choiceT,restart,menulist,option,field);
		now.confirm();
		}
	}
}
		
		
