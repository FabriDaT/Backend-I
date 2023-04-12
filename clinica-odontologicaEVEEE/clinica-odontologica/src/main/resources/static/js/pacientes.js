window.addEventListener('load', function () {

    const btnPacientes = document.querySelector('#btn-pacientes')

    btnPacientes.addEventListener('click', function(){

      /*  const sectionPacientes = document.querySelector('.box-section')

        const btnModal = document.getElementById('btn-modal')
        btnModal.classList.remove("d-none");
        btnModal.dataset.bsTarget = "#modal-paciente"

        const nameSection = document.querySelector('.h1')
        nameSection.innerHTML = "Pacientes"

        //Modal para agregar paciente
        var modalAgregarHTML = `<div class="modal fade" id="modal-paciente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                         <div class="modal-dialog modal-dialog-centered">
                             <div class="modal-content">
                                 <div class="modal-header">
                                     <h1 class="fs-5" id="exampleModalLabel">Nuevo Paciente</h1>
                                     <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                 </div>
                                 <div class="modal-body">
                                     <form class="add_new_paciente">
                                             <div class="input-group mb-3">
                                               <span class="input-group-text">Nombre</span>
                                               <input id="nombre" type="text" class="form-control" placeholder="Ingrese el nombre" aria-label="Nombre" aria-describedby="nombre">
                                             </div>
                                             <div class="input-group mb-3">
                                                <span class="input-group-text" >Apellido</span>
                                                <input id="apellido" type="text" class="form-control" placeholder="Ingrese el apellido" aria-label="Apellido" aria-describedby="apellido">
                                             </div>
                                             <div class="input-group mb-3">
                                               <span class="input-group-text">Email</span>
                                                <input type="email" class="form-control" id="email" placeholder="nombre@example.com" aria-label="Email" aria-describedby="email">
                                             </div>
                                              <div class="input-group mb-3">
                                                  <span class="input-group-text">DNI</span>
                                                  <input type="number" class="form-control" id="dni" placeholder="ingrese dni sin puntos" aria-label="Dni" aria-describedby="dni">
                                              </div>
                                                <div class="input-group mb-3">
                                                  <span class="input-group-text">Fecha de Ingreso</span>
                                                   <input type="date" class="form-control" id="fecha_ingreso" name="trip-start">
                                                </div>
                                                <div class="input-group mb-3">
                                                    <span class="input-group-text">Provincia</span>
                                                    <input type="text" class="form-control" id="provincia">
                                                  </div>
                                                  <div class="input-group mb-3">
                                                    <span class="input-group-text">Localidad</span>
                                                    <input type="text" class="form-control" id="localidad">
                                                  </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text">Calle</span>
                                                        <input type="text" class="form-control" id="calle">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text">Numero</span>
                                                        <input type="number" class="form-control" id="numero">
                                                    </div>
                                         <button type="submit" class="btn btn-success" id="btn-add-new-paciente">Agregar</button>
                                     </form>
                                     <div id="response" style="display:none; margin-top:10px">
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>`


         // Insertar el modal para agregar paciente después del botón
         btnModal.insertAdjacentHTML("afterend", modalAgregarHTML);

         // Obtener la referencia al modal recién creado
         var miModalAgregar = document.getElementById("modal-paciente");

         // Inicializar el modal
         var modalA = new bootstrap.Modal(miModalAgregar);

         //Modal para actualizar paciente
         var modalUpdateHTML = `<div class="modal fade" id="modal-update-paciente" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered">
                                                 <div class="modal-content">
                                                      <div class="modal-header">
                                                             <h1 class="fs-5" id="exampleModalLabel">Paciente</h1>
                                                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                       </div>
                                                        <div class="modal-body">
                                                            <form id="update_paciente-form">
                                                             <div class="input-group mb-3">
                                                                 <span class="input-group-text">Id</span>
                                                                  <input id="paciente_id" type="text" class="form-control" placeholder="id" aria-label="Id" aria-describedby="id" disabled>
                                                             </div>
                                                                 <div class="input-group mb-3">
                                                                        <span class="input-group-text">Nombre</span>
                                                                         <input id="nombre_update" type="text" class="form-control" placeholder="Ingrese el nombre" aria-label="Nombre" aria-describedby="nombre">
                                                                 </div>
                                                                  <div class="input-group mb-3">
                                                                        <span class="input-group-text" >Apellido</span>
                                                                         <input id="apellido_update" type="text" class="form-control" placeholder="Ingrese el apellido" aria-label="Apellido" aria-describedby="apellido">
                                                                  </div>
                                                    <div class="input-group mb-3">
                                               <span class="input-group-text">Email</span>
                                                <input type="email" class="form-control" id="email_update" placeholder="nombre@example.com" aria-label="Email" aria-describedby="email">
                                             </div>
                                              <div class="input-group mb-3">
                                                  <span class="input-group-text">DNI</span>
                                                  <input type="number" class="form-control" id="dni_update" placeholder="ingrese dni sin puntos" aria-label="Dni" aria-describedby="dni">
                                              </div>
                                                <div class="input-group mb-3">
                                                  <span class="input-group-text">Fecha de Ingreso</span>
                                                   <input type="date" class="form-control" id="fecha_ingreso_update" name="trip-start">
                                                </div>
                                                <div class="input-group mb-3">
                                                    <span class="input-group-text">Provincia</span>
                                                    <input type="text" class="form-control" id="provincia_update">
                                                  </div>
                                                  <div class="input-group mb-3">
                                                    <span class="input-group-text">Localidad</span>
                                                    <input type="text" class="form-control" id="localidad_update">
                                                  </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text">Calle</span>
                                                        <input type="text" class="form-control" id="calle_update">
                                                    </div>
                                                    <div class="input-group mb-3">
                                                        <span class="input-group-text">Numero</span>
                                                        <input type="number" class="form-control" id="numero_update">
                                                    </div>

                                                                  <button type="submit" class="btn btn-success" id="btn-update-paciente">Modificar</button>
                                                            </form>
                                                            <div id="responseUpdate" style="display:none; margin-top:10px">
                                                            </div>
                                                        </div>
                                                 </div>
                                             </div>
                                          </div>`



         sectionPacientes.insertAdjacentHTML("afterend", modalUpdateHTML);

         var miModalUpdate = document.getElementById("modal-update-paciente");

         // Inicializar el modal update paciente
         var modalU = new bootstrap.Modal(miModalUpdate);
         */
        /* const formularioUpdate = document.querySelector('#update_paciente-form');

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


             });*/

      tablePacientes();

      getPacientes();

      /*const formulario = document.querySelector('.add_new_paciente');


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
                                    document.querySelector('.pacienteTable').innerHTML = "";
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

                      })*/



            /*  function resetUploadForm(){
                  document.querySelector('#nombre').value = "";
                  document.querySelector('#apellido').value = "";
                  document.querySelector('#email').value = "";
                  document.querySelector('#dni').value = "";
                  document.querySelector('#fecha_ingreso').value = "";
                  document.querySelector('#calle').value = "";
                  document.querySelector('#numero').value = "";
                  document.querySelector('#localidad').value = "";
                  document.querySelector('#provincia').value = "";
                  getPacientes();
              }*/


    /*function tablePacientes(){
      sectionPacientes.innerHTML = `<table class="table table-striped table-sm pacienteTable">
            <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Apellido</th>
                  <th scope="col">Nombre</th>
                  <th scope="col">Email</th>
                  <th scope="col">Dni</th>
                  <th scope="col">Ingreso</th>
                  <th scope="col">Calle</th>
                  <th scope="col">Numero</th>
                  <th scope="col">Localidad</th>
                  <th scope="col">Provincia</th>
                  <th scope="col"></th>
                  <th scope="col"></th>
                </tr>
              </thead>
              <tbody id="pacienteTableBody">

              </tbody>
            </table>`
    }*/


    })

    })


    function findPacienteBy(id) {
                  const url = '/pacientes'+"/"+id;
                  const settings = {
                      method: 'GET'
                  }
                  fetch(url,settings)
                  .then(response => response.json())
                  .then(data => {
                      let paciente = data;
                      document.querySelector('#paciente_id').value = paciente.id;
                      document.querySelector('#nombre_update').value = paciente.nombre;
                      document.querySelector('#apellido_update').value = paciente.apellido;
                      document.querySelector('#email_update').value = paciente.email;
                      document.querySelector('#dni_update').value = paciente.dni;
                      document.querySelector('#fecha_ingreso_update').value = paciente.fecha_ingreso;
                      document.querySelector('#provincia_update').value = paciente.domicilio.provincia;
                      document.querySelector('#localidad_update').value = paciente.domicilio.localidad;
                      document.querySelector('#calle_update').value = paciente.domicilio.calle;
                      document.querySelector('#numero_update').value = paciente.domicilio.numero;
                  }).catch(error => {
                      alert("Error: " + error);
                  })
           }

        /*   function deletePacienteBy(id)
                  {
                             //con fetch invocamos a la API de pacientes con el método DELETE
                             //pasandole el id en la URL
                            if (confirm("¿Está seguro de que desea eliminar al paciente?")) {
                              // Código que se ejecutará si el usuario hace clic en "Aceptar"
                               const url = '/pacientes/'+ id;
                                        const settings = {
                                            method: 'DELETE'
                                        }
                                        fetch(url,settings)
                                        .then(response => response.json())

                                        //borrar la fila del paciente eliminado
                                        let row_id = "#tr_" + id;
                                        document.querySelector(row_id).remove();
                            } else {
                              // Código que se ejecutará si el usuario hace clic en "Cancelar"
                              history.back();
                            }



                  }
*/
                  function resetUploadForm(){
                      document.querySelector('#nombre').value = "";
                      document.querySelector('#apellido').value = "";
                      document.querySelector('#email').value = "";
                      document.querySelector('#dni').value = "";
                      document.querySelector('#fecha_ingreso').value = "";
                      document.querySelector('#calle').value = "";
                      document.querySelector('#numero').value = "";
                      document.querySelector('#localidad').value = "";
                      document.querySelector('#provincia').value = "";
                      getPacientes();
                      tablePacientes();
                  }

  function getPacientes(){

                      const url = '/pacientes';
                      const settings = {
                        method: 'GET'
                      }

                      fetch(url,settings)
                      .then(response => response.json())
                      .then(data => {
                        //recorremos la colección de pacientes del JSON
                           for(paciente of data){
                              //por cada paciente armo una fila de la tabla
                              var table = document.querySelector(".pacienteTable");
                              var pacienteRow =table.insertRow();
                              let tr_id = 'tr_' + paciente.id;
                              pacienteRow.id = tr_id;

                              //por cada paciente un boton delete que agregaremos en cada fila para poder eliminar el mismo
                              //dicho boton invocara a la funcion de java script deleteByKey que se encargará
                              //de llamar a la API para eliminar un paciente
                              let deleteButton = '<button' +
                                                        ' id=' + '\"' + 'btn_delete_' + paciente.id + '\"' +
                                                        ' type="button" onclick="deletePacienteBy('+paciente.id+')" class="btn btn-danger btn_delete">' +
                                                        '<i class="bi bi-trash3"></i>' +
                                                        '</button>';

                              //por cada paciente un boton y que al hacerle clic invocará
                              //a la función de java script findBy que se encargará de buscar el paciente que queremos
                              //modificar y mostrar los datos del mismo en un formulario.
                              let updateButton = '<button' +
                                                        ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' +
                                                        ' type="button" onclick="findPacienteBy('+paciente.id+')" class="btn btn-secondary btn_id" data-bs-toggle="modal" data-bs-target="#modal-update-paciente">' +
                                                        '<i class="bi bi-pencil-square"></i>' +
                                                        '</button>';


                              //armamos cada columna de la fila
                              pacienteRow.innerHTML =
                                      '<td class=\"td_id\">' + paciente.id + '</td>' +
                                      '<td class=\"td_apellido\">' + paciente.apellido.toUpperCase() + '</td>' +
                                      '<td class=\"td_nombre\">' + paciente.nombre.toUpperCase() + '</td>' +
                                      '<td class=\"td_email\">' +paciente.email.toUpperCase() + '</td>' +
                                      '<td class=\"td_dni\">' +paciente.dni + '</td>' +
                                      '<td class=\"td_fecha_ingreso\">' +paciente.fecha_ingreso + '</td>' +
                                      '<td class=\"td_calle\">' +paciente.domicilio.calle.toUpperCase() + '</td>' +
                                      '<td class=\"td_numero\">' +paciente.domicilio.numero + '</td>' +
                                       '<td class=\"td_localidad\">' +paciente.domicilio.localidad.toUpperCase() + '</td>' +
                                       '<td class=\"td_provincia\">' +paciente.domicilio.provincia.toUpperCase() + '</td>' +
                                      '<td>' + deleteButton + '</td>'+
                                      '<td>' + updateButton + '</td>';

                          }})

                }

  function tablePacientes(){
      const sectionPacientes = document.querySelector('.box-section')
      sectionPacientes.innerHTML = `<table class="table table-striped table-sm pacienteTable">
            <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Apellido</th>
                  <th scope="col">Nombre</th>
                  <th scope="col">Email</th>
                  <th scope="col">Dni</th>
                  <th scope="col">Ingreso</th>
                  <th scope="col">Calle</th>
                  <th scope="col">Numero</th>
                  <th scope="col">Localidad</th>
                  <th scope="col">Provincia</th>
                  <th scope="col">Eliminar</th>
                  <th scope="col">Modificar</th>
                </tr>
              </thead>
              <tbody id="pacienteTableBody">

              </tbody>
            </table>`
    }

