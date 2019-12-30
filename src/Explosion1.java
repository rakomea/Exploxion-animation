
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Explosion1 extends JPanel implements ActionListener{
	
	protected JComboBox colorBox1;
	public Color selectedColor1;
	
	public Explosion1() {
		selectedColor1 = Color.BLUE; 		
		setLayout(new BorderLayout());
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.PAGE_AXIS));
		add(lowerPanel, BorderLayout.NORTH);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
		lowerPanel.add(buttonsPanel);
		
		JLabel colorLabel = new JLabel("Color of Projectile path:");
		buttonsPanel.add(colorLabel);
		
		String[] colorSelect1 = { "Red", "Orange", "Yellow", "Green", "Blue" };
		colorBox1 = new JComboBox(colorSelect1);
		colorBox1.setSelectedIndex(4);
		colorBox1.addActionListener(this);
		buttonsPanel.add(colorBox1);
		
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
		}
	}

}