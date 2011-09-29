package fi.dy.esav.JavaApplet;

import javax.swing.JApplet;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Applet extends JApplet {
	private JTextField textField;

	/**
	 * Create the applet.
	 */
	public Applet() {
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(65dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblMuuttujat = new JLabel("Muuttujat:");
		getContentPane().add(lblMuuttujat, "2, 2");
		
		JLabel lblNewLabel = new JLabel("New label");
		getContentPane().add(lblNewLabel, "2, 4");
		
		textField = new JTextField();
		getContentPane().add(textField, "4, 4, fill, default");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		getContentPane().add(lblNewLabel_1, "2, 6");
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		getContentPane().add(lblNewLabel_2, "2, 8");
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		getContentPane().add(lblNewLabel_3, "2, 10");

	}

}
