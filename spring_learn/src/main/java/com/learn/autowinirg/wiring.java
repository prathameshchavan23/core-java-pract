package com.learn.autowinirg;

import org.springframework.beans.factory.annotation.Autowired;

public class wiring {
//	@Autowired
	private wireType wire;


	public wireType getWire() {
		return wire;
	}
//	@Autowired
	public void setWire(wireType wire) {
		this.wire = wire;
		System.out.println("Setting");
	}

	@Autowired
	
	public wiring(wireType wire) {
		super();
		this.wire = wire;
		System.out.println("isndie ctor");
	}

	public wiring() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "wiring [wire=" + wire + "]";
	}
	
	
	
	
}
