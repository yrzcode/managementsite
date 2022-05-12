"use strict"

//* add "change info button" function
$(".get-update-info-button").on("click", function(){
    var parent = $(this).parent();
    var name = $(parent).siblings("#result_member_name").text();
    var age = $(parent).siblings("#result_member_age").text();
    var sex = $(parent).siblings("#result_member_sex").text();
    var phone = $(parent).siblings("#result_member_phone").text();
    var address = $(parent).siblings("#result_member_address").text();

    addUpdateInfoFormText("#update-input-table-name", name);
    addUpdateInfoFormText("#update-input-table-age", age);
    addUpdateInfoFormText("#update-input-table-sex", sex);
    addUpdateInfoFormText("#update-input-table-phone", phone);
    addUpdateInfoFormText("#update-input-table-address", address);
  
});

function addUpdateInfoFormText(selector, data){
    $(selector).val(data);
}

