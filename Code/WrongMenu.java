import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class WrongMenu extends RobotGUI {
	
	

	/**
	 * produce the menu option button
	 */
	JFrame frame;
	
	JButton fish = new JButton("<html>1<br>fish<html>");
	JButton meat = new JButton("<html>2<br>meat<html>");
	JButton rice = new JButton("<html>3<br>rice<html>");
	JButton noodle = new JButton("<html>4<br>noodle<html>");
	JButton drink = new JButton("<html>5<br>drink<html>");
	JButton none = new JButton("");

	JTextField field = new JTextField(5);

	JPanel menulist = new JPanel();
	JPanel option = new JPanel();
	JLabel please;

	String choose;
	
	int i = 0;
	
	WrongMenu(JFrame frame){
		this.frame = frame;
	}



	public void buildMenuGUI(){

		frame.getContentPane().setBackground(new Color(102,255,204));//make the background color to be sky blue

		please=new JLabel("Wrong input. Please select again :");//make word in top frame
		frame.getContentPane().add(BorderLayout.NORTH,please);
		
		Font bigFont=new Font("serif",Font.BOLD,32);
		please.setFont(bigFont);//make the top word bigger

		menulist.add(fish);
		menulist.add(meat);
		menulist.add(rice);
		menulist.add(noodle);
		menulist.add(drink);
		menulist.add(none);

		GridLayout method=new GridLayout(2,3);//make select in center frame
		int w=menulist.getWidth();
		int h=menulist.getHeight();
		menulist.setLayout(method);
		fish.setSize(w/2,h/2);
		fish.setBackground(new Color(65,105,225));
		meat.setSize(w/2,h/2);
		meat.setBackground(new Color(218,165,32));
		rice.setSize(w/2,h/2);
		rice.setBackground(new Color(0,191,255));
		noodle.setSize(w/2,h/2);
		noodle.setBackground(new Color(255,250,179));
		drink.setSize(w/2,h/2);
		drink.setBackground(new Color(238,130,238));
		none.setSize(w/2,h/2);
		none.setBackground(new Color(90,243,195));
		fish.setFont(bigFont);//make the option word bigger
		meat.setFont(bigFont);
		rice.setFont(bigFont);
		noodle.setFont(bigFont);
		drink.setFont(bigFont);
		frame.getContentPane().add(BorderLayout.CENTER,menulist);

		JLabel optionword=new JLabel("Option selected:",JLabel.RIGHT);//make option in bottom frame
		optionword.setFont(bigFont);
		field.addActionListener(new getnum());


		option.setBackground(new Color(102,255,204));
		option.add(optionword);
		option.add(field);
		frame.getContentPane().add(BorderLayout.SOUTH,option);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,500);
		frame.setVisible(true);
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			public void run() {
				if(i==0){
				option.setVisible(false);
				menulist.setVisible(false);
				please.setVisible(false);
				Sleep kun=new Sleep(frame);
				kun.bulidSleep();
				i=1;
				}

			}
		},30000);
		//check the customer is active
		
	}

	class getnum implements ActionListener{
		public void actionPerformed(ActionEvent event){
		choose=field.getText();

			if(choose.equals("1")){
			option.setVisible(false);
			menulist.setVisible(false);
			please.setVisible(false);
			DishesCreater fishMenu=new DishesCreater(frame,1);
			fishMenu.buildDishesGUI();
			}
			if(choose.equals("2")){
			option.setVisible(false);
			menulist.setVisible(false);
			please.setVisible(false);
			DishesCreater meatMenu=new DishesCreater(frame,2);
			meatMenu.buildDishesGUI();
			}
			if(choose.equals("3")){
			option.setVisible(false);
			menulist.setVisible(false);
			please.setVisible(false);
			DishesCreater RiceMenu=new DishesCreater(frame,3);
			RiceMenu.buildDishesGUI();
			}
			if(choose.equals("4")){
			option.setVisible(false);
			menulist.setVisible(false);
			please.setVisible(false);
			DishesCreater NoodleMenu=new DishesCreater(frame,4);
			NoodleMenu.buildDishesGUI();
			}
			if(choose.equals("5")){
			option.setVisible(false);
			menulist.setVisible(false);
			please.setVisible(false);
			DishesCreater DrinkMenu=new DishesCreater(frame,5);
			DrinkMenu.buildDishesGUI();
			}
			if(!choose.equals("1")&&!choose.equals("2")&&!choose.equals("3")&&!choose.equals("4")&&!choose.equals("5")) {
				please.setVisible(false);
				please=new JLabel("The choice is not available.Please select again :");
				frame.getContentPane().add(BorderLayout.NORTH,please);
				Font bigFont=new Font("serif",Font.BOLD,39);
				please.setFont(bigFont);
			}//type number again to come in another page
		}
	}




	
	
	
}

