package com.coderscampus.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.dto.CommentDto;
import com.coderscampus.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/createComment")
	@ResponseBody
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
