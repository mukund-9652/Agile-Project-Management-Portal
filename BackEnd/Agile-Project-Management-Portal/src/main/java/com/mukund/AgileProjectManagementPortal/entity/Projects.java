package com.mukund.AgileProjectManagementPortal.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Projects {
	
	/**
	 * @param projectCode
	 * @param title
	 * @param budget
	 * @param startDate
	 * @param expectedDate
	 * @param createdOn
	 * @param status
	 * @param clients
	 */
	public Projects(long projectCode, String title, long budget, LocalDate startDate, LocalDate expectedEndDate,
			LocalDate createdOn, String status, Clients clients) {
		super();
		this.projectCode = projectCode;
		this.title = title;
		this.budget = budget;
		this.startDate = startDate;
		this.expectedEndDate = expectedEndDate;
		this.createdOn = createdOn;
		this.status = status;
		this.clients = clients;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long projectCode;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Budget")
	private long budget;
	
	@Column(name="StartDate")
	private LocalDate startDate;
	
	@Column(name="ExpectedEndDate")
	private LocalDate expectedEndDate;
	
	@Column(name="CreatedOn")
	private LocalDate createdOn;
	
	@Column(name="Status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="ClientId")
	private Clients clients;
	
	@OneToMany(mappedBy="projects")
	private List<Resources> resources;
	
	
	
}
