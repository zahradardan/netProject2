var username;
$(document).ready(function () {

    username =window.localStorage.getItem('user');
    var user = document.getElementById("username");
    user.innerText = username;
    var admin=true;
    if(window.localStorage.getItem('userType')=="true")
      admin=false;


        var settings = {
                     "async": true,
                     "crossDomain": true,
                     "url": "http://localhost:8080/contacts/rest/case/filterCases",
                     "method": "GET",
                     "headers": {
                       "cache-control": "no-cache",
                       "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                     },
                     "data": {
                              "username": username,
                              "userType":admin
                             }
                   }


            $.ajax(settings).done(function (response) {
              console.log(response);
               var refers = [];
                      for (var i = 0; i < response.data.length; i++)
                       {
                         refers.push(response.data[i]);
                       }
             cases(refers);
            });

             submitters(admin);
             responsibles();

    $(".selection").change(function () {
        var filter = document.getElementsByClassName("selection");
        var refers = [];


         var settings = {
                             "async": true,
                             "crossDomain": true,
                             "url": "http://localhost:8080/contacts/rest/case/filtering",
                             "method": "GET",
                             "headers": {
                               "cache-control": "no-cache",
                               "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                             },
                             "data": {
                                      "status": filter[0].value,
                                      "submitter":filter[1].value,
                                      "responsible":filter[2].value
                                     }
         }


         $.ajax(settings).done(function (response) {
           console.log(response);
           alert(response.data.length)
            for (var i = 0; i < response.data.length; i++)
              {
                refers.push(response.data[i]);
              }
            cases(refers);
          });

    });

    function cases(refers) {
        var container = document.getElementById("refers");
        container.innerHTML = '';

        for (var i = 0; i < refers.length; i++) {

            var refer = document.createElement("DIV");
            refer.setAttribute('id', refers[i].caseId)
            refer.classList.add("refer");
            refer.classList.add("container");

            //Up
            var up = document.createElement("DIV");

            var image = document.createElement("IMG");
            image.src = "imgs/profilePicture.jpg";

            var submitter = document.createElement("H2");
            submitter.className = "submitter";
            submitter.innerText = refers[i].submitter;

            var date = document.createElement("P");
            date.className = "date";
            date.innerText = refers[i].date;

            up.appendChild(image);
            up.appendChild(submitter);
            up.appendChild(date);

            var breaker = document.createElement("DIV");
            breaker.className = "breaker";

            //Middle
            var middle = document.createElement("DIV");
            middle.className = "middle";

            var divider = [];
            for (var j = 0; j < 3; j++) {
                divider[j] = document.createElement("SPAN");
                divider[j].className = "divider";
                divider[j].innerText = "|";
            }

            var topic = document.createElement("P");
            topic.className = "topic";
            topic.appendChild(divider[0]);
            topic.appendChild(document.createTextNode(refers[i].topic));

            var description = document.createElement("P");
            description.innerText = refers[i].description;

            middle.appendChild(topic);
            middle.appendChild(description);

            //Down
            var down = document.createElement("DIV");

            var status = document.createElement("P");
            status.appendChild(document.createTextNode("وضعیت"));
            status.appendChild(divider[1]);
            status.appendChild(document.createTextNode(refers[i].status));

            var responsible = document.createElement("P");
            responsible.appendChild(document.createTextNode("مسئول"));
            responsible.appendChild(divider[2]);
            responsible.appendChild(document.createTextNode(refers[i].refer));

            down.appendChild(status);
            down.appendChild(responsible);

            refer.appendChild(up);
            refer.appendChild(breaker);
            refer.appendChild(middle);
            refer.appendChild(down);

            if(refers[i].status==="بسته") {
                //Feedback
                var feedback = document.createElement("DIV");
                feedback.className = "feedback";

                var thumbs = [];
                for (var j = 0; j < 2; j++) {
                    thumbs[j] = document.createElement("BUTTON");
                    thumbs[j].className = "thumb";

                    thumbs[j].onclick = function (e) {
                        var parent = e.target.parentNode;
                        var sibling = parent.childNodes;
                        for (var i = 0; i < sibling.length; i++) {
                            sibling[i].style.transform = "scale(1)";
                            sibling[i].style.filter = "drop-shadow(5px 5px 5px rgba(0,0,0,0.3)) grayscale(40%)";
                        }
                        e.target.style.transform = "scale(1.5)";
                        e.target.style.filter = "drop-shadow(5px 5px 5px rgba(0,0,0,0.3)) grayscale(0)";
                    }

                    feedback.appendChild(thumbs[j]);
                }
                refer.appendChild(feedback);
            }
            container.appendChild(refer);
        }
    }
});

function submitters(admin) {
    var submitters = document.getElementById("submitters");

        if (admin == true) {
            var option = document.createElement("OPTION");
            option.innerText = "بدون فیلتر";
            submitters.appendChild(option);
            var settings = {
                         "async": true,
                         "crossDomain": true,
                         "url": "http://localhost:8080/contacts/rest/contact/users",
                         "method": "GET",
                         "headers": {
                           "cache-control": "no-cache",
                           "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                         }
            }

                $.ajax(settings).done(function (response) {
                  console.log(response);

                  for (var i = 0; i < response.data.length; i++) {
                     var option = document.createElement("OPTION");
                     option.innerText = response.data[i].name;
                     submitters.appendChild(option);
                  }
                });
        }
        else {
            submitters.innerText = '';
            var option = document.createElement("OPTION");
            option.innerText = username;
            submitters.appendChild(option);
        }
}


function responsibles() {
    var responsible = document.getElementById("responsibles");
             var settings = {
                         "async": true,
                         "crossDomain": true,
                         "url": "http://localhost:8080/contacts/rest/contact/responsibles",
                         "method": "GET",
                         "headers": {
                           "cache-control": "no-cache",
                           "postman-token": "d94950d3-5ac0-2e19-a0c7-0863e48183b9"
                         }
            }

            $.ajax(settings).done(function (response) {
                  console.log(response);

               for (var i = 0; i < response.data.length; i++) {
                   var option = document.createElement("OPTION");
                   option.innerText = response.data[i].name;
                   responsible.appendChild(option);
               }

            });
}







