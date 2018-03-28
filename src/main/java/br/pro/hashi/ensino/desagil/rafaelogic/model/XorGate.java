package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate {
	private Emitter[] emitters;
	private NandGate nand1;
	private NandGate nand2;
	private NandGate nand3;
	private NandGate nand4;

	public XorGate() {
		emitters = new Emitter[2];
		nand1 = new NandGate();
		nand2 = new NandGate();
		nand3 = new NandGate();
		nand4 = new NandGate();
	}
	
	@Override
	public boolean read() {
		nand1.connect(0, emitters[0]);
		nand1.connect(1, emitters[1]);
		nand2.connect(0, emitters[0]);
		nand2.connect(1, nand1);
		nand3.connect(0, emitters[1]);
		nand3.connect(1, nand1);
		nand4.connect(0, nand2);
		nand4.connect(1, nand3);
		
		return nand4.read();
	}

	@Override
	public void connect(int pinIndex, Emitter emitter) {
		emitters[pinIndex] = emitter;
		
	}

}
