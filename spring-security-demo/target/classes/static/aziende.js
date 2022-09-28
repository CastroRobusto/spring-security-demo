$(document).ready(function () {
    // LISTA AZIENDE
    function getAziende(){
        $.get('aziende', function(res){
            for(let i = 0; i < res.object.length; i++){
                $(` <tr>
                        <td>${res.object[i].ragioneSociale}</td>
                        <td>${res.object[i].indirizzo}</td>
                        <td>
                            <button class='btn-dettagli-azienda' id="open-dettagli-azienda" data-id='${res.object[i].id}'>Dettagli</button>
                            <button class='btn-modifica-azienda' id="open-modifica-azienda" data-id='${res.object[i].id}'>Modifica</button>
                            <button class='btn-elimina-azienda' data-id='${res.object[i].id}'>&times;</button>
                        </td>
                    </tr>`).hide().appendTo($('#lista-aziende')).fadeIn(i*200);
            }
        })
    }

    getAziende();

    // AGGIUNGI AZIENDE
    $('#btn-aggiungi-azienda').click(function() {
        const ragioneSociale = $('#ragione-sociale').val();
        const partitaIva = $('#partita-iva').val();
        const indirizzo = $('#indirizzo').val();
        const email = $('#email').val();
        const nTel = $('#telefono').val();

        const azienda = {ragioneSociale, partitaIva, indirizzo, email, nTel};

        modalAggiungi.style.display = "none";

        $('#ragione-sociale').val('');
        $('#partita-iva').val('');
        $('#indirizzo').val('');
        $('#email').val('');
        $('#telefono').val('');

        aggiungiAzienda(azienda);
    })

    function aggiungiAzienda(azienda){
        console.log(azienda);
        $.ajax({
            contentType: "application/json;charset=utf-8",
			url: 'aziende',
			type: 'POST',
			data: JSON.stringify(azienda),
			success: function(res) {
                if (res == true) {
					$('#lista-aziende').html('');
					getAziende();
				} else {
					alert('Qualcosa è andato storto');
				}
			}
		})

    }

    // DETTAGLI AZIENDE
    $('#lista-aziende').on('click', '.btn-dettagli-azienda', function(){
        $('#dettagli-azienda').html('');
        dettagliAzienda(+$(this).attr('data-id'));
    });

    function dettagliAzienda(id){
        console.log(id);
        $.get(`aziende/${id}`, function(res){
            console.log(res.object);
            $(` <p><b>Ragione Sociale</b>: ${res.object.ragioneSociale}</p>
                <p><b>Partita IVA</b>: ${res.object.partitaIva}</p>
                <p><b>Indirizzo</b>: ${res.object.indirizzo}</p>
                <p><b>E-Mail</b>: ${res.object.email}</p>
                <p><b>Telefono</b>: ${res.object.nTel}</p>
                <button id="open-lista-dipendenti-azienda" data-id='${res.object.id}'>Lista dipendenti</button>`).appendTo($('#dettagli-azienda'));
            
        })
    }

    // MODIFICA AZIENDA
    $('#lista-aziende').on('click', '.btn-modifica-azienda', function(){
        $('#modifica-azienda').html('');
        caricaModificaAzienda(+$(this).attr('data-id'));
    });

    function caricaModificaAzienda(idAzienda){
        console.log(idAzienda);
        $.get(`aziende/${idAzienda}`, function(res){
            $(` <input type="hidden" id="id-azienda-mod" value="${res.object.id}">
                <h2>Ragione sociale</h2>
                <input type="text" id="ragione-sociale-mod" value="${res.object.ragioneSociale}" placeholder="Ragione sociale...">
                <h2>Partita IVA</h2>
                <input type="text" id="partita-iva-mod" value="${res.object.partitaIva}" placeholder="Partita IVA...">
                <h2>Indirizzo</h2>
                <input type="text" id="indirizzo-mod" value="${res.object.indirizzo}" placeholder="Indirizzo...">
                <h2>E-Mail</h2>
                <input type="text" id="email-mod" value="${res.object.email}" placeholder="E-Mail...">
                <h2>Telefono</h2>
                <input type="text" id="telefono-mod" value="${res.object.nTel}" placeholder="Telefono...">
                <div class="field button-field">
                    <button id="invia-modifica-azienda">Invio</button>
                </div>`).appendTo($('#modifica-azienda'));
            
            caricaAzienda();
        })
    }

    function caricaAzienda(){
        $('#invia-modifica-azienda').click(function(){
            const id = $('#id-azienda-mod').val();
            const ragioneSociale = $('#ragione-sociale-mod').val();
            const partitaIva = $('#partita-iva-mod').val();
            const indirizzo = $('#indirizzo-mod').val();
            const email = $('#email-mod').val();
            const nTel = $('#telefono-mod').val();

            const aziendaMod = {id, ragioneSociale, partitaIva, indirizzo, email, nTel};

            modalModifica.style.display = "none";
            console.log(aziendaMod);
            aggiungiAziendaModificata(aziendaMod);
        })
    }

    function aggiungiAziendaModificata(aziendaMod){
        $.ajax({
            contentType: "application/json;charset=utf-8",
            url: 'aziende',
            type: 'PUT',
            data: JSON.stringify(aziendaMod),
            success: function (res) {
                if (res == true) {
                    $('#lista-aziende').html('');
                    getAziende();
                } else {
                    alert('Non è stato possibile modificare questa azienda');
                }
            }
        })
    }

    // ELIMINA AZIENDA
    $('#lista-aziende').on('click', '.btn-elimina-azienda', function(){
        $('#lista-aziende').html('');
        eliminaAzienda(+$(this).attr('data-id'));
    });

    function eliminaAzienda(id){
        console.log(id);
        $.ajax({
			url: `aziende/${id}`,
			type: 'DELETE',
			success: function(res) {
				if (res == true) {
                    getAziende();
				} else {
					alert('Impossibile eliminare questa azienda');
				}
			}
		})
    }

    // LISTA DIPENDENTI PER AZIENDA
    $('#dettagli-azienda').on('click', '#open-lista-dipendenti-azienda', function(){
        $('#lista-dipendenti-azienda').html('');
        listaDipendenti(+$(this).attr('data-id'));
        
    })

    function listaDipendenti(idAzienda){
        $.get(`aziende/dipendenti/${idAzienda}`, function(res){
            for(let i = 0; i < res.object.length; i++){
                console.log(res.object[i].nome);
                $(`<p>${res.object[i].nome} ${res.object[i].cognome}</p>`).appendTo($('#lista-dipendenti-azienda'));
            }
        })
    }

    // GESTIONE MODALI
    var modalAggiungi = document.getElementById("modale-aggiungi-azienda");
    var modalDettagli = document.getElementById("modale-dettagli-azienda");
    var modalModifica = document.getElementById("modale-modifica-azienda");
    var modalLista = document.getElementById("modale-lista-dipendenti");

    var btn = document.getElementById("open-aggiungi-azienda");

    var spanAggiungi = document.getElementsByClassName("closeA")[0];
    var spanDettagli = document.getElementsByClassName("closeD")[0];
    var spanModifica = document.getElementsByClassName("closeM")[0];
    var spanLista = document.getElementsByClassName("closeL")[0];

    btn.onclick = function () {
        modalAggiungi.style.display = "block";
    };

    $('#lista-aziende').on('click', '#open-dettagli-azienda', function(){
        modalDettagli.style.display = "block";
    })

    $('#lista-aziende').on('click', '#open-modifica-azienda', function(){
        modalModifica.style.display = "block";
    })

    $('#dettagli-azienda').on('click', '#open-lista-dipendenti-azienda', function(){
        modalLista.style.display = "block";
    })

    spanAggiungi.onclick = function () {
        modalAggiungi.style.display = "none";
    };

    spanDettagli.onclick = function () {
        modalDettagli.style.display = "none";
    };

    spanModifica.onclick = function () {
        modalModifica.style.display = "none";
    };

    spanLista.onclick = function () {
        modalLista.style.display = "none";
    };

    window.onclick = function (event) {
        if (event.target == modalAggiungi) {
            modalAggiungi.style.display = "none";
        } else if (event.target == modalDettagli){
            modalDettagli.style.display = "none";
        } else if (event.target == modalModifica){
            modalModifica.style.display = "none";
        } else if (event.target == modalLista){
            modalLista.style.display = "none";
        }
    };
});