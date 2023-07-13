package com.mukund.AgileProjectManagementPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mukund.AgileProjectManagementPortal.entity.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long> {

}
