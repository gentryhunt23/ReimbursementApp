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
       
    }
}

//========================================================================================================================




    // Setting the event listener for the register redirect button
    //document.getElementById('register-redir').addEventListener('click', (event) => {
    //});

//})