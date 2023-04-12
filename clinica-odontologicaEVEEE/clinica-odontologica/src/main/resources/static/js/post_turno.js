window.addEventListener('load', function () {

    const btnTurnos = document.querySelector('#btn-turnos')

    btnTurnos.addEventListener('click', function(){

      const formulario = document.querySelector('.add_new_turno');


              //Ante un submit del formulario se ejecutará la siguiente funcion
              formulario.addEventListener('submit', function (event) {
                         event.preventDefault();
                        // findPacienteByDni(document.querySelector('#paciente').value);
                        // findOdontologoByMatricula(document.querySelector('#odontologo').value);

                         const formData = {
                                          fecha_hora: document.querySelector('#fecha_hora').value,
                                          paciente : {id: document.querySelector('#id_paciente').value},
                                          odontologo: {id: document.querySelector('#id_odontologo').value}
                                           }

                         const url = '/turnos/registrar';
                         const settings = {
                                      method: 'POST',
                                      headers: {
                                                'Content-Type': 'application/json',
                                                },
                                       body: JSON.stringify(formData)
                                        }
                         fetch(url,settings)
                         .then(response => response.json())
                         .then(dataTurno =>{
                                    //Si no hay ningun error se muestra un mensaje diciendo que el turno se agrego bien
                                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                                       '<i class="bi bi-hand-thumbs-up me-1"></i>' +
                                                        '<strong>Turno agregado</strong>'+
                                                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                                         '</div>'

                                    document.querySelector('#response').innerHTML = successAlert;
                                    document.querySelector('#response').style.display = "block";
                                    resetUploadFormTurno();
                                     })
                         .catch(error => {
                                   //Si hay algun error se muestra un mensaje diciendo que el turno
                                   //no se pudo guardar y se intente nuevamente
                                   let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                                     '<i class="bi bi-hand-thumbs-down me-1"></i>' +
                                                     '<strong> Error intente nuevamente</strong>'+
                                                      '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                                      ' </div>'

                                   document.querySelector('#response').innerHTML = errorAlert;
                                   document.querySelector('#response').style.display = "block";
                                     //se dejan todos los campos vacíos por si se quiere ingresar otro turno
                                       resetUploadFormTurno();
                                   })

                      })
    })
    })