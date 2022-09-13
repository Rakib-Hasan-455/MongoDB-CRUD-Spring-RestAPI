const viewUsers = document.getElementById("view-users");
// Get
fetch('http://localhost:8080/api/admin/users')
    .then((response) => response.json())
    .then((data) => {
            for (let i = 0; i < data.length; i++) {
                let innerTr =
                    `<td class="tdId">${data[i].id}</td>
                    <td class="tdEmail">${data[i].email}</td>
                    <td class="tdPass">${data[i].password}</td>
                    <td class="tdRole">${data[i].role}</td>
                    <td class="d-flex gap-3 py-2">
                    <button class="btn btn-outline-info text-black" id="edit">Edit</button>
                    <button class="btn btn-outline-danger" id="delete">Delete</button></td>`;
                const eachRow = document.createElement('tr');
                eachRow.setAttribute("data-id", `${data[i].id}`)
                eachRow.innerHTML = innerTr;
                viewUsers.append(eachRow);
            }
        }
    );

// Basic id select
const addUserBtn = document.getElementById('add-user-btn');
const saveUserBtn = document.getElementById('save-user-btn');
const idField = document.getElementById('id');
const emailField = document.getElementById('email');
const passField = document.getElementById('password');
const roleField = document.getElementById('role');

// Post
addUserBtn.addEventListener('click', (e) => {
    fetch('http://localhost:8080/api/admin/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: idField.value,
            email: emailField.value,
            password: passField.value,
            role: roleField.value
        })
    }).then(response => response.json())
})

// PUT or EDIT via patch
saveUserBtn.addEventListener('click', (e) => {
    // e.preventDefault()
    console.log(idField.value)
    console.log(passField.value)
    console.log(emailField.value+"\n " + roleField.value)
    fetch('http://localhost:8080/api/admin/users', {
        method: 'PUT',
        // mode: 'no-cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: idField.value,
            email: emailField.value,
            password: passField.value,
            role: roleField.value
        })
    }).then(response => response.json())
        .then(() => {
            location.reload();
        })

})


// Edit click/Delete
const tableId = document.getElementById('view-users');
tableId.addEventListener('click', (e) => {
        let id = e.target.parentElement.parentElement.dataset.id;
    //    EDIT Btn On Click
    if (e.target.id === 'edit') {
        let idTd = e.target.parentElement.parentElement.querySelector(".tdId").textContent;
        let emailTd = e.target.parentElement.parentElement.querySelector(".tdEmail").textContent;
        let passTd = e.target.parentElement.parentElement.querySelector(".tdPass").textContent;
        let roleTd = e.target.parentElement.parentElement.querySelector(".tdRole").textContent;
        idField.value = idTd;
        emailField.value = emailTd;
        passField.value = passTd;
        roleField.value = roleTd;
    }
    // Delete
    if (e.target.id === 'delete') {
        fetch(`http://localhost:8080/api/admin/users/${id}`, {
            method: 'DELETE',
        }).then(() => location.reload())
    }
    }
)

// Delete