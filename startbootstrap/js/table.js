var file_location = "store.txt";

fetch(file_location).then(function(response) {
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
        $('#table_id2').DataTable({
                data: JSON.parse(file_content)
            }

        );
    } );
}).catch(function(status) {
    console.log('Error ' + status);
});


file_location = "data/all_results.txt";

fetch(file_location).then(function(response) {
    if (response.status !== 200) {
        throw response.status;
    }
    return response.text();
}).then(function(file_content) {

    $(document).ready( function () {
        $('#all_results_table_id').DataTable({
                data: JSON.parse(file_content)
            }

        );
    } );
}).catch(function(status) {
    console.log('Error ' + status);
});