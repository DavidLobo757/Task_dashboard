package com.coderscampus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderscampus.domain.Comment;
import com.coderscampus.domain.Task;
import com.coderscampus.domain.User;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
		List<Comment> findAllByUser(Optional<User> user);
		
		List<Comment> findAllByPost(Task task);
		
		void deleteByCommentId(Long commentId);
		
		Comment findByCommentId(Long commentId);
}
