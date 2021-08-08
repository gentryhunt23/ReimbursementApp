const viewReim = async () => {
    alert("here");
    let res = await fetch('http://localhost:8080/Project-1/api/manager/view-reimbursements', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    });
    let data = await res.json();
    console.log(data);
}
//=======================================================================================================================
const viewPending = async () => {
    let res = await fetch('http://localhost:8080/Project-1/api/manager/view-pending', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    });
    let data = await res.json();
    console.log(data);
    //=======================================================================================================================
}
const updateReimbs = async () => {
    let reimId = $('#reimId').val();
    let status = $('.radio-group').val();

    console.log(reimId)
    console.log(status)

    $('#reimId').val("");
   // $('.radio-group').val("");


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
        let res = await req.json();
        console.log(res)

    }
}
//Setting the event listener for the login button

document.getElementById('resolve').addEventListener('click', updateReimbs);
document.getElementById('viewUserReimbursements').addEventListener('click', viewReim);
document.getElementById('resolveReimbursements').addEventListener('click', viewPending);

