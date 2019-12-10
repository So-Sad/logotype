$('document').ready(function () {

    var href = "/users/getByEmail";

    $.get(href, function (user) {
        $('#id-label').hide();
        $('#edit-id').val(user.id);
        $('#edit-id').hide();
        $('#edit-name').val(user.firstName);
        $('#edit-last-name').val(user.lastName);
        $('#edit-email').val(user.email);
        $('#edit-phone').val(user.phone);
        $('#edit-active').prop("checked", "true");
    });

    $('#editForm').submit(function (event) {
        var status = true;
        var pass = $('#password').val();
        var confirmPass = $('#confirm-password').val();
        if (pass !== confirmPass) {
            status = false;
            if (confirmPass.length) {
                return this.status;
            }
        }
        return this.status;
    });
});