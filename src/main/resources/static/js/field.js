$('document').ready(function () {
    $('.table #editButton').on('click', function (event) {

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href, function (field) {
            $('#edit-label').val(field.label);
            $('#edit-type').val(field.type.toString());
            $('#edit-options').val(field.options.toString());
            $('#edit-required').prop('checked', field.isActive);
            $('#edit-active').prop('checked', field.isActive);
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