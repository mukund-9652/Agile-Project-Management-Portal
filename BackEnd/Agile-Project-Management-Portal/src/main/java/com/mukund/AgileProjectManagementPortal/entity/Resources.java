package com.mukund.AgileProjectManagementPortal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Resources {

	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param role
	 * @param projects
	 */
	public Resources(String userId, String firstName, String lastName, String email, long phoneNumber, String role,
			Projects projects) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.projects = projects;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "Email")
	private String email;

	@Column(name = "PhoneNumber")
	private long phoneNumber;

	@Column(name = "Role")
	private String role;

	@ManyToOne
	@JoinColumn(name="ProjectCode")
	private Projects projects;

}
