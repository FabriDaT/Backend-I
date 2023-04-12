window.addEventListener('load', function () {

    const btnPacientes = document.querySelector('#btn-pacientes')

    btnPacientes.addEventListener('click', function(){

      const formulario = document.querySelector('.add_new_paciente');


              //Ante un submit del formulario se ejecutará la siguiente funcion
              formulario.addEventListener('submit', function (event) {
                         event.preventDefault();
                         const formData = {
                                          nombre: document.querySelector('#nombre').value,
                                          apellido: document.querySelector('#apellido').value,
                                          email: document.querySelector('#email').value,
                                          dni: document.querySelector('#dni').value,
                                          fecha_ingreso: document.querySelector('#fecha_ingreso').value,
                                          domicilio: {
                                                      calle: document.querySelector('#calle').value,
                                                      numero: document.querySelector('#numero').value,
                                                      localidad: document.querySelector('#localidad').value,
                                                      provincia: document.querySelector('#provincia').value,
                                                    }
                                           }

                         const url = '/pacientes/registrar';
                         const settings = {
                                      method: 'POST',
                                      headers: {
                                                'Content-Type': 'application/json',
                                                },
                                       body: JSON.stringify(formData)
                                        }
                         fetch(url,settings)
                         .then(response => response.json())
                         .then(dataPaciente =>{
                                    //Si no hay ningun error se muestra un mensaje diciendo que el paciente se agrego bien
                                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                                       '<i class="bi bi-hand-thumbs-up me-1"></i>' +
                                                        '<strong>Paciente agregado</strong>'+
                                                        '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                                         '</div>'

                                    document.querySelector('#response').innerHTML = successAlert;
                                    document.querySelector('#response').style.display = "block";
                                    document.querySelector('#pacienteTableBody').innerHTML = "";
                                    resetUploadForm();
                                     })
                         .catch(error => {
                                   //Si hay algun error se muestra un mensaje diciendo que el paciente
                                   //no se pudo guardar y se intente nuevamente
                                   let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                                     '<i class="bi bi-hand-thumbs-down me-1"></i>' +
                                                     '<strong> Error intente nuevamente</strong>'+
                                                      '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                                      ' </div>'

                                   document.querySelector('#response').innerHTML = errorAlert;
                                   document.querySelector('#response').style.display = "block";
                                     //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                                      resetUploadForm();
                                   })

                      })
    })
    })