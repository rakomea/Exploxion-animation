

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Selection_GUI extends JFrame implements ActionListener{	
	protected JButton explosionOne, explosionTwo, explosionThree, executeButton;
	protected JLabel userType;
	protected JPanel bottomPanel, holderPanel;
	public int typeID;
	public Color storedColor1, storedColor2, storedColor3;
	public int storedSize;
	
	public Selection_GUI(){
		this.setTitle("Choose type of firework and color");
		this.setSize(650, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//does not exit application on close, simply returns to the other frame
		
		setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		add(topPanel, BorderLayout.NORTH);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.PAGE_AXIS));
		add(bottomPanel, BorderLayout.SOUTH);
		
		holderPanel = new JPanel();
		holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
		topPanel.add(holderPanel);
		
		JLabel selectionLabel = new JLabel("Select FireWork Type");
		holderPanel.add(selectionLabel);
		
		holderPanel = new JPanel();
		holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
		topPanel.add(holderPanel);
		
		explosionOne = new JButton("Spread in Two"); //type 1
		explosionOne.setFont(new Font("Serif", Font.PLAIN, 15));
		explosionOne.addActionListener(this);
		holderPanel.add(explosionOne);
		
		explosionTwo = new JButton("Circle on Circle"); //type 2
		explosionTwo.setFont(new Font("Serif", Font.PLAIN, 15));
		explosionTwo.addActionListener(this);
		holderPanel.add(explosionTwo);

		explosionThree = new JButton("Spread in Two then two");//type 3
		explosionThree.setFont(new Font("Serif", Font.PLAIN, 15));
		explosionThree.addActionListener(this);
		holderPanel.add(explosionThree);

		holderPanel = new JPanel();
		holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
		topPanel.add(holderPanel);
		
		userType = new JLabel();
		userType.setText("You Have Selected: ");
		holderPanel.add(userType);
		
		executeButton = new JButton("Got to Launch Panel");
		executeButton.addActionListener(this);
		
	}
	Explosion1 select1; 
	Explosion2 select2;
	Explosion3 select3;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("Spread in Two")) {
			userType.setText("Your selection: Spread in Two");
			bottomPanel.removeAll(); 
			select1 = new Explosion1();
			bottomPanel.add(select1);
			holderPanel = new JPanel();
			holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
			bottomPanel.add(holderPanel);
			holderPanel.add(executeButton);
			typeID = 1; 
			
		}else if (actionCommand.equals("Circle on Circle")) {
			userType.setText("Your selection: Circle on Circle");
			bottomPanel.removeAll();
			select2 = new Explosion2();
			bottomPanel.add(select2);
			holderPanel = new JPanel();
			holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
			bottomPanel.add(holderPanel);
			holderPanel.add(executeButton);
			typeID = 2;
			
		}else if (actionCommand.equals("Spread in Two then two")) { 
			userType.setText("Your selection: Spread in Two then two");
			bottomPanel.removeAll();
			select3 = new Explosion3();
			bottomPanel.add(select3);
			holderPanel = new JPanel();
			holderPanel.setLayout(new BoxLayout(holderPanel, BoxLayout.LINE_AXIS));
			bottomPanel.add(holderPanel);
			holderPanel.add(executeButton);
			typeID = 3;
			
		}
		else if (actionCommand.equals("Got to Launch Panel")) { 
			
			if (typeID == 1) {
				storedColor1 = select1.selectedColor1;
			}
			else if (typeID == 2) {
				storedColor1 = select2.selectedColor1;
				storedColor2 = select2.selectedColor2;
				storedColor3 = select2.selectedColor3;
				storedSize =select2.size;
			}
			else if (typeID == 3) {
				storedColor1 = select3.selectedColor1;
				storedColor2 = select3.selectedColor2;
			}
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); //closes itself when go button is clicked
		}
	}
}

