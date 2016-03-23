/**
 * Created by Sergey on 22.03.2016.
 */
function markFieldWithErrorIfNeeded( fieldname ) {
    var errorId = "#" + fieldname + "\\.errors";
    var fieldId = "#field-" + fieldname;
    if ( $(errorId).length ) {
        $(fieldId).addClass("has-error");
    }
}
$(document).ready(function () {
    markFieldWithErrorIfNeeded("name");
    markFieldWithErrorIfNeeded("age");
    markFieldWithErrorIfNeeded("moneyAmount");
});
