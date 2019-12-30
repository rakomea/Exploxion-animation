
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Explosion2 extends JPanel implements ActionListener, ChangeListener{
	
	protected JComboBox colorBox1, colorBox2, colorBox3;
	protected JSlider sizeSlider;
	protected JLabel sliderLabel;
	public int size;
	public Color selectedColor1;
	public Color selectedColor2;
	public Color selectedColor3;
	
	public Explosion2() {
		selectedColor1 = Color.BLUE; 
		selectedColor2 = Color.BLUE;
		selectedColor3 = Color.BLUE;
		size = 20; //this is incase the user does not change the values of the JSlider (it defaults to 20)
		 
		setLayout(new BorderLayout());
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BoxLayout(lowerPanel, BoxLayout.PAGE_AXIS));
		add(lowerPanel, BorderLayout.NORTH);
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
		lowerPanel.add(buttonsPanel);
		
		JLabel sizeLabel = new JLabel("Choose the size/width of firework explosion");
		buttonsPanel.add(sizeLabel);		
		sizeSlider = new JSlider(12, 28);
		sizeSlider.addChangeListener(this);
		buttonsPanel.add(sizeSlider);
		
		sliderLabel = new JLabel();
		sliderLabel.setText("" + Integer.toString(sizeSlider.getValue()) + " "); 
		buttonsPanel.add(sliderLabel);
		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
		lowerPanel.add(buttonsPanel);
		
		JLabel colorLabel1 = new JLabel("Color of Projectile path:");
		buttonsPanel.add(colorLabel1);		
		String[] colorSelect1 = { "Green", "Orange", "Yellow", "Red", "Blue" };
		colorBox1 = new JComboBox(colorSelect1);
		colorBox1.addActionListener(this);
		buttonsPanel.add(colorBox1);
		colorBox1.setSelectedIndex(4);
		
		JLabel colorLabel2 = new JLabel("Second explosion color:");
		buttonsPanel.add(colorLabel2);		
		String[] colorSelect2 = { "Green", "Orange", "Yellow", "Red", "Blue" };
		colorBox2 = new JComboBox(colorSelect2);
		colorBox2.addActionListener(this);
		buttonsPanel.add(colorBox2);
		colorBox2.setSelectedIndex(4);

		JLabel colorLabel3 = new JLabel("Third explosion color:");
		buttonsPanel.add(colorLabel3);
		
		String[] colorSelect3 = { "Green", "Orange", "Yellow", "Red", "Blue" };
		colorBox3 = new JComboBox(colorSelect3);
		colorBox3.addActionListener(this);
		buttonsPanel.add(colorBox3);
		colorBox3.setSelectedIndex(4);
	}

	@Override
	public void actionPerformed(ActionEvent e) { //for changes in combobox
			JComboBox combo = (JComboBox)e.getSource();
			int currentSelected = combo.getSelectedIndex();
			combo.setSelectedIndex(currentSelected);
			if (combo.equals(colorBox1)) {
				int color1Index = combo.getSelectedIndex();
				if (color1Index == 0) {
					selectedColor1 = Color.GREEN;
				}else if (color1Index == 1) {
					selectedColor1 = Color.ORANGE;
				}else if (color1Index == 2) {
					selectedColor1 = Color.YELLOW;
				}else if (color1Index == 3) {
					selectedColor1 = Color.RED;
				}else if (color1Index == 4) {
					selectedColor1 = Color.BLUE;
				}
			}else if (combo.equals(colorBox2)){
				int color2Index = combo.getSelectedIndex();
				if (color2Index == 0) {
					selectedColor2 = Color.GREEN;
				}else if (color2Index == 1) {
					selectedColor2 = Color.ORANGE;
				}else if (color2Index == 2) {
					selectedColor2 = Color.YELLOW;
				}else if (color2Index == 3) {
					selectedColor2 = Color.RED;
				}else if (color2Index == 4) {
					selectedColor2 = Color.BLUE;
				}
			}else if (combo.equals(colorBox3)){
				int color3Index = combo.getSelectedIndex();
				if (color3Index == 0) {
					selectedColor3 = Color.GREEN;
				}else if (color3Index == 1) {
					selectedColor3 = Color.ORANGE;
				}else if (color3Index == 2) {
					selectedColor3 = Color.YELLOW;
				}else if (color3Index == 3) {
					selectedColor3 = Color.GREEN;
				}else if (color3Index == 4) {
					selectedColor3 = Color.BLUE;
				}
			}	
	}
	@Override
	public void stateChanged(ChangeEvent e) { //this is for the slider
		JSlider silderVal = (JSlider)e.getSource();
		sliderLabel.setText("" + Integer.toString(silderVal.getValue()) + "    ");
		size = silderVal.getValue();
	}
}
