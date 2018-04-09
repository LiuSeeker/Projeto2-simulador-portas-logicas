package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.FalseEmitter;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.TrueEmitter;

public class GateView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;


	private Gate gate;

	private	JCheckBox entrada1;
	private	JCheckBox entrada2;
	private JCheckBox saida;


	public GateView(Gate gate) {
		this.gate = gate;

		entrada1 = new JCheckBox();
		entrada2 = new JCheckBox();
		saida = new JCheckBox();

		JLabel entradasLabel = new JLabel("Entradas");
		JLabel saidaLabel = new JLabel("Saída");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(entradasLabel);
		add(entrada1);
		add(entrada2);
		add(saidaLabel);
		add(saida);

		entrada1.addActionListener(this);
		entrada2.addActionListener(this);

		saida.setEnabled(false);

		update();
	}


	private void update() {	
		
		if(entrada1.isSelected()) {
			gate.connect(0, new TrueEmitter());
		}
		
		else if(!entrada1.isSelected()){
			gate.connect(0, new FalseEmitter());
		}
		
		if(entrada2.isSelected()) {
			gate.connect(1, new TrueEmitter());
		}
		
		else if(!entrada2.isSelected()){
			gate.connect(1, new FalseEmitter());
		}
		
		if(gate.read()) {
			saida.setSelected(true);
		}
		
		else if(!gate.read()) {
			saida.setSelected(false);
		}
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
