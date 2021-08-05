$(document).ready(function () {
    // $('#loginButton').click(function () {
    //     alert("Working")
    //     login();

    // })
    $('#signupButton').click(function () {
        alert('sign-up button')
    })

    const login = async () => {
        let uname = $('#usernameInput').val();
        let pass = $('#passwordInput').val();

        console.log(uname)
        console.log(pass)

        $('#usernameInput').val("");
        $('#passwordInput').val("");


        if (uname.length < 1 || pass.length < 1) {
            alert("Enter the credentials");
            return;
        }
        let uObj = {
            username: uname,
            password: pass,
        };
        let req = await fetch('http://localhost:8080/Project-1/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(uObj),
        });
        if (req.status !== 200) {
            alert("Username or password are incorrect");
            return;
        }
        else {
            let res = await req.json();
            location.href = 'https://www.google.com/';

            // if (res.userRole == 1) {

            //     location.href = './employee.html';
            // } else {
            //     location.href = './manager.html';
            // }
        }
    }
    //Setting the event listener for the login button
    document.getElementById('loginButton').addEventListener('click', login);
   // Setting the event listener for the register redirect button
    //document.getElementById('register-redir').addEventListener('click', (event) => {
    //});
})