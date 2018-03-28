package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate{
	private Emitter[] emitters;
	private NandGate nand1;
	private NandGate nand2;
	private NandGate nand3;
	
	public OrGate() {
		emitters = new Emitter[2];
		nand1 = new NandGate();
		nand2 = new NandGate();
		nand3 = new NandGate();
	}

	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		nand1.connect(0,emitters[0]);
		nand1.connect(1,emitters[0]);
		nand2.connect(0,emitters[1]);
		nand2.connect(1,emitters[1]);
		nand3.connect(0, nand1);
		nand3.connect(1, nand2);
		return nand3.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		// TODO Auto-generated method stub
		emitters[pinIndex] = emitter;
	}

}
