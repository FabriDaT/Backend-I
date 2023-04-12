window.addEventListener('load', function () {

    const btnTurnos = document.querySelector('#btn-turnos')

    btnTurnos.addEventListener('click', function(){

        const formularioUpdate = document.querySelector('#update_turno-form');

        formularioUpdate.addEventListener('submit', function (event) {

            event.preventDefault();

            let turnoId = document.querySelector('#turno_id').value;
            findPacienteByDni(document.querySelector('#paciente_update').value);
            findOdontologoByMatricula(document.querySelector('#odontologo_update').value);

             const formData = {
                            id:  turno.id,
                             fecha_hora: document.querySelector('#fecha_hora_update').value,
                             paciente: {id: paciente.id,
                                                domicilio: {
                                                    id: paciente. domicilio.id
                                                }
                             },
                             odontologo: {id: odontologo.id}
                                }

            const url = '/turnos'+"/"+turnoId;
            const settings = {
                             method: 'PUT',
                             headers: {
                                 'Content-Type': 'application/json',
                             },
                             body: JSON.stringify(formData)
                         }

            fetch(url,settings)

            .then(response => response.json())

            .then(data => {

               //Si no hay ningun error se muestra un mensaje diciendo que el turno se agrego bien
               let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                  '<i class="bi bi-hand-thumbs-up me-1"></i>' +
                                  '<strong>Tuno actualizado</strong> '+
                                  '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                  '</div>'

               document.querySelector('#responseUpdate').innerHTML = successAlert;
               document.querySelector('#responseUpdate').style.display = "block";
               document.querySelector('.turnoTable').innerHTML = "";

               tableTurnos();

               getTurnos();

                           })
            .catch(error => {
                            //Si hay algun error se muestra un mensaje diciendo que el turno
                            //no se pudo guardar y se intente nuevamente
                            let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                              '<i class="bi bi-hand-thumbs-down me-1"></i>' +
                                              '<strong> Error intente nuevamente</strong>' +
                                               '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                                '</div>'

            document.querySelector('#responseUpdate').innerHTML = errorAlert;
            document.querySelector('#responseUpdate').style.display = "block";
                        })

                     });
    })

    })