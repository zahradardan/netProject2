function myfunc(){
      var settings = {
       "async": true,
                       "crossDomain": true,
                       "url": "http://localhost:8080/contacts/rest/contact/management",
                       "method": "GET",
                       "headers": {
                         "cache-control": "no-cache",
                         "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
                       }
      }
         $.ajax(settings).done(function (response) {
          console.log(response);
                          if(response.success){
                           var t = response.data.length;
                           for(var i = 0 ; i < t ; i+=2){
                           if(response.data[i].confirmed == false){
                           var user_card = document.createElement("DIV");
                            user_card.style.margin="10px";
                            user_card.style.boxShadow = "1px 2px 3px #aaaaaa";
                            user_card.style.padding = "15px 15px 15px 15px";
                              var user_name = document.createElement("P");
                              user_name.innerHTML = response.data[i].name;
                              user_name.id = user_name.innerHTML;

                              var activate = document.createElement("BUTTON");
                              activate.className = "manager_act";
                              activate.innerHTML="تایید کابر";
                              activate.style.backgroundColor = "forestgreen";
                              activate.setAttribute('id',response.data[i].name);
                              activate.onclick = function(){

                              var id = $(this).attr('id');

                                 var settings = {
                                 "async": true,
                                 "crossDomain": true,
                                 "url": "http://localhost:8080/contacts/rest/contact/conf/"+id,
                                 "method": "POST",
                                 "headers": {
                                 "cache-control": "no-cache",
                                 "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
                                  }
                               };
                                   $.ajax(settings).done(function (response) {
                                   console.log(response);
                                   alert(response.message);
                                   });
                               }




                                var line = document.createElement("BR");

                                user_card.appendChild(user_name);
                                user_card.appendChild(activate);
                                document.getElementById("r_part").appendChild(user_card);
                           }
                           }

                           for(var i = 1 ; i < t ; i+=2){
                           if(response.data[i].confirmed == false){
                                     var user_card = document.createElement("DIV");
                                      user_card.style.margin="10px";
                                      user_card.style.boxShadow = "1px 2px 3px #aaaaaa";
                                      user_card.style.padding = "15px 15px 15px 15px";
                                        var user_name = document.createElement("P");
                                        user_name.innerHTML = response.data[i].name;
                                        user_name.id = user_name.innerHTML;


                                        var activate = document.createElement("BUTTON");
                                        activate.className = "manager_act";
                                        activate.innerHTML="تایید کابر";
                                        activate.style.backgroundColor = "forestgreen";
                                        activate.setAttribute('id',response.data[i].name);
                                        activate.onclick = function(){


                              var id = $(this).attr('id');

                                           var settings = {
                                           "async": true,
                                           "crossDomain": true,
                                           "url": "http://localhost:8080/contacts/rest/contact/conf/"+id,
                                           "method": "POST",
                                           "headers": {
                                           "cache-control": "no-cache",
                                           "postman-token": "c881cff2-ee43-9738-1678-f47dd7b64a39"
                                            }
                                         };
                                             $.ajax(settings).done(function (response) {
                                             console.log(response);
                                             alert(response.message);
                                             });
                                         }

                                         var line = document.createElement("BR");

                                          user_card.appendChild(user_name);
                                          user_card.appendChild(activate);
                                          document.getElementById("l_part").appendChild(user_card);
                                     }
                                  }
                    }
         });
}


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