package com.coderme.bean;

import com.coderme.core.annotation.MyColumn;
import com.coderme.core.annotation.MyTable;

/**
 * 联系人 实体
 * <pre>
 * @author zhangtengfei
 *
 *
 * 创建日期: 2014-5-29
 * 修改人 :  
 * 修改说明: 
 * 评审人 ：
 * </pre>
 */
@MyTable(name = "T_CONTACT")
public class Contact {
	
	@MyColumn(name="ID")
    private Long id;
	
	@MyColumn(name="mobile_number")
	private String mobileNumber;
	
	@MyColumn(name="contact_name")
	private String name;
	
	@MyColumn(name="TELEPHONE_NUMBER")
	private String telephoneNumber;
	
	@MyColumn(name="user_group")
	private String group;
	
	@MyColumn(name="email")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
