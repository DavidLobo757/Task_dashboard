var submitButton = document.querySelector("#submitBtn")
var username = document.querySelector("#username")
var password = document.querySelector("#password")	
var confirmPassword = document.querySelector("#confirmPassword")
var eyeIcons = document.querySelectorAll('.fa-eye')
var user = {
	"username" : username.value,
	"password" : password.value
}
var users = []

// eyecon stuff
	eyeIcons.forEach( (eyeIcon) =>{
	eyeIcon.addEventListener('click', () => {
		if (eyeIcon.classList.contains('fa-eye')) {
			eyeIcon.classList.replace('fa-eye', 'fa-eye-slash')
			console.log(eyeIcon.getAttribute('id'))
			if(eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
				document.querySelector("#password").type = 'text'
			} else {
				document.querySelector("#confirmPassword").type = 'text'
			} 
			
		} else {
			eyeIcon.classList.replace('fa-eye-slash', 'fa-eye')
			console.log(eyeIcon.getAttribute('id'))
			if(eyeIcon.getAttribute('id') === 'passwordEyeIcon') {
				document.querySelector("#password").type = 'password'
			} else {
				document.querySelector("#confirmPassword").type = 'password'
			} 
		}
	})
})


       	 
// Check for username and password
         username.addEventListener('blur', () => {
			fetch(`/users/validateUsername?username=${username.value}`, {
				method: "GET"
			})
	       	.then((response) => response.json())
			.then((data) => {
				console.log(data)
				console.log("Username: " + username.value)
			})
	     })
	     
	     password.addEventListener('blur', () => {
		 	fetch(`/users/validatePassword?password=${password.value}`, {
				method: "GET"
		    })
		    .then(response => response.json())
		    .then((data) => {
				console.log(data)
				console.log("Password: " + password.value)
		})
	})
	   
// Submit button      
        submitButton.addEventListener('click', function () {   
			
		  var user = {
			"username" : username.value.trim(),
			"password" : password.value.trim()
					}
	      console.log(username.value + password.value);
          if (username.value =='' || password.value =='') {
            alert("Please enter a username and a password")
          } else {
            console.log("Inputs look valid, proceed with form submission")
             
			fetch(`/register`, {
				method: "POST",
				headers: {
				  "Content-Type": "application/json",
				  'X-CSRF-TOKEN': token
			},
				body: JSON.stringify(user)
			})
			.then((fetchResponse)=> fetchResponse.json())
			.then((response)=> {
				console.log(response)
			})
          }
          
          users.push(user)
          
        });
        
