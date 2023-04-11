

window.addEventListener('load', function () {


        (function(){

              const url = '/odontologos';
              const settings = {
                method: 'GET'
            }
            fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                 //recorremos la colección del JSON
                 for(odont of data){
                  //por cada odont armaremos una fila de la tabla
                  //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos
                  //el odont

                  var table = document.getElementById("odontologoTable");
                  var odontRow =  table.insertRow();
                  let tr_id = 'tr_' + odont.id;
                  odontRow.id = tr_id;


                  //por cada odont creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
                  //dicho boton invocara a la funcion de java script deleteByKey que se encargará
                  //de llamar a la API para eliminar al odont
                   let deleteButton = '<button' +
                                              ' id=' + '\"' + 'btn_delete_' + odont.id + '\"' +
                                              ' type="button" onclick="deleteBy('+odont.id+')" class="btn btn-danger btn_delete">' +
                                              '&times' +
                                              '</button>';

                   //por cada estudiante creamos un boton que muestra el id y que al hacerle clic invocará
                   //a la función de java script findBy que se encargará de buscar al estudiante que queremos
                   //modificar y mostrar los datos del mismo en un formulario.
                  let updateButton = '<button' +
                                              ' id=' + '\"' + 'btn_id_' + odont.id + '\"' +
                                              ' type="button" onclick="findBy('+odont.id+')" class="btn btn-info btn_id">' +
                                              odont.id +
                                              '</button>';


                  //armamos cada columna de la fila
                  //como primer columna pondremos el boton modificar
                  //luego los datos del odont
                  //como ultima columna el boton eliminar
                 odontRow.innerHTML = '<td>' + updateButton + '</td>' +
                                      '<td class=\"td_first_name\">' + odont.nombre+ '</td>' +
                                      '<td class=\"td_last_name\">' + odont.apellido+ '</td>' +
                                                                             '<td class=\"td_last_name\">' + odont.matricula+ '</td>' +

                                      '<td>' + deleteButton + '</td>';

                };

        })
        })

        (function(){
          let pathname = window.location.pathname;
          if (pathname == "/ListOdontologo.html") {
              document.querySelector(".nav .nav-item a:last").addClass("active");
          }
        })




})