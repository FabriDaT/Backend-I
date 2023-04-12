
window.addEventListener('load', function () {

        (function(){

              const url = '/pacientes';
              const settings = {
                method: 'GET'
            }
            fetch(url,settings)
            .then(response => response.json())
            .then(data => {
                 //recorremos la colección del JSON
                 for(pacien of data){
                  //por cada paciente armaremos una fila de la tabla
                  //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos
                  //el paciente

                  var table = document.getElementById("pacienteTable");
                  var pacienRow =  table.insertRow();
                  let tr_id = 'tr_' + pacien.id;
                  pacienRow.id = tr_id;


                  //por cada pac creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
                  //dicho boton invocara a la funcion de java script deleteByKey que se encargará
                  //de llamar a la API para eliminar al pac
                   let deleteButton = '<button' +
                                              ' id=' + '\"' + 'btn_delete_' + pacien.id + '\"' +
                                              ' type="button" onclick="deleteBy('+pacien.id+')" class="btn btn-danger btn_delete">' +
                                              '&times' +
                                              '</button>';

                   //por cada pac creamos un boton que muestra el id y que al hacerle clic invocará
                   //a la función de java script findBy que se encargará de buscar al pac que queremos
                   //modificar y mostrar los datos del mismo en un formulario.
                  let updateButton = '<button' +
                                              ' id=' + '\"' + 'btn_id_' + pacien.id + '\"' +
                                              ' type="button" onclick="findBy('+pacien.id+')" class="btn btn-info btn_id">' +
                                              pacien.id +
                                              '</button>';


                  //armamos cada columna de la fila
                  //como primer columna pondremos el boton modificar
                  //luego los datos del paciente
                  //como ultima columna el boton eliminar
                 pacienRow.innerHTML = '<td>' + updateButton + '</td>' +
                                      '<td class=\"td_first_name\">' + pacien.nombre+ '</td>' +
                                      '<td class=\"td_last_name\">' + pacien.apellido+ '</td>' +
                                      '<td class=\"td_DNI\">' + pacien.DNI+ '</td>' +
                                      '<td class=\"td_domicilio_id\">' + pacien.domicilio_id+ '</td>' +
                                      '<td class=\"td_calle\">' + pacien.calle+ '</td>' +
                                      '<td class=\"td_numero\">' + pacien.numero+ '</td>' +
                                      '<td class=\"td_localidad\">' + pacien.localidad+ '</td>' +
                                      '<td class=\"td_provincia\">' + pacien.provincia+ '</td>' +

                                      '<td>' + deleteButton + '</td>';

                };

        })
        })

        (function(){
          let pathname = window.location.pathname;
          if (pathname == "/ListPaciente.html") {
              document.querySelector(".nav .nav-item a:last").addClass("active");
          }
        })




})