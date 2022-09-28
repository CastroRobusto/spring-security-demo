$(document).ready(function (){
    $.get('secured', function(res) {
        console.log(res.username);
        $(` <span class="lead" style="color:blue">Username: </span><span id="username-user" style="font-size:25px">${res.username}</span><br>
            <span class="lead" style="color:blue">E-mail: </span><span id="email" style="font-size:25px">${res.email}</span><br>
            <span class="lead" style="color:blue">Ruolo: </span><span id="ruolo" style="font-size:25px">${res.ruolo}</span><br>`).appendTo($('#dati-user'));
    });
})