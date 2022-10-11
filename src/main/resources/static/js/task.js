

var commentBox = documnet.getElementById("commenbtBox")
console.log(commentBox)

window.onload = function() {
	commentBox.focus();
};

commentBox.addEventListener("onclick", submitTask);

function submitTask() {
	let comment = {
		commentDetails: commentBox.value,
		userId: userId,
		postId,
	}
	
	console.log(comment)
	commentBox.value = ""
	console.log("Submitting comment")
	
	
	fetch(`/createComment`, {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
			'X-CSRF-TOKEN': token, 
		},
		body: JSON.stringify(comment)
	}).then(response => response.json).then(() => {
		window.location.reload();
	})
	
	return false;
}