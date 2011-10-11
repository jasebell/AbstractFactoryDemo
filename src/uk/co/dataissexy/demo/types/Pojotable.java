package uk.co.dataissexy.demo.types;

public class Pojotable {
	private int id = 0;
	private String pid = "";
	private String firstname = "";
	private String lastname = "";
	private long deleteflag = 0;
	
	// And the rest of your table entries would go here.
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public long getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(long deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	
}
