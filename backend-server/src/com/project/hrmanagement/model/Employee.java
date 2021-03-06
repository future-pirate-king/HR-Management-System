package com.project.hrmanagement.model;

import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "HR_EMPLOYEE")
public class Employee {

	/**
	 * 
	 */

	@Id
	@Column(name = "emp_id")
	@SequenceGenerator(name = "id", initialValue = 0000, allocationSize = 1000)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
	private Integer empId;

	@JsonIgnore
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private LoginCredential loginCredential;

	/*
	 * @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "emp_id")
	 * 
	 * @OrderColumn(name = "type") private Set<Complaints> complaints;
	 */

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email")
	private String email;

	@Column(name = "cadre")
	private String cadre;

	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Column(name = "dept_name")
	private String deptName;

	@Column(name = "birth_date")
	private Date bdate;

	@Column(name = "gender")
	private String gender;

	@Column(name = "marital_status")
	private String maritalStatus;

	@Column(name = "reporting_to")
	private String reportingTo;

	@Column(name = "type")
	private String type;
	@Column(name = "last_login")
	private Date lastLogin;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private EmployeeAddress employeeAddress;

	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public Set<Complaints> getComplaints() { return complaints; }
	 * 
	 * 
	 * 
	 * public void setComplaints(Set<Complaints> complaints) { this.complaints =
	 * complaints; }
	 */

	public Employee(String firstName, String middleName, String lastName, String bloodGroup, String mobileNo,
			String email, String cadre, Date dateOfJoining, String deptName, Date bdate, String gender,
			String maritalStatus, String reportingTo) {
		super();

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.bloodGroup = bloodGroup;
		this.mobileNo = mobileNo;
		this.email = email;
		this.cadre = cadre;
		this.dateOfJoining = dateOfJoining;
		this.deptName = deptName;
		this.bdate = bdate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.reportingTo = reportingTo;
	}

	public Employee(String firstName, String middleName, String lastName, String bloodGroup, String mobileNo,
			String email, String cadre, Date dateOfJoining, String deptName, Date bdate, String gender,
			String maritalStatus, String reportingTo, EmployeeAddress employeeAddress) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.bloodGroup = bloodGroup;
		this.mobileNo = mobileNo;
		this.email = email;
		this.cadre = cadre;
		this.dateOfJoining = dateOfJoining;
		this.deptName = deptName;
		this.bdate = bdate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.reportingTo = reportingTo;
		this.employeeAddress = employeeAddress;
	}

	
	public Employee(LoginCredential loginCredential, String firstName, String middleName, String lastName,
			String bloodGroup, String mobileNo, String email, String cadre, Date dateOfJoining, String deptName,
			Date bdate, String gender, String maritalStatus, String reportingTo, String type, Date lastLogin,
			EmployeeAddress employeeAddress) {
		super();
		this.loginCredential = loginCredential;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.bloodGroup = bloodGroup;
		this.mobileNo = mobileNo;
		this.email = email;
		this.cadre = cadre;
		this.dateOfJoining = dateOfJoining;
		this.deptName = deptName;
		this.bdate = bdate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.reportingTo = reportingTo;
		this.type = type;
		this.lastLogin = lastLogin;
		this.employeeAddress = employeeAddress;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public LoginCredential getLoginCredential() {
		return loginCredential;
	}

	public void setLoginCredential(LoginCredential loginCredential) {
		this.loginCredential = loginCredential;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCadre() {
		return cadre;
	}

	public void setCadre(String cadre) {
		this.cadre = cadre;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", loginCredential=" + loginCredential + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", bloodGroup=" + bloodGroup + ", mobileNo="
				+ mobileNo + ", email=" + email + ", cadre=" + cadre + ", dateOfJoining=" + dateOfJoining
				+ ", deptName=" + deptName + ", bdate=" + bdate + ", gender=" + gender + ", maritalStatus="
				+ maritalStatus + ", reportingTo=" + reportingTo + "]";
	}

}
