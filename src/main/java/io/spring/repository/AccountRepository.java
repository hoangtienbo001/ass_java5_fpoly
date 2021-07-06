package io.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.spring.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
	final String SELECT_ALL = "SELECT a FROM Account a";
	final String SELECT_BY_ID = "SELECT a FROM Account a WHERE a.id =:accountId";
	final String SELECT_BY_USER = "SELECT a FROM Account a WHERE a.username =:accountUSER and a.password =:accountPass";

	@Query(SELECT_ALL)
	List<Account> findAllAccount();

	@Query(SELECT_BY_ID)
	Account findAccountById(@Param("accountId") Integer id);
	
	@Query(SELECT_BY_USER)
	Account findAccountByUser(@Param("accountUSER") String username, @Param("accountPass") String password);

	

}
