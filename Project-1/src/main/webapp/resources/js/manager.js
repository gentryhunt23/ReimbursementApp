const viewReim = async () => {
	let res = await fetch('http://localhost:8080/Project-1/api/manager/view-reimbursements', {
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




		$(".reimbsContainer").append(`<table class="table table-bordered table-dark">
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
//=======================================================================================================================
const viewPending = async () => {
	let res = await fetch('http://localhost:8080/Project-1/api/manager/view/pending', {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		},
	});
	let data = await res.json();	
	console.log(data)
		//switch statement to change color of reimbursements based on status
		for (i = 0; i < data.length; i++) {
			//console.log(data[i]);

			// let _amount = data[i].amount;
			// let _reimId = data[i].reimId;
			// let _username = data[i].username;
			// let _type = data[i].rType.type;
			// let _status = data[i].rStatus.status;
			// let _description = data[i].description;




			$(".reimbsContainer").append(`<table class="table table-bordered table">
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
//=======================================================================================================================

const updateReimbs = async () => {
	let reimId = $('#reimId').val();
	let status = $("input[name='radio']:checked").val();


	console.log(reimId)
	console.log(status)

	$('#reimId').val("");

	//$('.radio-group: checked').val("");


	if (reimId.length < 1) {
		alert("Enter the reimbursement id");
		return;
	}
	let updateObj = {
		reimId,
		status
	};
	let req = await fetch('http://localhost:8080/Project-1/api/manager/resolve', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(updateObj),
	});
	if (req.status !== 200) {
		alert("incorrect reimbursement number");
		return;
	}
	else {
		let data = await req.json();
		console.log(data)

		$(".updateSuccess").append(`<div class="alert alert-success" role="alert">
  You have successfully updated the selected reimbursement</div>`)
}

	}

//=======================================================================================================================
const viewResolved = async () => {
	let res = await fetch('http://localhost:8080/Project-1/api/manager/view-resolved', {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		},
	});
	let data = await res.json();
	
	console.log(data)
		//switch statement to change color of reimbursements based on status
		for (i = 0; i < data.length; i++) {
			//console.log(data[i]);

			// let _amount = data[i].amount;
			// let _reimId = data[i].reimId;
			// let _username = data[i].username;
			// let _type = data[i].rType.type;
			// let _status = data[i].rStatus.status;
			// let _description = data[i].description;




			$(".reimbsContainer").append(`<table class="table table-bordered table-dark">
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

document.getElementById('resolve').addEventListener('click', updateReimbs);

document.getElementById('viewUserReimbursements').addEventListener('click', viewReim);

document.getElementById('resolveReimbursements').addEventListener('click', viewPending);
document.getElementById('viewResolvedReimbursements').addEventListener('click', viewResolved);




