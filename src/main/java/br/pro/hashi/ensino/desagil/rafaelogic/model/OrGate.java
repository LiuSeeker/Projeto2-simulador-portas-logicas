package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate{
	private NandGate nand1;
	private NandGate nand2;
	private NandGate nand3;
	
	public OrGate() {
		super("OR", 2);
		nand1 = new NandGate();
		nand2 = new NandGate();
		nand3 = new NandGate();
		nand3.connect(0, nand1);
		nand3.connect(1, nand2);
	}

	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		return nand3.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		// TODO Auto-generated method stub
		if(pinIndex == 0) {
			nand1.connect(0, emitter);
			nand1.connect(1, emitter);
		}
		if(pinIndex == 1) {
			nand2.connect(0, emitter);
			nand2.connect(1, emitter);
		}
		
	}
}
