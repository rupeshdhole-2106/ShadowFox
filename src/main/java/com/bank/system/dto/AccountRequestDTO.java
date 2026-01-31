package com.bank.system.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {
	
	@NotBlank(message = "Account Holder's Name is required")
	private String accountHolderName;
	
	@NotBlank(message = "Account number is required")
	private String accountNumber;
	
	@Min(value = 0, message = "Initial balance cannot be negative.")
	@JsonProperty("balance")
	private Double Balance;

}
