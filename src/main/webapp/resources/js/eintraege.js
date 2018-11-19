function ladeEintraege() {
    $.ajax({
        type: "GET",
        url: "eintrag",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function (data, status, jqXHR) {
            $('#eintraege').empty();

            for (var i in data) {
                eintragAnzeigen(data[i].verfasser, data[i].text, data[i].datum);
            }
        },
        error: function (jqXHR, status) {
            alert(status);
        }
    });
}

function eintragAnzeigen(verfasser, text, datum) {
    var eintragText = document.createTextNode(text);
    var verfasserText = document.createTextNode(verfasser + ' am ' + $.format.toBrowserTimeZone(datum, "dd.MM.yyyy") + ' um ' + $.format.toBrowserTimeZone(datum, "HH:mm:ss"));

    var textElement = document.createElement("eintrag");
    var verfasserElement = document.createElement("verfasser");

    textElement.appendChild(eintragText);
    verfasserElement.appendChild(verfasserText);

    var li = document.createElement("li");

    li.appendChild(textElement);
    li.appendChild(verfasserElement);

    $('#eintraege').prepend(li);
}

function neuenEintragErstellen() {
    var vorname = $('#vorname').val();
    var nachname = $('#nachname').val();
    var präferenz1 = $('#präferenz1').val();
    var präferenz2 = $('#präferenz2').val();
    var präferenz3 = $('#präferenz3').val();
    var jsonData= {"vorname":vorname, "nachname":nachname, "präferenz1":präferenz1, "präferenz2":präferenz2, 
    		"präferenz3":präferenz3} ;

    $.ajax({
        type: "POST",
        url: "antrag",
        data: JSON.stringify(jsonData),
        contentType: "application/json; charset=utf-8",
        success: function (data, status, jqXHR) {
            $('#vorname').val('');
            $('#nachname').val('');
            $('#präferenz1').val('');
            $('#präferenz2').val('');
            $('#präferenz3').val('');
            
            
            ladeEintraege();
        },
        error: function (response, status, error) {
        	console.log(response);
            var error = JSON.parse(response);
            alert(error.message);
        }
    });
}
