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
})

function newCase(){

var form = new FormData();
form.append("topic", document.getElementById("oldpassword").value);
form.append("refer", document.getElementById("refer").value);
form.append("description", document.getElementById("description").value);

var settings = {
  "async": true,
  "crossDomain": true,
  "url": "http://localhost:8080/contacts/rest/case/save",
  "method": "POST",
  "headers": {
    "cache-control": "no-cache",
    "postman-token": "284893b0-d837-35ca-6ec7-38b2ec571b2b"
  },
  "processData": false,
  "contentType": false,
  "mimeType": "multipart/form-data",
  "data": form
}

$.ajax(settings).done(function (response) {
  console.log(response);
  alert("مورد با موفقیت ثبت شد ");
});

}