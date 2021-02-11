var users = [];
var adminUserService = new AdminUserServiceClient()
var $userName
var $password
var $firstName
var $lastName
var $role
var $createBtn
var $updateBtn
var $searchBtn

var theTableBody

function createUser(user){
    adminUserService.createUser(user)
        .then(function (actualUser){
            users.push(actualUser)
            renderUsers(users)
        })
}

function deleteUser(event){
    console.log(event.target)
    var deleteBtn = jQuery(event.target)
    var theIndex = deleteBtn.attr("id")
    var theClass =deleteBtn.attr("class")
    var theId = users[theIndex]._id
    console.log(theIndex)
    console.log(theClass)
    adminUserService.deleteUser(theId)
        .then(function (status){
            users.splice(theIndex,1)
            renderUsers(users)
        })
}
var selectedUser = null
function selectUser(event) {
    var editBtn = jQuery(event.target)
    var theId = editBtn.attr("id")
    console.log(theId)
    selectedUser = users.find(user => user._id === theId)
    $userName.val(selectedUser.Username)
    $password.val(selectedUser.Password)
    $firstName.val(selectedUser.FirstName)
    $lastName.val(selectedUser.LastName)
    $role.val(selectedUser.Role)
}
function updateUser() {

    console.log(selectedUser)
    selectedUser.Username = $userName.val()
    selectedUser.Password = $password.val()
    selectedUser.FirstName = $firstName.val()
    selectedUser.LastName = $lastName.val()
    selectedUser.Role = $role.val()
    console.log(selectedUser.Username)
    console.log(selectedUser.FirstName)
    console.log(selectedUser.LastName)
    console.log(selectedUser.Password)
    console.log(selectedUser.Role)

    adminUserService.updateUser(selectedUser._id,selectedUser)
        .then(function (status) {
            var index = users.findIndex(user => user._id === selectedUser._id)
            users[index] = selectedUser
            renderUsers(users)
        })
    $userName.val("")
    $password.val("")
    $firstName.val("")
    $lastName.val("")

}
function searchUser(){

}

function renderUsers(users){
    theTableBody.empty()
    for (var i = 0; i < users.length; i++) {
        var user = users[i]
        console.log(user)
        theTableBody.append(`
    <tr class="wbdv-template wbdv-user wbdv-hidden">
            <td class="wbdv-username">${user.Username}</td>
            <td class="wbdv-password"></td>
            <td class="wbdv-first-name">${user.FirstName}</td>
            <td class="wbdv-last-name">${user.LastName}</td>
            <td class="wbdv-role">${user.Role}</td>
            <td class="wbdv-actions">
                <span class="float-right">
                    <i id="${i}" class="fa-2x fa fa-times wbdv-remove"></i>
                    <i id="${user._id}" class="fa-2x fa fa-pencil wbdv-edit"></i>
                </span>
            </td>
        </tr>
    `)
    }
    jQuery(".wbdv-remove").click(deleteUser)
    jQuery(".wbdv-edit").click(selectUser)
}
function main(){

    $userName = $(".wbdv-username-fld")
    $password = $(".wbdv-password-fld")
    $firstName = $(".wbdv-firstname-fld")
    $lastName  = $(".wbdv-lastname-fld")
    $role     = $(".wbdv-role-fld")
    $createBtn = $(".wbdv-create")
    theTableBody = jQuery("tbody")
    $updateBtn = $(".wbdv-update")
    $updateBtn.click(updateUser)
    $searchBtn = jQuery(".wbdv-search")
    $searchBtn.click(searchUser)

    $createBtn.click(function () {

            var newUser = {
                Username: $userName.val(),
                Password: $password.val(),
                FirstName: $firstName.val(),
                LastName: $lastName.val(),
                Role: $role.val()
            }
            createUser(newUser)

            $userName.val("")
            $password.val("")
            $firstName.val("")
            $lastName.val("")
        }
    )
    adminUserService.findAllUsers()
        .then(function (actualUsersFromServer){
            users = actualUsersFromServer
            renderUsers(users)
        })
}
jQuery(main)