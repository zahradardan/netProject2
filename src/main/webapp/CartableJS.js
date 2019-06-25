$(document).ready(function () {

    var username =window.localStorage.getItem('user');
    document.getElementById("username").innerText=username;



    var settings = {
             "async": true,
             "crossDomain": true,
             "url": "http://localhost:8080/contacts/rest/case/getUserCases",
             "method": "GET",
             "headers": {
               "cache-control": "no-cache",
               "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
             },
             "data": {
                      "username": username,
                     }
           }


    $.ajax(settings).done(function (response) {
      console.log(response);


      alert(response.data.length);


        for(var i=response.data.length-1;i>=0;i--){


            var refer=document.createElement("DIV");
            refer.setAttribute('id',response.data[i].id);
            refer.classList.add("refer");
            refer.classList.add("container");
            refer.setAttribute("submitter",response.data[i].submitter);

            refer.onclick=function () {
                var id = $(this).attr('id');
                var queryString = "?case="+id;
                window.location.href = "Action.html" + queryString;
            }

            //Up
            var up=document.createElement("DIV");

            var image=document.createElement("IMG");
            image.src="imgs/profilePicture.jpg";

            var submitter=document.createElement("H2");
            submitter.className="submitter";
            submitter.innerText=response.data[i].submitter;

            var date=document.createElement("P");
            date.className="date";
            date.innerText=response.data[i].date;

            up.appendChild(image);
            up.appendChild(submitter);
            up.appendChild(date);

            var breaker=document.createElement("DIV");
            breaker.className="breaker";

            //Middle
            var middle=document.createElement("DIV");
            middle.className="middle";

            var divider=[];
            for(var j=0;j<3;j++){
            divider[j]=document.createElement("SPAN");
            divider[j].className="divider";
            divider[j].innerText="|";
            }

            var topic=document.createElement("P");
            topic.className="topic";
            topic.appendChild(divider[0]);
            topic.appendChild(document.createTextNode(response.data[i].topic));

            var description=document.createElement("P");
            description.innerText=response.data[i].description;

            middle.appendChild(topic);
            middle.appendChild(description);

            //Down
            var down=document.createElement("DIV");

            var status=document.createElement("P");
            // status.innerText=response[i].status;
            status.appendChild(document.createTextNode("وضعیت"));
            status.appendChild(divider[1]);
            status.appendChild(document.createTextNode(response.data[i].status));


            var responsible=document.createElement("P");
            responsible.appendChild(document.createTextNode("مسئول"));
            responsible.appendChild(divider[2]);
            responsible.appendChild(document.createTextNode(response.data[i].refer));

            down.appendChild(status);
            down.appendChild(responsible);

            refer.appendChild(up);
            refer.appendChild(breaker);
            refer.appendChild(middle);
            refer.appendChild(down);

            var container=document.getElementById("refers");
            container.appendChild(refer);
        }
    });

});


