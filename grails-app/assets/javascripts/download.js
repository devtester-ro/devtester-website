$(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);
$(document).ready(function () {
    $('#download-table').DataTable();
});