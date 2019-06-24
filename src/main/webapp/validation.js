function passwordcheck() {
    var input = document.getElementById("psw");
    var string = document.getElementById("psw").value;
    var error1 = document.getElementById("error1");


    if(string.length < 8) {
        error1.style.visibility = "visible";
    }else{
        error1.style.visibility = "hidden";
    }
}
function reapetpasswordcheck() {
    var input1 = document.getElementById("psw");
    var string1 = document.getElementById("psw").value;
    var input2 = document.getElementById("psw-repeat");
    var string2 = document.getElementById("psw-repeat").value;
    var error2 = document.getElementById("error2");

    if(string1===string2) {
        error2.style.visibility = "hidden";
    }else{
        error2.style.visibility = "visible";
    }

}

function register(isStudent,isTeacher) {
   if(document.getElementById("email").value.length<1){
   alert("!نام کاربری خود را وارد کنید")
   }else{

   var settings = {
     "async": true,
     "crossDomain": true,
     "url": "http://localhost:8080/contacts/rest/contact/save",
     "method": "POST",
     "headers": {
       "cache-control": "no-cache",
       "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
     },
      "data": {
                 "username": document.getElementById("email").value,
                 "password": document.getElementById("psw").value,
                 "student": isStudent,
                 "teacher": isTeacher
             }
   }

   $.ajax(settings).done(function (response) {
     console.log(response);
      alert(response.message);
   });
   }
}

