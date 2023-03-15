package kr.co.dong.board;

public class CodeDTO {

	private String codeNm;
	private int codeNum;
	private String codeString;
	public String getCodeNm() {
		return codeNm;
	}
	public void setCodeNm(String codeNm) {
		this.codeNm = codeNm;
	}
	public int getCodeNum() {
		return codeNum;
	}
	public void setCodeNum(int codeNum) {
		this.codeNum = codeNum;
	}
	public String getCodeString() {
		return codeString;
	}
	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}
	@Override
	public String toString() {
		return "codeDTO [codeNm=" + codeNm + ", codeNum=" + codeNum + ", codeString=" + codeString + "]";
	}
	
	
	
	
}
