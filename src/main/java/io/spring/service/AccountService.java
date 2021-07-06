package io.spring.service;

import java.util.List;

import org.springframework.validation.annotation.Validated;

import io.spring.entities.Account;

public interface AccountService {
	Account create(Account account);

	Account update(Account account);

	void delete(Integer id);

	List<Account> getAllAccount();

	Account getById(String id);
	
	Account findByUser(String user, String password);

	boolean checkLogin(@Validated Account account);
}
