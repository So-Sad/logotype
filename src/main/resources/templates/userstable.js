$(document).ready( function () {
    var table = $('#usersTable').DataTable({
        "sAjaxSource": "/users",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "lastName" },
            { "mData": "email" },
            { "mData": "phone" },
            { "mData": "active" }
        ]
    })
});