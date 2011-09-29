package fi.dy.esav.JavaApplet;

import java.awt.*;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import java.lang.Math;

public class JavaApplet extends JApplet implements DocumentListener{

	JPanel inputpanel;
	FormLayout inputpanelLayout;
	
	JTextField tf_paaoma, tf_merkitsemispalkkioPros, tf_inflaatio, tf_sijoitusaika, tf_hoitomaksu, tf_oletettutuotto, tf_tuottoprosentti, tf_lahdevero;
	JLabel lbl_muuttujat, lbl_empty, lbl_empty2, lbl_paaoma, lbl_merkitsemispalkkioPros, lbl_inflaatio, lbl_sijoitusaika, lbl_hoitomaksu, lbl_oletettutuotto, lbl_tuottoprosentti, lbl_lahdevero;
	
	public void initInput() {
		initInputPanel();
		createInputComponents();
		setInputLabels();
		addInputComponents();
		createInputListeners();
		
	}
	
	public void initInputPanel() {
		inputpanel = new JPanel();
		inputpanelLayout = new FormLayout(
				new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(175dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC
				},
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
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
				});

		inputpanel.setLayout(inputpanelLayout);
	}
	
	public void createInputComponents() {
		lbl_empty = new JLabel();
		lbl_empty2 = new JLabel();
		lbl_muuttujat = new JLabel();
		
		tf_paaoma = new JTextField();
		tf_merkitsemispalkkioPros = new JTextField();
		tf_inflaatio = new JTextField();
		tf_sijoitusaika = new JTextField();
		tf_hoitomaksu = new JTextField();
		tf_oletettutuotto = new JTextField();
		tf_tuottoprosentti = new JTextField();
		tf_lahdevero = new JTextField();
		
		lbl_paaoma = new JLabel();
		lbl_merkitsemispalkkioPros = new JLabel();
		lbl_inflaatio = new JLabel();
		lbl_sijoitusaika = new JLabel();
		lbl_hoitomaksu = new JLabel();
		lbl_oletettutuotto = new JLabel();
		lbl_tuottoprosentti = new JLabel();
		lbl_lahdevero = new JLabel();
	}
	
	public void createInputListeners() {
		tf_paaoma.getDocument().addDocumentListener(this);
		tf_merkitsemispalkkioPros.getDocument().addDocumentListener(this);
		tf_inflaatio.getDocument().addDocumentListener(this);
		tf_sijoitusaika.getDocument().addDocumentListener(this);
		tf_hoitomaksu.getDocument().addDocumentListener(this);
		tf_oletettutuotto.getDocument().addDocumentListener(this);
		tf_tuottoprosentti.getDocument().addDocumentListener(this);
		tf_lahdevero.getDocument().addDocumentListener(this);
	}
	
	public void setInputLabels() {
		lbl_empty.setText(" ");
		lbl_empty2.setText(" ");
		
		lbl_muuttujat.setText("Muuttujat:");
		lbl_paaoma.setText("sijoitettu pääoma");
		lbl_merkitsemispalkkioPros.setText("merkitsemispalkkio");
		lbl_inflaatio.setText("vuotuinen inflaatio");
		lbl_sijoitusaika.setText("sijoitusaika vuosina");
		lbl_hoitomaksu.setText("<html>vuotuinen hoitomaksu sijoitetusta pääomasta<br> (ei käytetä laskentaan)</html>");
		lbl_tuottoprosentti.setText("<html>oletettu vuosittainen tuotto-%<br> (hoitomaksut tästä jo vähennetty)</html>");
		lbl_lahdevero.setText("lähdevero korkotuotosta");
	}
	
	public void addInputComponents() {
		inputpanel.add(lbl_muuttujat, "2, 2");

		
		inputpanel.add(lbl_paaoma, "2, 4");
		inputpanel.add(tf_paaoma, "4, 4");
		
		inputpanel.add(lbl_merkitsemispalkkioPros, "2, 6");
		inputpanel.add(tf_merkitsemispalkkioPros, "4, 6");
		
		inputpanel.add(lbl_inflaatio, "2, 8");
		inputpanel.add(tf_inflaatio, "4, 8");
		
		inputpanel.add(lbl_sijoitusaika, "2, 10");
		inputpanel.add(tf_sijoitusaika, "4, 10");
		
		inputpanel.add(lbl_hoitomaksu, "2, 12");
		inputpanel.add(tf_hoitomaksu, "4, 12");
		
		inputpanel.add(lbl_tuottoprosentti, "2, 14");
		inputpanel.add(tf_tuottoprosentti, "4, 14");
		
		inputpanel.add(lbl_lahdevero, "2, 16");
		inputpanel.add(tf_lahdevero, "4, 16");
	}
	

	JPanel outputpanel;
	FormLayout outputpanellayout;
	
	JLabel lbl_tulokset;
