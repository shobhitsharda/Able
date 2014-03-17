package able.dbclass;

public class TbStandardInfoDb {
	int std_id;
	String std_title;
	String std_postdate;
	String std_content;
	String std_type;
	
	int flag;
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getStd_title() {
		return std_title;
	}
	public void setStd_title(String std_title) {
		this.std_title = std_title;
	}
	public String getStd_postdate() {
		return std_postdate;
	}
	public void setStd_postdate(String std_postdate) {
		this.std_postdate = std_postdate;
	}
	public String getStd_content() {
		return std_content;
	}
	public void setStd_content(String std_content) {
		this.std_content = std_content;
	}
	public String getStd_type() {
		return std_type;
	}
	public void setStd_type(String std_type) {
		this.std_type = std_type;
	}
}
