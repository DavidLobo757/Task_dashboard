



const toggleEditButton = document.querySelector('#toggleEditButton');

const hiddens = document.querySelectorAll('.secret');



hiddens.forEach((hidden) =>{
	toggleEditButton.addEventListener('click', () => {
		if(hidden.style.display === 'none') {
			hidden.style.display = 'inline';
			toggleEditButton.innerText="Hide";
		} else {
			hidden.style.display = 'none';
			toggleEditButton.innerText="Edit";
		}
	});
});





















//var updateTaskButton = document.querySelector("updateTaskButton")
//
//
//updateTaskButton.addEventListener('click', clicked);
//
//
//function clicked() {
//	document.getElementById('inputTaskDescriptionEdit').style.display='block';
//}




//var commentBox = document.getElementById("commentBox")
//console.log(commentBox)
//
//window.onload = function() {
//	commentBox.focus();
//};
//
//commentBox.addEventListener("keypress",submitComment);
//
//function submitComment(event) {
//	if(event.keyCode === 13) {
//		let comment = {
//		commentDetails: commentBox.value,
//		userId: userId,
//		taskId: taskId,
//	}
//	console.log(comment)
//	
//	console.log("Submitting comment")
//	
//	
//	fetch(`/createComment`, {
//		method: "POST",
//		headers: {
//			'Content-Type': "application/JSON",
//			'X-CSRF-TOKEN': token, 
//		},
//		body: JSON.stringify(comment)
//	}).then(response => response.json())
//	  .then((data)=>console.log(JSON.stringify(data)))
//	}
//	
//}
//
//