//	
	JLabel lbl_outalkupaaoma, lbl_outmerkitsemispalkkio, lbl_outhoitomaksut, lbl_outkorkotuotto, lbl_outverot;
	JLabel lbl_outalkupaaoma_num, lbl_outmerkitsemispalkkio_num, lbl_outhoitomaksut_num, lbl_outkorkotuotto_num, lbl_outverot_num;
	
	JLabel lbl_sijoituksenarvo, lbl_arvovaatimus, lbl_tuottoe, lbl_tuottop;
	JLabel lbl_sijoituksenarvo_num, lbl_arvovaatimus_num, lbl_tuottoe_num, lbl_tuottop_num;

	public void initOutput() {
		initOutputPanel();
		createOutputCommponents();
		setOutputLabels();
		addOutputComponents();
	}
	
	public void initOutputPanel() {
		outputpanel = new JPanel();
		outputpanellayout = new FormLayout(
				new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(175dlu;default)"),
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC
				},
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
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
				});
		outputpanel.setLayout(outputpanellayout);
		outputpanel.setBackground(Color.GRAY);
	}
	
	public void createOutputCommponents() {
		lbl_tulokset = new JLabel();
		
		lbl_outalkupaaoma = new JLabel();
		lbl_outmerkitsemispalkkio = new JLabel();
		lbl_outhoitomaksut = new JLabel();
		lbl_outkorkotuotto = new JLabel();
		lbl_outverot = new JLabel();
		
		lbl_outalkupaaoma_num = new JLabel();
		lbl_outmerkitsemispalkkio_num = new JLabel();
		lbl_outhoitomaksut_num = new JLabel();
		lbl_outkorkotuotto_num = new JLabel();
		lbl_outverot_num = new JLabel();
		
		lbl_sijoituksenarvo = new JLabel();
		lbl_arvovaatimus  = new JLabel(); 
		lbl_tuottoe = new JLabel();
		lbl_tuottop = new JLabel();
		
		lbl_sijoituksenarvo_num = new JLabel();
		lbl_arvovaatimus_num = new JLabel();
		lbl_tuottoe_num = new JLabel();
		lbl_tuottop_num = new JLabel();
		
	}
	
	public void setOutputLabels() {
		lbl_tulokset.setText("Tulokset:");
		
		lbl_outalkupaaoma.setText("Alkupääoma");
		lbl_outalkupaaoma.setForeground(Color.GREEN);
		lbl_outalkupaaoma_num.setForeground(Color.GREEN);
		
		lbl_outmerkitsemispalkkio.setText(" - merkitsemispalkkio");
		lbl_outmerkitsemispalkkio.setForeground(Color.RED);
		lbl_outmerkitsemispalkkio_num.setForeground(Color.RED);
		
		lbl_outhoitomaksut.setText("(-hoitomaksut)");
		lbl_outhoitomaksut.setForeground(Color.RED);
		lbl_outhoitomaksut_num.setForeground(Color.RED);
		
		lbl_outkorkotuotto.setText("korkotuotto");
		lbl_outkorkotuotto.setForeground(Color.GREEN);
		lbl_outkorkotuotto_num.setForeground(Color.GREEN);
		
		lbl_outverot.setText(" - verot");
		lbl_outverot.setForeground(Color.RED);
		lbl_outverot_num.setForeground(Color.RED);
		
		lbl_sijoituksenarvo.setText("Sijoituksen arvo kauden lopussa");
		lbl_arvovaatimus.setText("<html>Inflaatiokorjattu sijoituksen<br>arvovaatimus kauden lopussa:</html>");
		
		lbl_tuottoe.setText("<html>Inflaation ylittävä tuotto<br>kun kaikki kulut vähennetty</html>");
		lbl_tuottop.setText("Inflaation ylittävä kokonaistuotto");
		
		
	}
	
	public void addOutputComponents() {
		outputpanel.add(lbl_tulokset, "2, 2");
		
		outputpanel.add(lbl_outalkupaaoma, "2, 4");
		outputpanel.add(lbl_outalkupaaoma_num, "4, 4");
		
		outputpanel.add(lbl_outmerkitsemispalkkio, "2, 6");
		outputpanel.add(lbl_outmerkitsemispalkkio_num, "4, 6");
		
		outputpanel.add(lbl_outhoitomaksut, "2, 8");
		outputpanel.add(lbl_outhoitomaksut_num, "4, 8");
		
		outputpanel.add(lbl_outkorkotuotto, "2, 12");
		outputpanel.add(lbl_outkorkotuotto_num, "4, 12");
		
		outputpanel.add(lbl_outverot, "2, 14");
		outputpanel.add(lbl_outverot_num, "4, 14");
		
		outputpanel.add(lbl_sijoituksenarvo, "2, 18");
		outputpanel.add(lbl_sijoituksenarvo_num, "4, 18");
		
		outputpanel.add(lbl_arvovaatimus, "2, 20");
		outputpanel.add(lbl_arvovaatimus_num, "4, 20");
		
		outputpanel.add(lbl_tuottoe, "2, 24");
		outputpanel.add(lbl_tuottoe_num, "4, 24");

		outputpanel.add(lbl_tuottop, "2, 26");
		outputpanel.add(lbl_tuottop_num, "4, 26");
		
	}
	
	public void init() {
		setSize(500,600);
		setBackground(Color.WHITE);
		
//		setLayout(new GridLayout(1,1));
		
		setLayout(new FormLayout(
				new ColumnSpec[] {
						ColumnSpec.decode("max(500px;default)")
				},
				new RowSpec[] {
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC
				}));
		
		initInput();
		initOutput();
		add(inputpanel, "1, 1");
		add(outputpanel, "1, 4");
		
	}
	



	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		calculate();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		calculate();	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		calculate();	}
	
	public void calculate() {
		
		boolean virhe = false;
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\	
		
		double alkupaaoma = 0;
		
		if (isValid(tf_paaoma.getText())) {
			alkupaaoma = parse( tf_paaoma.getText() );
		} else {
			virhe = true;
		}
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\		
		
		double merkitsemispalkkio_kerr = 0;
		double merkitsemispalkkio = 0;
		
		if (isValid(tf_merkitsemispalkkioPros.getText())) {
			merkitsemispalkkio_kerr = parse( tf_merkitsemispalkkioPros.getText() )/100;
			merkitsemispalkkio = merkitsemispalkkio_kerr * alkupaaoma;
		} else {
			virhe = true;
		}
		
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double sijoitusaika = 0;
		
		if(isValid(tf_sijoitusaika.getText())) {
			sijoitusaika = parse(tf_sijoitusaika.getText());
		} else {
			virhe = true;
		}
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double hoitomaksu_kerr = 0;
		double hoitomaksut_yht = 0;
		
		if(isValid(tf_hoitomaksu.getText())) {
			hoitomaksu_kerr = parse (tf_hoitomaksu.getText())/100;
			hoitomaksut_yht = (alkupaaoma-merkitsemispalkkio)*sijoitusaika*hoitomaksu_kerr;
		} else {
			virhe = true;
		}
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\=(paaoma-merkitsemispalkkio)*((1+tuottoprosentti)^sijoitusaika)-paaoma
		
		double tuottoprosentti = 0;
		
		if(isValid(tf_tuottoprosentti.getText())) {
			tuottoprosentti = parse(tf_tuottoprosentti.getText())/100;
		} else {
			virhe = true;
		}
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double inflaatio = 0;
		
		if(isValid(tf_inflaatio.getText())) {
			inflaatio = parse(tf_inflaatio.getText())/100;
		} else {
			virhe = true;
		}
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

		
		double korkotuotto = (alkupaaoma-merkitsemispalkkio)*Math.pow(1+tuottoprosentti,sijoitusaika)-alkupaaoma;
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		
		double vero = 0;
		double verot_yht = 0;
		
		if(isValid(tf_lahdevero.getText())) {
			vero = parse(tf_lahdevero.getText());
			verot_yht = vero * korkotuotto;
		} else {
			virhe = true;
		}
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double arvo = 0;
		
		arvo = alkupaaoma - merkitsemispalkkio + korkotuotto -verot_yht;
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double arvovaatimus = 0;
		
		arvovaatimus = alkupaaoma * Math.pow(1+inflaatio, sijoitusaika);
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double tuottoe = 0;
		
		tuottoe = arvo - arvovaatimus;
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		double tuottop = 0;
		
		tuottop = tuottoe/alkupaaoma*100;
		
		////////////////////////////////
		//\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		
		if(!virhe) {
			
			lbl_outalkupaaoma_num.setText(toStr(alkupaaoma));
			lbl_outmerkitsemispalkkio_num.setText(toStr(merkitsemispalkkio));
			lbl_outhoitomaksut_num.setText(toStr(hoitomaksut_yht));
			lbl_outkorkotuotto_num.setText(toStr(korkotuotto));
			lbl_outverot_num.setText(toStr(verot_yht));
			lbl_sijoituksenarvo_num.setText(toStr(arvo));
			lbl_arvovaatimus_num.setText(toStr(arvovaatimus));
			lbl_tuottoe_num.setText(toStr(tuottoe));
			lbl_tuottop_num.setText(toStr(tuottop));
			
		} else {
			lbl_outalkupaaoma_num.setText("");
			lbl_outmerkitsemispalkkio_num.setText("Virhe");
			lbl_outhoitomaksut_num.setText("syötteessä!");
			lbl_outkorkotuotto_num.setText("");
			lbl_outverot_num.setText("");
			lbl_sijoituksenarvo_num.setText("");
			lbl_arvovaatimus_num.setText("");
			lbl_tuottoe_num.setText("");
			lbl_tuottop_num.setText("");
		}
		
		
	}
	
	public String toStr(double luku) {
		return Double.toString(luku);
	}
	
	public double parse(String input) {
		double output;
		if (!isValid(input)) {
			return 0;
		}

		
		return Double.parseDouble(input);
	}
	
	
	public boolean isValid(String input) {

		boolean error = false;
		
		try {
			Double.parseDouble(input);
		} catch (Exception e) {
			error = true;
		}
		
		if (error) {
			return false;
		}
		
		return true;
	}
	
}
