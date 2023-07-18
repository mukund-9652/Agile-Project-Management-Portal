package com.mukund.AgileProjectManagementPortal.model;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class ClientsDTO {

	/**
	 * @param id
	 * @param name
	 * @param pOC_FullName
	 * @param pOC_PhoneNumber
	 * @param pOC_EmailAddress
	 */
	public ClientsDTO() {
	}

	public ClientsDTO(long id, 
			String name, 
			String pOC_FullName, 
			long pOC_PhoneNumber, 
			String pOC_EmailAddress) {
		super();
		this.id = id;
		this.name = name;
		this.pOC_FullName = pOC_FullName;
		this.pOC_PhoneNumber = pOC_PhoneNumber;
		this.pOC_EmailAddress = pOC_EmailAddress;
	}

	private long id;
	
	@Size(min = 5, message = "Client Name must have more than 5 symbols")
	private String name;
	
	@Size(min = 5, message = "POC_FullName must have more than 5 symbols")
	private String pOC_FullName;
	
    @Range(min = 1000000000L, max = 9999999999L, message = "Poc Phone Number is invalid. It must be 10 Digits")
	private long pOC_PhoneNumber;
	
	@Email
	private String pOC_EmailAddress;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the pOC_FullName
	 */
	public String getPOC_FullName() {
		return pOC_FullName;
	}

	/**
	 * @return the pOC_PhoneNumber
	 */
	public long getPOC_PhoneNumber() {
		return pOC_PhoneNumber;
	}

	/**
	 * @return the pOC_EmailAddress
	 */
	public String getPOC_EmailAddress() {
		return pOC_EmailAddress;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param pOC_FullName the pOC_FullName to set
	 */
	public void setPOC_FullName(String pOC_FullName) {
		this.pOC_FullName = pOC_FullName;
	}

	/**
	 * @param pOC_PhoneNumber the pOC_PhoneNumber to set
	 */
	public void setPOC_PhoneNumber(long pOC_PhoneNumber) {
		this.pOC_PhoneNumber = pOC_PhoneNumber;
	}

	/**
	 * @param pOC_EmailAddress the pOC_EmailAddress to set
	 */
	public void setPOC_EmailAddress(String pOC_EmailAddress) {
		this.pOC_EmailAddress = pOC_EmailAddress;
	}

	@Override
	public String toString() {
		return "ClientsDTO [id=" + id + ", name=" + name + ", pOC_FullName=" + pOC_FullName + ", pOC_PhoneNumber="
				+ pOC_PhoneNumber + ", pOC_EmailAddress=" + pOC_EmailAddress + "]";
	}

}
