

const toggleCreateButton = document.querySelector('#createNewTask');

const hiddens = document.querySelectorAll('.secret');



hiddens.forEach((hidden) =>{
	toggleCreateButton.addEventListener('click', () => {
		if(hidden.style.display === 'none') {
			hidden.style.display = 'block';
			toggleCreateButton.innerText="Hide";
		} else {
			hidden.style.display = 'none';
			toggleCreateButton.innerText="Create new task";
		}
	});
});

