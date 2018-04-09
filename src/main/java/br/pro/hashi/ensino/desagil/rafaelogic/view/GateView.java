package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	private LinkedList<Source> sources;
	private JCheckBox saida;
	private LinkedList<JCheckBox> checkBoxes;

	public GateView(Gate gate) {
		this.gate = gate;
		
		sources = new LinkedList<>();
		checkBoxes = new LinkedList<>();
		
		for(int i = 0;gate.getSize() > i; i++) {
			JCheckBox checkBox = new JCheckBox();
			Source source = new Source();
			checkBoxes.add(checkBox);
			sources.add(source);
		}
		
		saida = new JCheckBox();

		JLabel entradasLabel = new JLabel("Entradas");
		JLabel saidaLabel = new JLabel("Saída");

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(entradasLabel);
		for(JCheckBox box: checkBoxes) {
			add(box);
		}
		add(saidaLabel);
		add(saida);

		
		for(JCheckBox box: checkBoxes) {
			box.addActionListener(this);
		}
		
		saida.setEnabled(false);

		update();
	}

	private void update() {	
		for(int i = 0; checkBoxes.size() > i; i++) {
			sources.get(i).turn(checkBoxes.get(i).isSelected());
			gate.connect(i,  sources.get(i));
		}
		saida.setSelected(gate.read());
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
}
