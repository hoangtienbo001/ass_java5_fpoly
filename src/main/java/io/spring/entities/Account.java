package io.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;

@Entity
@Table(name = "account")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	

	@NotBlank(message = "Vui lòng nhập tên tài khoản")
	@Length(min = 3, max = 100, message = "độ dài tài khoản từ 6 đến 100 kí tự")
	private String username;
	
	
	@NotBlank(message = "Vui lòng nhập mật khẩu")
	@Length(min = 2, max = 18, message = "độ dài mật khẩu từ 2 đến 18 kí tự")
	private String password;
	
	private Integer role;
	
	private Integer active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Account [idAccount=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", active=" + active + "]";
	}
}
