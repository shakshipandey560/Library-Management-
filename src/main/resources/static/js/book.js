function bookDataInsertion(){

    var sentData =$("#bookData").serializeArray();
    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;

    });

    $.ajax({
        type: "POST",
        url: "/fetchBookData",
        data: JSON.stringify(jsonData),
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
            alert(data.status);
            if (data.status == true) {
                alert("Data inserted successfully");
                window.location.href = "/bookManagement";
            } else {
                alert("Failed!!!!!!!!!");
            }
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getStudentName(){
    
    var sentData = $('#studentId').val();
    if(sentData==""){
        $('#studentName').val("");
    }
    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;

    });

    $.ajax({
        type: "POST",
        url: "/getStudentName",
        data: sentData,
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
            if (data.studentName == ""){
                alert("Student id not present!!!");
                $('#studentName').val("");
                $('#studentId').val("");
            }
            else{
                $('#studentName').val(data.studentName);
            }
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function getBookName(){

    var sentData = $('#bookId').val();
    if(sentData==""){
        $('#bookName').val("");
    }
    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;

    });

    $.ajax({
        type: "POST",
        url: "/getBookName",
        data: sentData,
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
            if(data.bookName==""){
                alert("Book id not present!!!");
                $('#bookName').val("");
                $('#bookId').val("");
            }
            else{
                $('#bookName').val(data.bookName);
            }
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function issueBookDetails(){
    var sentData =$("#insertBook").serializeArray();
    
    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;

    });

    $.ajax({
        type: "POST",
        url: "/newBookIssue",
        data: JSON.stringify(jsonData),
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
            if (data.status == true) {
                alert("Data inserted successfully");
                window.location.href = "/viewRecord";
            } else {
                alert("Failed!!!!!!!!!");
            }
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
}

function returnIssueBook(){

    var sentData =$("#returnBook").serializeArray();
    var jsonData = {};
    $(sentData).each(function(index, obj){
        jsonData[obj.name] = obj.value;
    });

    $.ajax({
        type: "POST",
        url: "/returnBookIssued",
        data: JSON.stringify(jsonData),
        dataType: "json",
        contentType: 'application/json',
        success: function(data) {
            if (data.status == true) {
                alert("Data inserted successfully");
                window.location.href = "/view"
            } else {
                alert("Failed!!!!!!!!!");
            }
        },
        error: function(e) {
            console.log("ERROR: ", e);
        }
    });
    
}