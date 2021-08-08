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

document.getElementById('viewUserReimbursements').addEventListener('click', viewReim);
