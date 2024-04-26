function saveUserPerson() {
  try {
    var selectedCityId = parseInt($("#selected_city_id").val());
    console.log(selectedCityId);
    if (isNaN(selectedCityId) || selectedCityId === null) {
      console.error("ID de ciudad no válido");
      return;
    }

    var personData = {
      "person": {
        "firstName": $("#firstName").val(),
        "lastName": $("#lastName").val(),
        "typeDocument": $("#t_document").val(),
        "document": $("#document").val(),
        "email": $("#email").val(),
        "phone": $("#phone").val(),
        "dateOfBirth": $("#dateOfBirth").val(),
        "gender": $("#gender").val(),
        "address": $("#address").val() + ' No ' + $("#numeral").val() + ' - ' + $("#numeral2").val() + ' - ' + $("#description").val(),
        "municipality": {
          "id": selectedCityId
        },
        "state": true
      },
      "username": $("#username").val(),
      "password": $("#password").val(),
    };
    console.log(personData);



    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/user/userPerson",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(personData),
      success: function (data) {
        var id = data.id
        console.log(data.data);


        alert("Registro agregado con éxito" + id);
      },
      error: function (error) {
        alert(`La persona: ${$("#person_id").val()} ya cuenta con una cuenta de usuario`);
        //console.log($("#person_id").val());
      },
    });
  } catch (error) {
    console.error("Error obteniendo el cliente:", error);
  }


}
function loadCity() {
  console.log("Ejecutando loadCity");
  $.ajax({
    url: "http://localhost:9000/service-security/v1/api/municipality",
    method: "GET",
    dataType: "json",
    success: function (response) {
      if (response.status && Array.isArray(response.data)) {
        var cities = response.data.map(function (municipality) {
          return {
            label: municipality.name,
            value: municipality.id // Agrega el ID como valor
          };
        });

        // Inicializar el autocompletado en el campo de entrada de texto
        $("#city_id").autocomplete({
          source: function (request, response) {
            var results = $.ui.autocomplete.filter(cities, request.term);
            if (!results.length) {
              results = [{ label: 'No se encontraron resultados', value: null }];
            }
            response(results);
          },
          select: function (event, ui) {
            // Al seleccionar un elemento del autocompletado, guarda el ID en un campo oculto
            $("#selected_city_id").val(ui.item.value);
            // Actualiza el valor del campo de entrada con el nombre de la persona seleccionada
            $("#city_id").val(ui.item.label);
            console.log("ID de ciudad seleccionada: " + ui.item.value);
            return false; // Evita la propagación del evento y el formulario de envío
          }
        });
      } else {
        console.error("Error: No se pudo obtener la lista de ciudades.");
      }
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}


function clearData() {

  $("#firstName").val("");
  $("#lastName").val("");
  $("#typeDocument").val("");
  $("#document").val("");
  $("#email").val("");
  $("#phone").val("");
  $("#dateOfBirth").val("");
  $("#gender").val("");
  $("#address").val("");
  $("#numeral").val("");
  $("#numeral2").val("");
  $("#city_id").val("");
  $("#password").val("");
  $("#username").val("");


}