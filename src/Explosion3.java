
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Explosion3 extends JPanel implements ActionListener{	
	protected JComboBox colorBox1, colorBox2;
	public Color selectedColor1, selectedColor2;
	
	public Explosion3() {
		selectedColor1 = Color.BLUE; 
		selectedColor2 = Color.BLUE;		
		setLayout(new BorderLayout());
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.PAGE_AXIS));
		add(lowerPanel, BorderLayout.NORTH);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
		lowerPanel.add(buttonsPanel);
		
		JLabel colorLabel1 = new JLabel("Color of path/explosion");
		buttonsPanel.add(colorLabel1);		
		String[] colorSelect1 = { "Red", "Orange", "Yellow", "Green", "Blue" };
		colorBox1 = new JComboBox(colorSelect1);
		colorBox1.setSelectedIndex(4);
		colorBox1.addActionListener(this);
		buttonsPanel.add(colorBox1);
		
		JLabel colorLabel2 = new JLabel("Color of explosion:");
		buttonsPanel.add(colorLabel2);		
		String[] colorSelect2 = { "Red", "Orange", "Yellow", "Green", "Blue" };
		colorBox2 = new JComboBox(colorSelect2);
		colorBox2.setSelectedIndex(4);
		colorBox2.addActionListener(this);
		buttonsPanel.add(colorBox2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
			JComboBox src = (JComboBox)e.getSource();
			int currentSelected = src.getSelectedIndex();
			src.setSelectedIndex(currentSelected);
			if (src.equals(colorBox1)) {
				int box1Index = src.getSelectedIndex();
				if (box1Index == 0) {
					selectedColor1 = Color.RED;
				}else if (box1Index == 1) {
					selectedColor1 = Color.ORANGE;
				}else if (box1Index == 2) {
					selectedColor1 = Color.YELLOW;
				}else if (box1Index == 3) {
					selectedColor1 = Color.GREEN;
				}else if (box1Index == 4) {
					selectedColor1 = Color.BLUE;
				}
			}else if (src.equals(colorBox2)){
				int box2Index = src.getSelectedIndex();
				if (box2Index == 0) {
					selectedColor2 = Color.RED;
				}else if (box2Index == 1) {
					selectedColor2 = Color.ORANGE;
				}else if (box2Index == 2) {
					selectedColor2 = Color.YELLOW;
				}else if (box2Index == 3) {
					selectedColor2 = Color.GREEN;
				}else if (box2Index == 4) {
					selectedColor2 = Color.BLUE;
				}
			}	
	}

}