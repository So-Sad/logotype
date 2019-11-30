$('document').ready(function(){

    $('#signUpForm').submit(function (event) {
        var status = true;
        var pass = $('#password').val();
        var confirmPass = $('#confirm-password').val();
        if (pass !== confirmPass) {
            status = false;
            if (confirmPass.length) {
                $('#pass-alert').show();
            }
        }
        return this.status;
    });

});