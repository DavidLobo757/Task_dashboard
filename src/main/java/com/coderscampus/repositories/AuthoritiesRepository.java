package com.coderscampus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.coderscampus.domain.Authorities;

@Service
public interface AuthoritiesRepository extends JpaRepository<Authorities, Long>{
	
	
}
