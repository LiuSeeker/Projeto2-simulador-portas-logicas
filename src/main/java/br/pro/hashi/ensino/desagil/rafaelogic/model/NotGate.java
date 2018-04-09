package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	private NandGate nand;
	

	public NotGate() {
		super("NOT");
		nand = new NandGate();
	}
	
	@Override
	public boolean read() {
		return nand.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(0, emitter);
		nand.connect(1, emitter);
	}

	@Override
	public double size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
