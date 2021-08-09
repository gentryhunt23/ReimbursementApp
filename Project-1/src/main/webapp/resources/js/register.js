const register = async () => {
    let firstName = $('#firstName').val();
    let lastName = $('#lastName').val();
    let email = $('#createEmail').val();
    let password = $('#createPassword').val();
    let confirmPassword = $('#confirmPassword').val();
    let pin = $('#adminPin').val();
    console.log(pin)


    const createAdmin = function (pin) {
        if (pin === "460515") {
            return 1
        } else { 
            return 2 
        }

    }
    console.log(createAdmin())


    //console.log(reimId)
    // console.log(status)

    $('#firstName').val("");
    $('#lastName').val("");
    $('#createEmail').val("");
    $('#createPassword').val("");
    $('#confirmPassword').val("");
    $('#adminPin').val("");

    // $('.radio-group').val("");


    // if (reimId.length < 1) {
    //     alert("Enter the reimbursement id");
    //     return;

    let signupObj = {
        firstName,
        lastName,
        email,
        password,
        confirmPassword,
        pin,
        userRole: createAdmin()

    };
   // console.log(userRole)

    let req = await fetch('http://localhost:8080/Project-1/api/user/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(signupObj),
    });
    if (req.status !== 200) {
        alert("An account with this email address already exists");
        return;
    }
    else {
        let data = await req.json();
        alert("You have successfully set up your reimbursement account!")
        location.href = '/Project-1/login';


    }
}
document.getElementById('register').addEventListener('click', register);


