package com.project.hrmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "HR_EMPLOYEE_ADDRESS")
public class EmployeeAddress {

	@Id
	@Column(name = "trainee_id", unique = true, nullable = false)
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	private Integer addressId;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipcode;

	@OneToOne
	@JsonIgnore // stops erroneous iterations
	@PrimaryKeyJoinColumn
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeAddress() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeAddress(Employee employee) {
		super();
		this.employee = employee;
	}

	public EmployeeAddress(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Column(name = "ADDRESS_STREET", nullable = false)
	public String getStreet() {
		return this.street;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "ADDRESS_CITY", nullable = false)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "ADDRESS_STATE", nullable = false)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "ADDRESS_ZIPCODE", nullable = false)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
