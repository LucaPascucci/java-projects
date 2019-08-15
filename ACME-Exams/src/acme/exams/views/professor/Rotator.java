package acme.exams.views.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.jfree.chart.plot.PiePlot3D;

/**
 * Utility class for rotating a pie3d plot
 * @author Andrea Santi 
 */

class Rotator extends Timer implements ActionListener{

	private PiePlot3D plot;
	private int angle;
	private static final long serialVersionUID=1;
	/**
	 * Constructs a new Rotator
	 * passato in ingresso
	 * @param pieplot3d The pieplot to rotate
	 */
	public Rotator(PiePlot3D pieplot3d) {
		super(100, null);
		angle = 270;
		plot = pieplot3d;
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent actionevent){
		plot.setStartAngle(angle);
		angle = angle + 1;
		if(angle == 360)angle = 0;
	}
}