//$(document).ready(function () {


const createReim = async () => {
    let empId = $('#employeeId').val();
    let rAmount = $('#amountInput').val();
    let rDesc = $('#descriptionInput').val();
    let type = parseInt($('.radio-group').val())

    console.log(rAmount)
    console.log(rDesc)
    console.log(type)

    $('#employeeId').val("");
    $('#amountInput').val("");
    $('#descriptionInput').val("");
    $('#employeeId').val("");

    //$(".radio-group").selected === false;


    if (rAmount.length < 1 || rDesc.length < 1) {
        alert("Enter the reimbursement information");
        return;
    }
    let rObj = {
        amount: rAmount,
        description: rDesc,
        typeId: type,
        userId: empId
    };
    let req = await fetch('http://localhost:8080/Project-1/api/employee/create', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(rObj),
    });
    if (req.status !== 200) {
        alert("Reimbursement not valid");
        return;
    }
    else {
        let res = await req.json();
        console.log(res)
        // if (res.userRole === 1) {
        //     alert("HERE");

        //     location.href = 'resources/employee';
        // } else {
        //     location.href = 'resources/manager';
        // }
    }
}

//========================================================================================================================


const viewReim = async () => {
    let res = await fetch('http://localhost:8080/Project-1/api/employee/view-reimbursements', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    });
    let data = await res.json();
    console.log(data);
    for (i = 0; i < data.length; i++) {
        //console.log(data[i]);
        let _amount = data[i].amount;
        let _reimId = data[i].reimId;
        let _username = data[i].username;
        let _type = data[i].rType.type;
        let _status = data[i].rStatus.status;
        let _description = data[i].description;

        

    }

}
//Setting the event listener for the login button

document.getElementById('createReimbursements').addEventListener('click', createReim);
document.getElementById('viewReimbursements').addEventListener('click', viewReim);

    // Setting the event listener for the register redirect button
    //document.getElementById('register-redir').addEventListener('click', (event) => {
    //});

//})