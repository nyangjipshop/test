package kr.co.dong.board;

public class BoardDTO {
	
	private int b_p_bno;
	private String b_p_category;
	private String b_title;
	private String b_content;
	private String u_p_id;
	private String b_date;
	private int b_v_cnt;
	private int b_state;
	
	public int getB_p_bno() {
		return b_p_bno;
	}
	public void setB_p_bno(int b_p_bno) {
		this.b_p_bno = b_p_bno;
	}
	public String getB_p_category() {
		return b_p_category;
	}
	public void setB_p_category(String b_p_category) {
		this.b_p_category = b_p_category;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getU_p_id() {
		return u_p_id;
	}
	public void setU_p_id(String u_p_id) {
		this.u_p_id = u_p_id;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_v_cnt() {
		return b_v_cnt;
	}
	public void setB_v_cnt(int b_v_cnt) {
		this.b_v_cnt = b_v_cnt;
	}
	public int getB_state() {
		return b_state;
	}
	public void setB_state(int b_state) {
		this.b_state = b_state;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [b_p_bno=" + b_p_bno + ", b_p_category=" + b_p_category + ", b_title=" + b_title
				+ ", b_content=" + b_content + ", u_p_id=" + u_p_id + ", b_date=" + b_date + ", b_v_cnt=" + b_v_cnt
				+ ", b_state=" + b_state + "]";
	}
	
	
	
}
