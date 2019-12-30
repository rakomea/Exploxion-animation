
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

public class GUI extends JPanel implements ActionListener, ChangeListener{	
	protected JButton fireworkType; 
	protected JLabel changeLabel; 
	protected JSlider slider, speedSlider, timerSlider; 
	protected JLabel angleLabel, speedLabel, timerLabel; 
	protected Drawing_Panel drawCanvas;
	
	public GUI() {
		setLayout(new BorderLayout());		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.PAGE_AXIS));
		add(topPanel, BorderLayout.NORTH);
		
		JPanel buttonRow = new JPanel();
		buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.LINE_AXIS));
		topPanel.add(buttonRow);
		
		fireworkType = new JButton("Choose your firework type and colors");
		fireworkType.addActionListener(this);
		buttonRow.add(fireworkType);
		
		buttonRow = new JPanel();
		buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.LINE_AXIS));
		topPanel.add(buttonRow);		
		JLabel exploLabel = new JLabel("Choose explosion delay:");
		buttonRow.add(exploLabel);		
		timerSlider = new JSlider(8,20); 
		timerSlider.addChangeListener(this);
		buttonRow.add(timerSlider);		
		timerLabel = new JLabel();
		timerLabel.setText("" + Integer.toString(timerSlider.getValue()) + "s");
		buttonRow.add(timerLabel);		
		changeLabel = new JLabel("");
		buttonRow.add(changeLabel);		
		JLabel commandLabel1 = new JLabel("  Choose an initial launch angle:");
		buttonRow.add(commandLabel1);		
		slider = new JSlider(45,80); 
		slider.addChangeListener(this);
		buttonRow.add(slider);		
		angleLabel = new JLabel();
		angleLabel.setText("" + Integer.toString(slider.getValue()) + "º ");
		buttonRow.add(angleLabel);		
		JLabel commandLabel2 = new JLabel("  Choose your initial launch speed:");
		buttonRow.add(commandLabel2);		
		speedSlider = new JSlider(11, 19); 
		speedSlider.addChangeListener(this);
		buttonRow.add(speedSlider);		
		speedLabel = new JLabel();
		speedLabel.setText("" + Integer.toString(speedSlider.getValue()) + "m/s"); 
		buttonRow.add(speedLabel);
		
		buttonRow = new JPanel();
		buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.LINE_AXIS));
		topPanel.add(buttonRow);		
		JButton button1 = new JButton("View Projectile launch!");
		button1.addActionListener(this);
		buttonRow.add(button1);
		
		buttonRow = new JPanel();
		buttonRow.setLayout(new BoxLayout(buttonRow, BoxLayout.LINE_AXIS));
		topPanel.add(buttonRow);		
		drawCanvas = new Drawing_Panel(slider.getValue(), speedSlider.getValue(), timerSlider.getValue()); 
		this.add(drawCanvas);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) { //for when the buttons are clicked
		String command = e.getActionCommand();
		if (command.equals("View Projectile launch!")) {
			showProjectileLaunch();
		}
		else if (command.equals("Choose your firework type and colors")) {
			viewSelectionFrame();
		}
	}
	@Override
	public void stateChanged(ChangeEvent e) { 
		drawCanvas.erase(); 
		JSlider sliderVal = (JSlider)e.getSource();
		if (sliderVal == slider) {
			angleLabel.setText("" + Integer.toString(sliderVal.getValue()) + "º");
		}else if (sliderVal == speedSlider) {
			speedLabel.setText("" + Integer.toString(sliderVal.getValue()) + " m/s");
		}else if (sliderVal == timerSlider) {
			timerLabel.setText("" + Integer.toString(sliderVal.getValue()) + " s");
		}
	}
	
	Selection_GUI selectionFrame; 
	
	public void viewSelectionFrame() {
		drawCanvas.erase(); //repaint the canvas
		selectionFrame = new Selection_GUI();
		selectionFrame.setVisible(true);
	}
	
	public void showProjectileLaunch() {
		drawCanvas.setangle(slider.getValue()); 
		drawCanvas.setspeed(speedSlider.getValue()); 
		drawCanvas.settime(timerSlider.getValue());
		try{
			if (selectionFrame.typeID == 1) { 
				drawCanvas.drawPath(1, selectionFrame.storedColor1, selectionFrame.storedColor2, selectionFrame.storedColor3, selectionFrame.storedSize);
			}
			else if(selectionFrame.typeID == 2) {
				drawCanvas.drawPath(2, selectionFrame.storedColor1, selectionFrame.storedColor2, selectionFrame.storedColor3, selectionFrame.storedSize);
			}
			else if(selectionFrame.typeID == 3) {
				drawCanvas.drawPath(3, selectionFrame.storedColor1, selectionFrame.storedColor2, selectionFrame.storedColor3, selectionFrame.storedSize);
			}
		}
			catch(Exception e) {
			drawCanvas.drawPath(1, Color.BLUE, Color.BLUE, Color.BLUE, 20);
		}
	}
}

