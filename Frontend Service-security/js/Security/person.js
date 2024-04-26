function save() {
  try {
    var selectedCityId = parseInt($("#selected_city_id").val());
    if (isNaN(selectedCityId) || selectedCityId === null) {
      console.error("ID de ciudad no válido");
      return;
    }

    var personData = {
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
    };



    $.ajax({
      url: "http://localhost:9000/service-security/v1/api/person",
      method: "POST",
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(personData),
      success: function (data) {
        var id = data.id
        console.log(data.data);


        alert("Registro agregado con éxito" + id);
        clearData();
        loadData();
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
  $("#id").val("");
  $("#firstName").val("");
  $("#lastName").val("");
  $("#t_document").val("");
  $("#document").val("");
  $("#email").val("");
  $("#phone").val("");
  $("#dateOfBirth").val("");
  $("#gender").val("");
  $("#address").val("");
  $("#city_id").val("");

  $("#estado").val("");
}



function loadData() {
  console.log("ejecutando loadData");
  $.ajax({
    url: "http://localhost:9000/service-security/v1/api/person",
    method: "GET",
    dataType: "json",
    success: function (response) {
      console.log(response.data);
      var html = "";
      var data = response.data;
      data.forEach(function (item) {
        // Construir el HTML para cada objeto
        if (!item.deletedAt) { // Verificar si el campo deletedAt es nulo (no eliminado lógicamente)

          html +=
            `<tr>
                  <td>${item.firstName}</td>
                  <td>` + item.lastName + `</td>
                  <td>` + item.typeDocument + `</td>
                  <td>` + item.document + `</td>
                  <td>` + item.email + `</td>
                  <td>` + item.phone + `</td>
                  <td>` + item.dateOfBirth + `</td>
                  <td>` + item.gender + `</td>
                  <td>` + item.address + `</td>
                  <td>` + item.municipality.name + `</td>
                  <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                  <td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})"> <img src="/assets/icon/pencil-square.svg" > </button>
                  <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> <img src="/assets/icon/trash3.svg" > </button></td>
              </tr>`;

        };
      });

      $("#resultData").html(html);
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}


function deleteById(id) {
  $.ajax({
    url: "http://localhost:9000/service-security/v1/api/person/" + id,
    method: "delete",
    headers: {
      "Content-Type": "application/json",
    },
  }).done(function (result) {
    alert("Registro eliminado con éxito");
    loadData();
  });
}


function update() {
  // Obtén los datos del formulario
  var selectedCityId = parseInt($("#selected_city_id").val());
  if (isNaN(selectedCityId) || selectedCityId === null) {
    console.error("ID de ciudad no válido");
    return;
  }

  // Construir el objeto data
  var data = {
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
  };

  console.log(data);

  var id = $("#id").val();
  var jsonData = JSON.stringify(data);

  // Realizar la solicitud PUT con AJAX
  $.ajax({
    url: "http://localhost:9000/service-security/v1/api/person/" + id,
    method: "PUT",
    contentType: "application/json",
    data: jsonData,
    success: function (response) {
      // Manejo de éxito
      alert("Registro actualizado con éxito: " + response.id);
      clearData();
      loadData(); // Recarga los datos para reflejar los cambios

      // Actualizar botón
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Agregar");
      btnAgregar.attr("onclick", "save()");
    },
    error: function (jqXHR, textStatus, errorThrown) {
      // Manejo de errores
      console.error("Error en la solicitud AJAX:", textStatus, errorThrown);
      alert(`Error: No se pudo actualizar el registro. Código de estado: ${jqXHR.status}. Por favor, intente nuevamente.`);
      console.log(jqXHR.responseText); // Muestra detalles adicionales sobre el error

      // Restaurar botón
      loadData();
      clearData();
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Agregar");
      btnAgregar.attr("onclick", "save()");
    }
  });
}


function findById(id) {
  $.ajax({
    url: "http://localhost:9000/service-security/v1/api/person/" + id,
    method: "GET",
    dataType: "json",
    success: function (response) {


      var data = response.data;
      //separar address como corresponde
      var frase = data.address;
      var palabras = frase.split(" ");


      $("#id").val(data.id);
      $("#firstName").val(data.firstName);
      $("#lastName").val(data.lastName);
      $("#t.document").val(data.typeDocument);
      $("#document").val(data.document);
      $('#email').val(data.email);
      $('#phone').val(data.phone);
      $('#dateOfBirth').val(data.dateOfBirth);
      $('#gender').val(data.gender);
      $('#address').val(palabras[0]);
      $('#numeral').val(palabras[2]);
      $('#numeral2').val(palabras[4]);
      $('#description').val(palabras[6]);


      $("#selected_city_id").val(data.municipality.id);
      $("#city_id").val(data.municipality.name);

      $("#estado").val(data.state == true ? 1 : 0);

      //Cambiar boton.
      var btnAgregar = $('button[name="btnAgregar"]');
      btnAgregar.text("Actualizar");
      btnAgregar.attr("onclick", "update()");
    },
    error: function (error) {
      // Función que se ejecuta si hay un error en la solicitud
      console.error("Error en la solicitud:", error);
    },
  });
}


function clearData() {
  $("#id").val("");

  $("#email").val("");
  $("#phone").val("");
  $("#dateOfBirth").val("");
  $("#gender").val("");
  $("#address").val("");
  $("#city_id").val("");

  $("#estado").val("");
}
