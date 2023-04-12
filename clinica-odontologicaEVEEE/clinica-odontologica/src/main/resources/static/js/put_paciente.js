window.addEventListener('load', function () {

    const btnPacientes = document.querySelector('#btn-pacientes')

    btnPacientes.addEventListener('click', function(){

        const formularioUpdate = document.querySelector('#update_paciente-form');

        formularioUpdate.addEventListener('submit', function (event) {

            event.preventDefault();

            let pacienteId = document.querySelector('#paciente_id').value;

             const formData = {
                             id: document.querySelector('#paciente_id').value,
                             nombre: document.querySelector('#nombre_update').value,
                             apellido: document.querySelector('#apellido_update').value,
                             email: document.querySelector('#email_update').value,
                             dni: document.querySelector('#dni_update').value,
                             fecha_ingreso: document.querySelector('#fecha_ingreso_update').value,
                             domicilio: {
                                        calle: document.querySelector('#calle_update').value,
                                        numero: document.querySelector('#numero_update').value,
                                        localidad: document.querySelector('#localidad_update').value,
                                        provincia: document.querySelector('#provincia_update').value
                                         }
                                }

            const url = '/pacientes'+"/"+pacienteId;
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

               //Si no hay ningun error se muestra un mensaje diciendo que el paciente se agrego bien
               let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                  '<i class="bi bi-hand-thumbs-up me-1"></i>' +
                                  '<strong>Paciente actualizado</strong> '+
                                  '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                  '</div>'

               document.querySelector('#responseUpdate').innerHTML = successAlert;
               document.querySelector('#responseUpdate').style.display = "block";
               document.querySelector('.pacienteTable').innerHTML = "";

               tablePacientes();

               getPacientes();

                           })
            .catch(error => {
                            //Si hay algun error se muestra un mensaje diciendo que el paciente
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