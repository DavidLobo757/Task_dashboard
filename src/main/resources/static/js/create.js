var submitButton = document.querySelector("#submitButton")
var usernameTextBox = document.querySelector("#username")
var passwordTextBox = document.querySelector("#password")
var username = document.querySelector("#username")
var password = document.querySelector("#password")
var users = [] 

        
        console.log(` submitBtn is: ${submitButton}`);
        
      
      
        submitButton.addEventListener('click', function () {    
		  var user = {
			"username" : username.value,
			"password" : password.value
					}
	      console.log(username.value + password.value);
          if (username.value =='' || password.value =='') {
            alert("Please enter a username and a password")
            
            window.location.hash="reload"
          } else {
            console.log("Inputs look valid, proceed with form submission")
             
			fetch(`/create`, {
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
        
        
       // Checks if username exists in the text box | remember the textbox automatically
        // creates an id of ${username.username}
        
        
        // USERNAME
        usernameTextBox.addEventListener('blur', () => {
			
			fetch(`/users/validateUsername?username=${username.value}`, {
				method: "GET"
			})
			.then((response)=> {
				return response.json()
			})	
			.then((data)=> {
				console.log(data)
			})
		});
		
		// PASSWORD
        passwordTextBox.addEventListener('blur', () =>{
			
			fetch(`/users/validatePassword?password=${password.value}`, {
				method: "GET"
			})
			.then((response)=> {
				return response.json()
			})
			.then((data) => {
				console.log(data);
			})
			
		});
		// This shit doesn't even exist'
//		submitButton.addEventListener('onmouseover', ()=> {
//			
//          	var user = {
//					"username": username.value,
//					"password": password.value
//				}
//				
////				This is when you want to send information through the 
////				body as json this is the syntax for it
////
////				body: `{
////					"username": "${username.value}",
////					"password": "${password.value}"
////				}`
//			fetch(`/users/exists`, {
//				method: "POST",
//				headers: {
//					"Content-Type": "application/json",
//					'X-CSRF-TOKEN': token
//				},
//				body: JSON.stringify(user)
//			})
//			.then((fetchResponse)=> fetchResponse.json())
//				
//			
//			.then((Response)=>{
//				console.log(Response)
//			})
//			
//		});
        
        
    
    
//      usernameTextBox.addEventListener('focus', () => {
//        console.log("The username textbox now has focus")
//      });
        