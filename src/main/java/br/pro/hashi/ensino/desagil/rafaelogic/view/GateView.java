package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.LinkedList;

import javax.swing.JCheckBox;
import javax.swing.JColorChooser;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

public class GateView extends SimplePanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	private LinkedList<Source> sources;
	private JCheckBox saida;
	private LinkedList<JCheckBox> checkBoxes;
	private LinkedList<Integer> y;
	private Color color;
	private int cor;

	public GateView(Gate gate) {
		super(300, 300);

		this.gate = gate;

		sources = new LinkedList<>();
		checkBoxes = new LinkedList<>();
		y = new LinkedList<>();
		

		for(int i = 0;gate.getSize() > i; i++) {
			JCheckBox checkBox = new JCheckBox();
			Source source = new Source();
			checkBoxes.add(checkBox);
			sources.add(source);
		}

		saida = new JCheckBox();

		if(checkBoxes.size() == 1) {
			y.add(142);
		}
		else if(checkBoxes.size() == 2) {
			y.add(200);
			y.add(100);
		}

		for(int i = 0; checkBoxes.size() > i; i++) {
			add(checkBoxes.get(i),45,y.get(i),18,18);
		}
		//add(saida,245,142,18,18);


		for(JCheckBox box: checkBoxes) {
			box.addActionListener(this);
		}

		saida.setEnabled(false);

		update();
		
		addMouseListener(this);
	}

	private void update() {	
		for(int i = 0; checkBoxes.size() > i; i++) {
			sources.get(i).turn(checkBoxes.get(i).isSelected());
			gate.connect(i,  sources.get(i));
		}
		saida.setSelected(gate.read());
		
		if(gate.read() == true) {
			color = Color.RED;
			cor = 1;
			repaint();
		}
		else {
			color = Color.BLACK;
			cor = 0;
			repaint();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		
		int x = event.getX();
		int y = event.getY();
		double k;

		k = Math.sqrt(Math.pow(255-x, 2)+Math.pow(152-y, 2));
		
		if(k <= 10 && cor == 1) {
			color = JColorChooser.showDialog(this, null, color);
			repaint();
		}
	}

	@Override
	public void mouseEntered(MouseEvent event) {		
	}

	@Override
	public void mouseExited(MouseEvent event) {		
	}

	@Override
	public void mousePressed(MouseEvent event) {		
	}

	@Override
	public void mouseReleased(MouseEvent event) {		
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.fillOval(245, 142, 20, 20);

		getToolkit().sync();

	}

}
