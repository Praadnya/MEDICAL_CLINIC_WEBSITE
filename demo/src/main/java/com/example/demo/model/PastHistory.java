package com.example.demo.model;

public class PastHistory {
    private boolean DM;
    private boolean HTN;
    private boolean THY;
    private boolean DL;
    private boolean IHD;
    private boolean CA;
    private boolean BA;
    private boolean TB;
    private String Other;
	public boolean isDM() {
		return DM;
	}
	public void setDM(boolean dM) {
		DM = dM;
	}
	public boolean isHTN() {
		return HTN;
	}
	public void setHTN(boolean hTN) {
		HTN = hTN;
	}
	public boolean isTHY() {
		return THY;
	}
	public void setTHY(boolean tHY) {
		THY = tHY;
	}
	public boolean isDL() {
		return DL;
	}
	public void setDL(boolean dL) {
		DL = dL;
	}
	public boolean isIHD() {
		return IHD;
	}
	public void setIHD(boolean iHD) {
		IHD = iHD;
	}
	public boolean isCA() {
		return CA;
	}
	public void setCA(boolean cA) {
		CA = cA;
	}
	public boolean isBA() {
		return BA;
	}
	public void setBA(boolean bA) {
		BA = bA;
	}
	public boolean isTB() {
		return TB;
	}
	public void setTB(boolean tB) {
		TB = tB;
	}
	public String getOther() {
		return Other;
	}
	public void setOther(String other) {
		Other = other;
	}
}

