package com.coderscampus.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	@Query("select u from User u" 
			+ " left join fetch u.authorities"
			+ " where u.username = :username")
	User findByUsernameWithAuthorities(String username);
	
	@Query("select u from User u"
			+ " left join fetch u.email"
			+ " where u.id = :id"
			)
	Optional<User> findUserIdWithEmail(Long id);
	
//	@Query("select u from User u"
//			+ " left join fetch u.email"
//			+ " left join fetch "
//			)
//	
	// This automatically does select * from user and does u.username = :username
	@Query("select u from User u" 
			+ " left join fetch u.authorities"
			+ " where u.username = :username")
	User findByUsername(String username);

	@Query("select u from User u"
			)
	User findUserId(Long id);
}
