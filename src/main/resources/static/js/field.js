$('document').ready(function(){
    $('.table #editButton').on('click',function(event){

        event.preventDefault();

        var href= $(this).attr('href');

        $.get(href, function (field) {
            $('#edit-id').val(field.id);
            $('#edit-label').val(field.label);
            $('#edit-type').val(field.type.toString());
            $('#edit-required').val(field.isRequired);
            $('#edit-active').val(field.isActive);
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