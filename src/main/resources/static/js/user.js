$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (user) {
            $('#edit-id').val(user.id);
            $('#edit-name').val(user.firstName);
            $('#edit-last-name').val(user.lastName);
            $('#edit-email').val(user.email);
            $('#edit-phone').val(user.phone);
            $('#edit-active').val(user.isActive);
        });

        $('#editModal').modal();
    });

    $('.table #deleteButton').on('click', function (event) {

        event.preventDefault();
        var href = $(this).attr('href');
        $('#deleteModal #deleteConfirm').attr('href', href);
        $('#deleteModal').modal();

    })
});