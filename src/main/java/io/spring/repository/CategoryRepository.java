package io.spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.spring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	final String SELECT_ALL = "SELECT c FROM Category c";
	final String SELECT_BY_ID = "SELECT c FROM Category c WHERE c.id =:categoryId";

	@Query(SELECT_ALL)
	List<Category> findAllCategory();
	
	@Query(SELECT_BY_ID)
	Category findCategoryById(@Param("categoryId") Integer id);

}
