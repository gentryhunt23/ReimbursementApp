$(document).ready(function () {

    const filterByAuthor = async () => {
        let authorId = $('#author').val();

        console.log(authorId)

        $('#author').val("");


        if (authorId.length < 1) {
            alert("Enter the employee id");
            return;
        }
        let updateObj = {
            authorId,
        };
        let req = await fetch('http://localhost:8080/Project-1/api/users/reimbursements', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updateObj),
        });
        if (req.status !== 200) {
            alert("incorrect employee id number");
            return;
        }
        else {
            let data = await req.json();
            console.log(data)

            for (i = 0; i < data.length; i++) {
                //console.log(data[i]);

                // let _amount = data[i].amount;
                // let _reimId = data[i].reimId;
                // let _username = data[i].username;
                // let _type = data[i].rType.type;
                // let _status = data[i].rStatus.status;
                // let _description = data[i].description;




                $(".reimbsContainer").append(`<table class="table table-hover table-border">
                    <thead>
                        <tr>
    
                            <th scope="col"></th>
                            <th scope="col">Reim. ID</th>
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

            // 		$(".updateSuccess").append(`<div class="alert alert-success" role="alert">
            //   You have successfully updated the selected reimbursement</div>`)
        }
    }
    //=======================================================================================================
    const displayEmployees = async () => {
        let res = await fetch('http://localhost:8080/Project-1/api/users', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            },
        });
        let data = await res.json();
        console.log(data);

       for (i = 0; i < data.length; i++) {
            console.log(data[i]);

            if(data[i].uRole.userRole === "EMPLOYEE"){


            $(".reimbsContainer").append(`<table class="table table-bordered table-dark">
                    <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col">Employee ID</th>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                            <th scope="col">Username</th>
                            <th scope="col">Role</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row"></th>
                            <td>${data[i].userId}</td>
                            <td>${data[i].firstName}</td>
                            <td>${data[i].lastName}</td>
                            <td>${data[i].username}</td>
                            <td>${data[i].uRole.userRole}</td>
                        </tr>
                            <th scope="row"></th>
                    </tbody>
                </table>`)


            }
        }
    }
    //================================================================================================
        displayEmployees();

    document.getElementById('filter').addEventListener('click', filterByAuthor);


})