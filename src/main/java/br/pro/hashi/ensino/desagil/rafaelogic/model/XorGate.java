package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate {
	private NandGate nand1;
	private NandGate nand2;
	private NandGate nand3;
	private NandGate nand4;

	public XorGate() {
		super("XOR");
		nand1 = new NandGate();
		nand2 = new NandGate();
		nand3 = new NandGate();
		nand4 = new NandGate();
		nand2.connect(0, nand1);
		nand3.connect(0, nand1);
		nand4.connect(0, nand2);
		nand4.connect(1, nand3);
	}
	
	@Override
	public boolean read() {
		return nand4.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		if(pinIndex == 0) {
			nand2.connect(1, emitter);
			nand1.connect(0, emitter);
		}
		if(pinIndex == 1) {
			nand3.connect(1, emitter);
			nand1.connect(1, emitter);
		}
		
	}

	@Override
	public double size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
