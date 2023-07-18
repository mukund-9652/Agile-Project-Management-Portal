package com.mukund.AgileProjectManagementPortal.model;

import java.time.LocalDate;

public class ProjectsDTO {

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
	public ProjectsDTO() {
	}

	public ProjectsDTO(long projectCode, String title, long budget, LocalDate startDate, LocalDate expectedDate,
			LocalDate createdOn, String status, ClientsDTO clientsDTO) {
		super();
		this.projectCode = projectCode;
		this.title = title;
		this.budget = budget;
		this.startDate = startDate;
		this.expectedDate = expectedDate;
		this.createdOn = createdOn;
		this.status = status;
		this.clients = clientsDTO;
	}

	private long projectCode;
	private String title;
	private long budget;
	private LocalDate startDate;
	private LocalDate expectedDate;
	private LocalDate createdOn;
	private String status;
	private ClientsDTO clients;

	/**
	 * @return the projectCode
	 */
	public long getProjectCode() {
		return projectCode;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the budget
	 */
	public long getBudget() {
		return budget;
	}

	/**
	 * @return the startDate
	 */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
	 * @return the expectedDate
	 */
	public LocalDate getExpectedDate() {
		return expectedDate;
	}

	/**
	 * @return the createdOn
	 */
	public LocalDate getCreatedOn() {
		return createdOn;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @return the clients
	 */
	public ClientsDTO getClients() {
		return clients;
	}

	/**
	 * @param projectCode the projectCode to set
	 */
	public void setProjectCode(long projectCode) {
		this.projectCode = projectCode;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param budget the budget to set
	 */
	public void setBudget(long budget) {
		this.budget = budget;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param expectedDate the expectedDate to set
	 */
	public void setExpectedDate(LocalDate expectedDate) {
		this.expectedDate = expectedDate;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(ClientsDTO clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "ProjectsDTO [projectCode=" + projectCode + ", title=" + title + ", budget=" + budget + ", startDate="
				+ startDate + ", expectedDate=" + expectedDate + ", createdOn=" + createdOn + ", status=" + status
				+ ", clients=" + clients + "]";
	}
}
