package com.jag.core;

import java.util.ArrayList;

import com.jag.ui.JagUI;

public class Jag {
	private static Jag jagInstance;
	
	private JagUI jagUI;
	private ArrayList<RS3Context> contexts;
	
	private Jag() {
		this.jagUI = new JagUI();
		this.contexts = new ArrayList<RS3Context>();
		
		addRS3();
		
		jagUI.pack();
		jagUI.setVisible(true);
	}
	
	public static Jag getInstance() {
		return jagInstance == null ? jagInstance = new Jag() : jagInstance;
	}
	
	public void addRS3() {
		RS3Context context = new RS3Context();
		contexts.add(context);
		new Thread(context).start();
	}
	
	public JagUI getJagUI() {
		return jagUI;
	}

}
