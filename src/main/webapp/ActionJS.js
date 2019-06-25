$(document).ready(function () {
    var queryString = decodeURIComponent(window.location.search);
    queryString = queryString.substring(6);

    var settings = {
                 "async": true,
                 "crossDomain": true,
                 "url": "http://localhost:8080/contacts/rest/case/getCase",
                 "method": "GET",
                 "headers": {
                   "cache-control": "no-cache",
                   "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                 },
                 "data": {
                          "id": queryString,
                         }
               }


        $.ajax(settings).done(function (response) {
          console.log(response);


        var Case=document.getElementById("case");
        var refer=response.data;
        if(window.localStorage.getItem('userType')=="true")
           var type="دانشجو";
        else
           var type="کارمند";


        //UP
        var up=document.createElement("DIV");
        up.className="up";

        var img =document.createElement("IMG");
        img.src="imgs/profilePicture.jpg";

        var submitter=document.createElement("H2");
        submitter.className="submitter";
        submitter.innerText=refer.submitter;

        var userType=document.createElement("H2");
        userType.className="userType";
        userType.innerText=type;

        var date=document.createElement("P");
        date.className="date";
        date.innerHTML=refer.date;

        up.appendChild(img);
        up.appendChild(submitter);
        up.appendChild(userType);
        up.appendChild(date);
        Case.appendChild(up);

        var breaker=document.createElement("DIV");
        breaker.className="breaker";
        Case.appendChild(breaker);


        //Middle
        var middle=document.createElement("DIV");
        middle.className="middle";

        var divider=[];
        for(var j=0;j<3;j++){
            divider[j]=document.createElement("SPAN");
            divider[j].className="divider";
            divider[j].innerText="| ";
        }

        var topic=document.createElement("P");
        topic.className="topic";
        topic.innerText=refer.topic;

        var description=document.createElement("P");
        description.className="description";
        description.innerText=refer.description;

        middle.appendChild(topic);
        middle.appendChild(divider[0]);
        middle.appendChild(description);
        Case.appendChild(middle);

        //Down
        var down=document.createElement("DIV");
        down.className="down";

        var status=document.createElement("P");
        status.appendChild(document.createTextNode("وضعیت"));
        status.appendChild(divider[1]);
        status.appendChild(document.createTextNode(refer.status));


        var responsible=document.createElement("P");
        responsible.appendChild(document.createTextNode("مسئول"));
        responsible.appendChild(divider[2]);
        responsible.appendChild(document.createTextNode(refer.refer));

        down.appendChild(status);
        down.appendChild(responsible);
        Case.appendChild(down);

    });
});


function executing(){

 var queryString = decodeURIComponent(window.location.search);
 queryString = queryString.substring(6);
 var filter = document.getElementsByClassName("select-box");
 var paraf=document.getElementById("paraf").value;

 var settings = {
                    "async": true,
                    "crossDomain": true,
                    "url": "http://localhost:8080/contacts/rest/case/action",
                    "method": "POST",
                    "headers": {
                      "cache-control": "no-cache",
                      "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                    },
                    "data": {
                             "id":queryString,
                             "status": filter[0].value,
                            }
                  }

            $.ajax(settings).done(function (response) {
            console.log(response);
            alert(response.message);
           });
}


function refering(){
   var queryString = decodeURIComponent(window.location.search);
    queryString = queryString.substring(6);
    var refer=document.getElementById("refered").value;
  var settings = {
                   "async": true,
                   "crossDomain": true,
                   "url": "http://localhost:8080/contacts/rest/case/updateRefer",
                   "method": "POST",
                   "headers": {
                     "cache-control": "no-cache",
                     "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                   },
                   "data": {
                            "id":queryString,
                            "refer": refer
                           }
                 }

           $.ajax(settings).done(function (response) {
           console.log(response);
           alert(response.message);
          });

}

function execute() {
    var refButton = document.getElementById("refer");
    refButton.style.display = 'none';
    var exeButton = document.getElementById("execute");
    exeButton.style.display = 'block';

 var send = document.getElementById("send1");
        send.style.display = 'none';

    var send = document.getElementById("send");
    send.style.display = 'block';


}

function refer() {
    var exeButton = document.getElementById("execute");
    exeButton.style.display = 'none';
    var refButton = document.getElementById("refer");
    refButton.style.display = 'block';

    var send = document.getElementById("send");
    send.style.display = 'none';
    var send = document.getElementById("send1");
        send.style.display = 'block';
}






