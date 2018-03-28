package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{
	private Emitter[] emitters;
	private NandGate nand1;
	private NandGate nand2;
	
	public AndGate() {
		emitters = new Emitter[2];
		nand1 = new NandGate();
		nand2 = new NandGate();
	}
	
	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		nand1.connect(0,emitters[0]);
		nand1.connect(1,emitters[1]);
		nand2.connect(0, nand1);
		nand2.connect(1, nand1);
		return nand2.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		// TODO Auto-generated method stub
		emitters[pinIndex] = emitter;
	}

}
