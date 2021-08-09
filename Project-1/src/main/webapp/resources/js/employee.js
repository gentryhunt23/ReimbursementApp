$(document).ready(function () {


    const createReim = async () => {
        let empId = $('#employeeId').val();
        let rAmount = $('#amountInput').val();
        let rDesc = $('#descriptionInput').val();

        let type = $("input[name='radio']:checked").val();
    


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
            $(".alert").append(`<div class="alert alert-success" role="alert">
        You have successfully created a new reimbursement request</div>`)
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

            // let _amount = data[i].amount;
            // let _reimId = data[i].reimId;
            // let _username = data[i].username;
            // let _type = data[i].rType.type;
            // let _status = data[i].rStatus.status;
            // let _description = data[i].description;

            $(".reimbsContainer").append(`<table class="table table-dark table-striped">
                <thead>
                    <tr>

                        <th scope="col"></th>
                        <th scope="col">ID</th>
                        <th scope="col">Type</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Description</th>
                        <th scope="col">Status</th>
                        <th scope="col">Username</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row"></th>
                        <td>${data[i].reimId}</td>
                        <td>${data[i].rType.type}</td>
                        <td>${data[i].amount}</td>
                        <td>${data[i].description}</td>
                        <td>${data[i].rStatus.status}</td>
                        <td>${data[i].rAuthor.username}</td>

                    </tr>
                    
                        <th scope="row"></th>
                        <td colspan="2"></td>
                        <td></td>
                </tbody>
            </table>`)



        }

    }
    //Setting the event listener for the login button

    document.getElementById('createReimbursements').addEventListener('click', createReim);
    document.getElementById('viewReimbursements').addEventListener('click', viewReim);

    // Setting the event listener for the register redirect button
    //document.getElementById('register-redir').addEventListener('click', (event) => {
    //});

})