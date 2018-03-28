package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	private Emitter[] emitters;
	private NandGate nand;
	

	public NotGate() {
		emitters = new Emitter[2];
		nand = new NandGate();
	}
	
	@Override
	public boolean read() {
		nand.connect(0, emitters[0]);
		nand.connect(1, emitters[0]);
		return nand.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		emitters[pinIndex] = emitter;
		
	}

}
