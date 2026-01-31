package com.bank.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.system.model.TransactionAudit;

public interface AuditRepository extends JpaRepository<TransactionAudit, Long> {
	

}
