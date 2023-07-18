package com.mukund.AgileProjectManagementPortal.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Clients {
	
	/**
	 * @param id
	 * @param name
	 * @param pOC_FullName
	 * @param pOC_PhoneNumber
	 * @param pOC_EmailAddress
	 */
	public Clients(long id, String name, String pOC_FullName, long pOC_PhoneNumber, String pOC_EmailAddress) {
		super();
		this.id = id;
		this.name = name;
		this.pOC_FullName = pOC_FullName;
		this.pOC_PhoneNumber = pOC_PhoneNumber;
		this.pOC_EmailAddress = pOC_EmailAddress;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Column(name="Name")
	private String name;
	
	@NotNull
	@Column(name="POC_FullName")
	private String pOC_FullName;
	
	@NotNull
	@Column(name="POC_PhoneNumber")
	private long pOC_PhoneNumber;
	
	@NotNull
	@Column(name="POC_EmailAddress")
	private String pOC_EmailAddress;
	
	@NotNull
	@OneToMany(mappedBy="clients")
	private List<Projects> projects;
	
}
