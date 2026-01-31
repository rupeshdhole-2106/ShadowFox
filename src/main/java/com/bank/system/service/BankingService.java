package com.bank.system.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.system.model.Account;
import com.bank.system.model.TransactionAudit;
import com.bank.system.repository.AccountRepository;
import com.bank.system.repository.AuditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankingService {
	
	private final AccountRepository accountRepo;
	private final AuditRepository auditRepo;
	
	public Account save(Account acc) {
		return accountRepo.save(acc);
	}
	
	@Transactional
	public void transferFunds(String from, String to, Double amount) {
		Account sender = accountRepo.findByAccountNumber(from)
				.orElseThrow(() -> 
				new RuntimeException("Sender not found"));
		Account receiver = accountRepo.findByAccountNumber(to)
				.orElseThrow(() ->
		new RuntimeException("Receiver not found"));
	
	if(sender.getBalance() < amount) {
		throw new RuntimeException("Insufficient Funds");
	}
	sender.setBalance(sender.getBalance() - amount);
	receiver.setBalance(receiver.getBalance() + amount);
	
	accountRepo.save(sender);
	accountRepo.save(receiver);
	
	auditRepo.save(TransactionAudit.builder()
			.accountNumber(from)
			.changeAmount(-amount).finalBalance(sender.getBalance())
					.timestamp(LocalDateTime.now())
					.build());
	
	auditRepo.save(TransactionAudit.builder()
			.accountNumber(to).changeAmount(amount).finalBalance(receiver.getBalance())
					.timestamp(LocalDateTime.now()).build());
	
}

}
