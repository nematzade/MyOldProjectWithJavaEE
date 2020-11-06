/**
 * Created by Mohammad on 19/01/2018.
 */

var url;
function newPersist(formId,persistUrl){
    $('#'+formId).form('submit',{
        url: persistUrl,
        onSubmit: function(){
            alert("با موفقیت ذخیره شد.");
        },success:function (result) {
            response = JSON.parse(result);
            if (response.error != null){
                $.messager.alert("خطا",response.error);
            }
        }
    });
}


function update(formId,updateUrl){

    $('#'+formId).form('submit',{
        url: updateUrl,
        onSubmit: function(){
            alert("تغییرات با موفقیت اعمال شد.");
        }
        // ,
        // success: function(){
        //     if (result.errorMsg){
        //         alert("دوباره سعی کنید!!!");
        //     }
        // }
    });
    window.location.reload();
}

//todo : method loading ra mitavan bardasht va jaygozin kard.
function loading(readUrl) {
    $.post(readUrl, function(result){

    });
    window.location.reload();
}


function onDelete(id,deleteUrlAndIdParam,httpViewUrl,readUrl){

    $.post(deleteUrlAndIdParam + id, function(){window.location.reload();});

    $.ajax({
        url: httpViewUrl,
        success: function() {
            loading(readUrl);
            alert("حذف شد!!!");
        }
    });

    window.location.reload();
}




