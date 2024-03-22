package entity;

public class Address {
	
	private String houseNo;
	private String streetName;
	private int pinCode;
	
	public Address(String houseNo, String streetName, int pinCode) {
		
		this.houseNo = houseNo;
		this.streetName = streetName;
		this.pinCode = pinCode;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", streetName=" + streetName + ", pinCode=" + pinCode + "]";
	}
	
	
	
	

}
