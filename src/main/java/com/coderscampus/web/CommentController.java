package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.dto.CommentDto;
import com.coderscampus.service.CommentService;

@RestController
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/createComment")
	public String createComment(@RequestBody CommentDto comment) {
		commentService.createComment(comment);
		
		return "redirect:@{/task/{taskId}(taskId=comment.taskId)}";
	}
	
	@PostMapping("/post/{postId}/comment/{commentId}/delete")
	public String deletePost(@PathVariable Long commentId, @PathVariable Long taskId) {
		String redirectUrl = "/task/" + taskId;
		commentService.deleteById(commentId);
		
		return "redirect:" + redirectUrl;
	}
	
}
