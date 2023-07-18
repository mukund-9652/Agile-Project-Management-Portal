package com.mukund.AgileProjectManagementPortal.model;

import jakarta.validation.constraints.Pattern;

public class ResourcesDTO {

	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param role
	 * @param projects
	 */
	public ResourcesDTO() {

	}

	public ResourcesDTO(String userId, String firstName, String lastName, String email, long phoneNumber, String role,
			ProjectsDTO projects) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.projects = projects;
	}

	private String userId;
	private String firstName;
	private String lastName;
	
    @Pattern(regexp = ".+@gmail\\.com", message = "Email address should end with gmail.com")
	private String email;
	private long phoneNumber;
	private String role;
	private ProjectsDTO projects;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the phoneNumber
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @return the projects
	 */
	public ProjectsDTO getProjects() {
		return projects;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = generateUserId(userId);
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @param projects the projects to set
	 */
	public void setProjects(ProjectsDTO projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "ResourcesDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", role=" + role + ", projects=" + projects + "]";
	}
	
	private String generateUserId(String lastName) {
        // Extract the first two letters of the lastName
        String initials = lastName.substring(0, 2).toUpperCase();
        
        // Generate a random 4-digit number
        int randomNumber = (int) (Math.random() * 9000) + 1000;
        
        // Concatenate the initials and the random number to form the UserId
        return initials + randomNumber;
    }
}
