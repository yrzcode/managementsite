"use strict"

// function footer(){

//     console.log(1);
//     $.ajax({
//         url: "parts/footer.html",
//         cache: false,
//         success: function(html){
//             document.write(html);
//         }
//     });

 function loadFooter(){
    console.log(1);
    console.log(2);

    $(function(){
        $("#footer").load("parts/footer.html");
    });

}