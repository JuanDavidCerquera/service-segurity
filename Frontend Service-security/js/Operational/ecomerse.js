function loadData() {

    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/product",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log("ejecutando loadData");
            console.log(response.data);
            var html = "";
            var data = response.data;
            data.forEach(function (item) {
                if (!item.deletedAt) {
                    //&& item.cantidad != 0
                    html +=
                        `<tr>
                        <td>` + item.name + `</td>
                        <td>` + item.price + `</td>
                        <td>` + (item.state == true ? "Activo" : "Inactivo") + `</td>
                    <td> <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop" onclick="findById(${item.id})"> <img src="/assets/icon/pencil-square.svg" > </button>
                    <button type="button" class="btn btn-secundary" onclick="deleteById(${item.id})"> <img src="/assets/icon/trash3.svg" > </button></td>
                </tr>`;
                }

            });
            $("#resultData").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    })
}

function loadData2() {

    $.ajax({
        url: "http://localhost:9000/service-security/v1/api/product",
        method: "GET",
        dataType: "json",
        success: function (response) {
            console.log("ejecutando loadData");
            console.log(response.data);
            var html = "";
            var data = response.data;
            data.forEach(function (item) {
                if (!item.deletedAt) {
                    //&& item.cantidad != 0
                    html +=
                        `<div class="item_product">
                        <h2>` + item.name + `</h2>
                            <h2>` + item.price + `</h2>
                            </div>
                            `

                }

            });
            $("#content_products").html(html);
        },
        error: function (error) {
            // Función que se ejecuta si hay un error en la solicitud
            console.error("Error en la solicitud:", error);
        },
    })
}