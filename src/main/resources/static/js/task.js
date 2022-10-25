

var commentBox = document.getElementById("commentBox")
console.log(commentBox)

window.onload = function() {
	commentBox.focus();
};

commentBox.addEventListener("keypress",submitComment);

function submitComment(event) {
	if(event.keyCode === 13) {
		let comment = {
		commentDetails: commentBox.value,
		userId: userId,
		taskId: taskId,
	}
	console.log(comment)
	
	console.log("Submitting comment")
	
	
	fetch(`/createComment`, {
		method: "POST",
		headers: {
			'Content-Type': "application/JSON",
			'X-CSRF-TOKEN': token, 
		},
		body: JSON.stringify(comment)
	}).then(response => response.json())
	  .then((data)=>console.log(JSON.stringify(data)))
	}
	
}

