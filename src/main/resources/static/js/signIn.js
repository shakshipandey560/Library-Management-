function signInUser(){

    var userName= $("#username").val();
    var emailPat=/^(.+)@(.+)$/
    var matchArray=userName.match(emailPat);

    if (matchArray==null) {
        alert("Email address seems incorrect (check @ and .'s)")
        return false;
    }
    var sentData =$("#signIn").serializeArray();
    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;

    });
    var url = "/fetchCustomerData?jsonData=" + encodeURIComponent(JSON.stringify(jsonData));

    $.ajax({
        type : "GET",
        url : url,
        contentType: 'application/json; charset=utf-8',
        success : function(data){
            alert(data);
            if(data == true){
                window.location.href ="/index";
            }
            else{
                window.location.href ="/404";
            }
        },
        error : function(e) {
            console.log("ERROR: ", e);
        },
        done : function(e) {
            console.log("test");
        }
    });
}


// function signUpUser(){
//
//
//     var userName= $("#username1").val();
//     var emailPat=/^(.+)@(.+)$/
//     var matchArray=userName.match(emailPat);
//
//     if (matchArray==null) {
//         alert("Email address seems incorrect (check @ and .'s)")
//         return false;
//     }
//     var sentData =$("#signUp").serializeArray();
//     var jsonData = {};
//     $(sentData).each(function(index, obj){
//         jsonData[obj.name] = obj.value;
//
//     });
//         $.ajax({
//             type : "POST",
//             url : "/insertCustomerData",
//             data :  JSON.stringify(jsonData),
//             contentType: 'application/json',
//             success : function() {
//                 alert("Data inserted successfully")
//             },
//             error : function(e) {
//                 console.log("ERROR: ", e);
//             },
//             done : function(e) {
//                 console.log("test");
//             }
//         });
// }

function userDataInsertion(){

    var sentData =$("#userData").serializeArray();

    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;
    });
    // alert(JSON.stringify(jsonData));

    $.ajax({
        type: "POST",
        url: "/insertCustomerData",
        data: JSON.stringify(jsonData),
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
            if (data.status == true) {
                alert("Data inserted successfully");
                window.location.href = "/userManagement"
            } else {
                alert("Failed!!!!!!!!!");
            }
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}