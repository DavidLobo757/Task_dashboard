package com.coderscampus.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.coderscampus.domain.Email;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long>{
	
}
