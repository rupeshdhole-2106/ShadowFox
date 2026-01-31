package com.bank.system.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.system.dto.AccountRequestDTO;
import com.bank.system.model.Account;
import com.bank.system.repository.AccountRepository;
import com.bank.system.service.BankingService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
	@Autowired
	private AccountRepository accountRepository;
	
	private final BankingService service;
	
	@PostMapping
	public ResponseEntity<Account> create(@Valid @RequestBody AccountRequestDTO dto) {
		Account acc = Account.builder().accountNumber(dto.getAccountNumber())
				.accountHolderName(dto.getAccountHolderName()).balance(dto.getBalance()).build();
		
		return new ResponseEntity<>(service.save(acc), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAccount(@PathVariable Long id) {
		if(accountRepository.existsById(id)) {
			accountRepository.deleteById(id);
			return "Account with ID " + id + "deleted successfully!";
		}
		else {
			return "Account not found!";
		}
		
	}
	
	@GetMapping
	public List<Account> getAllAccounts()
	{
		return accountRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable Long id) {
		return accountRepository.findById(id).orElseThrow(() ->
		new RuntimeException("Account not found!"));
	}
	
	@PutMapping("/{id}")
	public Account updateAccount(@PathVariable Long id, @RequestBody Account accountDetails) {
		Account account = accountRepository.findById(id).orElseThrow(() ->
		new RuntimeException("Account not found!"));
		if(accountDetails.getAccountHolderName() != null) {
			account.setAccountHolderName(accountDetails.getAccountHolderName());
		}
		if(accountDetails.getBalance() != null)
		{
		//account.setAccountHolderName(accountDetails.getAccountHolderName());
		account.setBalance(accountDetails.getBalance());
		}
		
		return accountRepository.save(account);
	}
	
	@PutMapping("/{id}/deposit")
	public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Account account = accountRepository.findById(id).orElseThrow(() ->
		new RuntimeException("Account not found"));
		
		Double amount = request.get("amount");
		double currentBalance = (account.getBalance() == null) ? 0.0 : account.getBalance();
		account.setBalance(currentBalance + amount);
		return accountRepository.save(account);
	}
	
	@PutMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
		Account account = accountRepository.findById(id).orElseThrow(() -> 
		new RuntimeException("Account not found"));
		
		Double amount = request.get("amount");
		double currentBalance = (account.getBalance() == null) ? 0.0 : account.getBalance();
		
		if(currentBalance < amount) {
			throw new RuntimeException("Insufficient funds! Current balanceL " + currentBalance);
		}
		account.setBalance(currentBalance - amount);
		return accountRepository.save(account);
	}

}
