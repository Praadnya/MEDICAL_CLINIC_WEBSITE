package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class OBH {
	public OBH() {
        this.children = new ArrayList<>();
    }

    private int MA;
    private String MP;
    private int MCU;
    private int MCB;
    private String LMP;
    private int P;
    private int G;
    private String A;
    private int L;
    private List<Child> children;
    
    public int getMA() {
		return MA;
	}
	public void setMA(int mA) {
		MA = mA;
	}
	public String getMP() {
		return MP;
	}
	public void setMP(String mP) {
		MP = mP;
	}
	public int getMCU() {
		return MCU;
	}
	public void setMCU(int mCU) {
		MCU = mCU;
	}
	public int getMCB() {
		return MCB;
	}
	public void setMCB(int mCB) {
		MCB = mCB;
	}
	public String getLMP() {
		return LMP;
	}
	public void setLMP(String lMP) {
		LMP = lMP;
	}
	public int getP() {
		return P;
	}
	public void setP(int p) {
		P = p;
	}
	public int getG() {
		return G;
	}
	public void setG(int g) {
		G = g;
	}
	public String getA() {
		return A;
	}
	public void setA(String a) {
		A = a;
	}
	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}
	// Getter
    public List<Child> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    // Setter
    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
