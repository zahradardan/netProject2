$(document).ready(function () {
    $("#transform").click(function () {
        var links=document.getElementsByClassName("link");
        var visibile=document.getElementById("topnav").getAttribute("visible");
        if(visibile==="false"){
            document.getElementById("topnav").setAttribute("visible","true");
            for(var i=0;i<links.length;i++)
                links[i].style.display='inline-block';
        }
        if(visibile==="true"){
            document.getElementById("topnav").setAttribute("visible","false");
            for(var i=0;i<links.length;i++)
                links[i].style.display='none';
        }
    });
});

function createCase(){

var settings = {
                "async": true,
                "crossDomain": true,
                "url": "http://localhost:8080/contacts/rest/case/create",
                "method": "POST",
                "headers": {
                  "cache-control": "no-cache",
                  "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
                },
                 "data": {
                            "topic": document.getElementById("oldpassword").value,
                            "refer": document.getElementById("refer").value,
                            "description": document.getElementById("description").value,
                            "username":window.localStorage.getItem('user')
                        }
              }

              $.ajax(settings).done(function (response) {
                console.log(response);
                if(!response.success){
                 alert("ثبت مورد با شکست مواجه شد.");
                 }
                 else{
                  alert(response.message);
                  window.location.href ="editprofile.html";
                 }
              });
}

