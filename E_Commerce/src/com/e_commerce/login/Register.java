package com.e_commerce.login;

public class Register {

	private String first_Name;
	private String last_Name;
	private String email_Id;
	private String password;

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Register [first_Name=" + first_Name + ", last_Name=" + last_Name + ", email_Id=" + email_Id
				+ ", password=" + password + "]";
	}

}
