 function open_modal() {
        var modal = document.getElementById("Login_modal");
        modal.style.display = "block";
        modal.style.transition = "2s";
    }

    function close_modal() {
        var modal = document.getElementById("Login_modal");
        modal.style.display = "none";
    }

 function not_empty() {
    var go = true;
     var string2 = document.getElementById("pass").value;
     var string1 = document.getElementById("user_name").value;

     var error1 = document.getElementById("warn1");
     var error2 = document.getElementById("warn2");

     if(string1.length === 0) {
         error1.style.visibility = "visible";
         go=false;
     }else{
         error1.style.visibility = "hidden";
     }

     if(string2.length === 0) {
         error2.style.visibility = "visible";
         go = false;
     }else{
         error2.style.visibility = "hidden";
     }
     if(go === true){

     var settings = {
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/contacts/rest/contact/logIn",
                "method": "POST",
                "headers": {
                  "cache-control": "no-cache",
                  "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
                },
                 "data": {
                            "username": document.getElementById("user_name").value,
                            "password": document.getElementById("pass").value,
                        }
              }

              $.ajax(settings).done(function (response) {
                console.log(response);
                if(!response.success)
                 alert(response.message);
                 else{
                 window.localStorage.setItem('user',settings['data']['username'] );
                 window.location.href ="editprofile.html";
                 }
              });
     }
 }
   function  edit() {

       var oldpassword=document.getElementById("oldpassword").value;
       var newpassword=document.getElementById("newpassword").value;
 //      alert(oldpassword+" "+newpassword+window.localStorage.getItem('user'));
        var settings = {
            "async": true,
            "crossDomain": true,
            "url": "http://localhost:8080/contacts/rest/contact/edit",
            "method": "POST",
            "headers": {
                "cache-control": "no-cache",
                "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
            },
            "data": {
                "oldpassword":oldpassword ,
                "newpassword":newpassword,
                "username":window.localStorage.getItem('user')
            }
        }

        $.ajax(settings).done(function (response) {
            console.log(response);
            alert(response.message);
        });
    }




