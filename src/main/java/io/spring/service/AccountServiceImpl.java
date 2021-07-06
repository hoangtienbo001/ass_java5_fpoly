package io.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.spring.entities.Account;
import io.spring.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account create(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account update(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		accountRepository.deleteById(id);
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAllAccount();
	}

	@Override
	public Account getById(String id) {
		return accountRepository.findAccountById(Integer.parseInt(id));
	}

	@Override
	public boolean checkLogin(Account account) {
		
		return true;
	}

	@Override
	public Account findByUser(String user, String password) {
		return accountRepository.findAccountByUser(user, password);
	}
}
