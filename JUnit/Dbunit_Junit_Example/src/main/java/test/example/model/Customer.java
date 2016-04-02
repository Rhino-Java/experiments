package test.example.model;

import java.util.Date;

public class Customer {

	private String id;

	private String name;

	private String gender;

	private Date dateOfBirth;

	private String occupation;

	private String city;

	private String mobileNo;

	private String address;

	public Customer(String id, String name, String gender, Date dateOfBirth, String occupation, String city,
			String mobileNo, String address) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.occupation = occupation;
		this.city = city;
		this.mobileNo = mobileNo;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public String getId() {
		return id;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=").append(id).append(", name=").append(name).append(", gender=").append(gender)
				.append(", dateOfBirth=").append(dateOfBirth).append(", occupation=").append(occupation)
				.append(", city=").append(city).append(", mobileNo=").append(mobileNo).append(", address=")
				.append(address).append("]");
		return builder.toString();
	}

}
