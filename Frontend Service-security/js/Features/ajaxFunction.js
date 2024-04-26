// ajaxFunctions.js
// cada vez que se ejecute alguna vista
$(document).ready(function () {
  const genderSelect = $('#address'); // id direccion

  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/enum/nomenclature',
    type: 'GET',
    dataType: 'json',
    success: function (data) {
      $.each(data, function (index, option) {
        const optionElement = $('<option></option>').attr('value', option).text(option);
        genderSelect.append(optionElement);
      });
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.error('Error al obtener datos desde el endpoint:', errorThrown);
    }
  });
  //********************************************************************************************* 

  const typeDocumentSelect = $('#t_document'); // id tipo documento
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/enum/type-document',
    type: 'GET',
    dataType: 'json',
    success: function (data) {
      $.each(data, function (index, option) {
        const optionElement = $('<option></option>').attr('value', option).text(option);
        typeDocumentSelect.append(optionElement);
      });
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.error('Error al obtener datos desde el endpoint:', errorThrown);
    }
  });
  //********************************************************************************************* 

  const monthSelect = $('#months'); // id tipo documento
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/enum/month',
    type: 'GET',
    dataType: 'json',
    success: function (data) {
      $.each(data, function (index, option) {
        const optionElement = $('<option></option>').attr('value', option).text(option);
        monthSelect.append(optionElement);
      });
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.error('Error al obtener datos desde el endpoint:', errorThrown);
    }
  });
  //********************************************************************************************* 

  const daySelect = $('#days'); // id tipo documento
  $.ajax({
    url: 'http://localhost:9000/service-security/v1/api/enum/day',
    type: 'GET',
    dataType: 'json',
    success: function (data) {
      $.each(data, function (index, option) {
        const optionElement = $('<option></option>').attr('value', option).text(option);
        daySelect.append(optionElement);
      });
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.error('Error al obtener datos desde el endpoint:', errorThrown);
    }
  });









});
