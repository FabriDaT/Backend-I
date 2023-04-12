window.addEventListener('load', function () {

    const btnTurnos = document.querySelector('#btn-turnos')

    btnTurnos.addEventListener('click', function(){
        const sectionTurnos = document.querySelector('.box-section')
        const btnModal = document.getElementById('btn-modal')
        btnModal.classList.remove("d-none");
        btnModal.dataset.bsTarget = "#modal-turno";
        const nameSection = document.querySelector('.h1')
        nameSection.innerHTML = "Turnos"
        tableTurnos();
        getTurnos();
    })
})


function resetUploadFormTurno(){

                      document.querySelector('#paciente').value = "";
                      document.querySelector('#odontologo').value = "";
                      document.querySelector('#fecha_hora').value = "";
                     document.querySelector('#turnoTableBody').innerHTML = "";
                      tableTurnos();
                      getTurnos();
}


function getTurnos(){

                      const url = '/turnos';
                      const settings = {
                        method: 'GET'
                      }

                      fetch(url,settings)
                      .then(response => response.json())
                      .then(data => {
                        //recorremos la colección de turnos del JSON
                           for(turno of data){
                              //por cada turno armo una fila de la tabla
                              var table = document.querySelector(".turnoTable");
                              var turnoRow =table.insertRow();
                              let tr_id = 'tr_' + turno.id;
                              turnoRow.id = tr_id;

                              //por cada turno un boton delete que agregaremos en cada fila para poder eliminar el mismo
                              //dicho boton invocara a la funcion de java script  que se encargará
                              //de llamar a la API para eliminar un turno
                              let deleteButton = '<button' +
                                                        ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                                        ' type="button" onclick="deleteTurnoBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                                       '<i class="bi bi-trash3"></i>' +
                                                        '</button>';

                              //por cada turno un boton y que al hacerle clic invocará
                              //a la función de java script  que se encargará de buscar el turno que queremos
                              //modificar y mostrar los datos del mismo en un formulario.
                              let updateButton = '<button' +
                                                        ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                                        ' type="button" onclick="findTurnoBy('+turno.id+')" class="btn btn-secondary btn_id" data-bs-toggle="modal" data-bs-target="#modal-update-turno">' +
                                                        '<i class="bi bi-pencil-square"></i>' +
                                                        '</button>';


                              //armamos cada columna de la fila
                              turnoRow.innerHTML =
                                      '<td class=\"td_id\">' + turno.id + '</td>' +
                                      '<td class=\"td_paciente\">' + turno.paciente.nombre + " "+ turno.paciente.apellido+'</td>' +
                                      '<td class=\"td_odontologo\">' + turno.odontologo.nombre +" "+turno.odontologo.apellido+ '</td>' +
                                      '<td class=\"td_fecha_hora\">' + turno.fecha_hora + '</td>' +
                                      '<td>' + deleteButton + '</td>'+
                                      '<td>' + updateButton + '</td>';

                          }})

}

function tableTurnos(){
      const sectionTurnos = document.querySelector('.box-section')
      sectionTurnos.innerHTML = `<table class="table table-striped table-sm turnoTable">
            <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Paciente</th>
                  <th scope="col">Odontologo</th>
                  <th scope="col">Fecha-Hora</th>
                  <th scope="col">Eliminar</th>
                  <th scope="col">Modificar</th>
                </tr>
              </thead>
              <tbody id="turnoTableBody">

              </tbody>
            </table>`
    }

