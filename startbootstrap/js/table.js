fetch('store.txt').then(function(response) {
    if (response.status !== 200) {
        throw response.status;
    }
    return response.text();
}).then(function(file_content) {

    $(document).ready( function () {
        $('#table_id').DataTable({
                data: JSON.parse(file_content)
            }

        );
    } );
}).catch(function(status) {
    console.log('Error ' + status);
});