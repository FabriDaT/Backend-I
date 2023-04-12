window.addEventListener('load', function () {

    const btnOdontologos = document.querySelector('#btn-odontologos')

    btnOdontologos.addEventListener('click', function(){

        const sectionOdontologos = document.querySelector('.box-section')

        const btnModal = document.getElementById('btn-modal')
        btnModal.classList.remove("d-none");
        btnModal.dataset.bsTarget = "#modal-odontologo"

        const nameSection = document.querySelector('.h1')
        nameSection.innerHTML = "Odontologos"

        var modalAgregarHTML = `<div class="modal fade" id="modal-odontologo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                         <div class="modal-dialog modal-dialog-centered">
                             <div class="modal-content">
                                 <div class="modal-header">
                                     <h1 class="fs-5" id="exampleModalLabel">Nuevo Odontologo</h1>
                                     <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                 </div>
                                 <div class="modal-body">
                                     <form class="add_new_odontologo">
                                             <div class="input-group mb-3">
                                               <span class="input-group-text">Nombre</span>
                                               <input id="nombre" type="text" class="form-control" placeholder="Ingrese el nombre" aria-label="Nombre" aria-describedby="nombre">
                                             </div>
                                             <div class="input-group mb-3">
                                                <span class="input-group-text" >Apellido</span>
                                                <input id="apellido" type="text" class="form-control" placeholder="Ingrese el apellido" aria-label="Apellido" aria-describedby="apellido">
                                             </div>
                                             <div class="input-group mb-3">
                                               <span class="input-group-text">Matricula</span>
                                               <input id="matricula" type="text" class="form-control" placeholder="Ingrese la matricula" aria-label="Matricula" aria-describedby="matricula">
                                             </div>

                                         <button type="submit" class="btn btn-success" id="btn-add-new-odontologo">Agregar</button>
                                     </form>
                                     <div id="response" style="display:none; margin-top:10px">
                                     </div>
                                 </div>
                             </div>
                         </div>
                     </div>`


         // Insertar el modal después del botón
         btnModal.insertAdjacentHTML("afterend", modalAgregarHTML);

         // Obtener la referencia al modal recién creado
         var miModalAgregar = document.getElementById("modal-odontologo");

         // Inicializar el modal
         var modalA = new bootstrap.Modal(miModalAgregar);

         var modalUpdateHTML = `<div class="modal fade" id="modal-update-odontologo" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered">
                                                 <div class="modal-content">
                                                      <div class="modal-header">
                                                             <h1 class="fs-5" id="exampleModalLabel">Odontologo</h1>
                                                              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                       </div>
                                                        <div class="modal-body">
                                                            <form id="update_odontologo-form">
                                                             <div class="input-group mb-3">
                                                                 <span class="input-group-text">Id</span>
                                                                  <input id="odontologo_id" type="text" class="form-control" placeholder="id" aria-label="Id" aria-describedby="id" disabled>
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
                                                                       <span class="input-group-text">Matricula</span>
                                                                        <input id="matricula_update" type="text" class="form-control" placeholder="Ingrese la matricula" aria-label="Matricula" aria-describedby="matricula">
                                                                  </div>

                                                                  <button type="submit" class="btn btn-success" id="btn-update-odontologo">Modificar</button>
                                                            </form>
                                                            <div id="responseUpdate" style="display:none; margin-top:10px">
                                                            </div>
                                                        </div>
                                                 </div>
                                             </div>
                                          </div>`



         sectionOdontologos.insertAdjacentHTML("afterend", modalUpdateHTML);

         var miModalUpdate = document.getElementById("modal-update-odontologo");

         // Inicializar el modal update odontologo
         var modalU = new bootstrap.Modal(miModalUpdate);

         const formularioUpdate = document.querySelector('#update_odontologo-form');
         formularioUpdate.addEventListener('submit', function (event) {
            event.preventDefault();
             let odontologoId = document.querySelector('#odontologo_id').value;

                 const formData = {
                     id: document.querySelector('#odontologo_id').value,
                     apellido: document.querySelector('#apellido_update').value,
                     nombre: document.querySelector('#nombre_update').value,
                     matricula: document.querySelector('#matricula_update').value
                 };


                 const url = '/odontologos'+"/"+odontologoId;
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
                                              //Si no hay ningun error se muestra un mensaje diciendo que el odontologo se agrego bien
                                              let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                                  '<i class="bi bi-hand-thumbs-up me-1"></i>' +
                                                  '<strong>Odontologo actualizado</strong> '+
                                                   '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                                   '</div>'

                                              document.querySelector('#responseUpdate').innerHTML = successAlert;
                                              document.querySelector('#responseUpdate').style.display = "block";

                                              document.querySelector('.odontologoTable').innerHTML = "";
                                              tableOdontologos();
                                              getOdontologos();
                   })
                   .catch(error => {
                                                 //Si hay algun error se muestra un mensaje diciendo que el odontologo
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

      tableOdontologos();

      getOdontologos();

      const formulario = document.querySelector('.add_new_odontologo');

              //Ante un submit del formulario se ejecutará la siguiente funcion
              formulario.addEventListener('submit', function (event) {
                    event.preventDefault();
                 //creamos un JSON que tendrá los datos del nuevo odontologo
                  const formData = {
                      nombre: document.querySelector('#nombre').value,
                      apellido: document.querySelector('#apellido').value,
                      matricula: document.querySelector('#matricula').value,

                  };
                  //invocamos utilizando la función fetch la API odontologos con el método POST que guardará
                  //el odontologo que enviaremos en formato JSON
                  const url = '/odontologos/registrar';
                  const settings = {
                      method: 'POST',
                      headers: {
                          'Content-Type': 'application/json',
                      },
                      body: JSON.stringify(formData)
                  }

                  fetch(url, settings)
                      .then(response => response.json())
                      .then(data => {
                           //Si no hay ningun error se muestra un mensaje diciendo que el odontologo se agrego bien
                           let successAlert = '<div class="alert alert-success alert-dismissible">' +
                               '<i class="bi bi-hand-thumbs-up me-1"></i>' +
                               '<strong>Odontologo agregado</strong>'+
                               '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                               '</div>'

                           document.querySelector('#response').innerHTML = successAlert;
                           document.querySelector('#response').style.display = "block";

                           resetUploadForm();
                      })
                      .catch(error => {
                              //Si hay algun error se muestra un mensaje diciendo que el odontologo
                              //no se pudo guardar y se intente nuevamente
                              let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                               '<i class="bi bi-hand-thumbs-down me-1"></i>' +
                                               '<strong> Error intente nuevamente</strong>'+
                                                '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close">'+
                                               ' </div>'

                                document.querySelector('#response').innerHTML = errorAlert;
                                document.querySelector('#response').style.display = "block";
                               //se dejan todos los campos vacíos por si se quiere ingresar otro odontologo
                               resetUploadForm();
                               })
              })


              function resetUploadForm(){
                  document.querySelector('#nombre').value = "";
                  document.querySelector('#apellido').value = "";
                  document.querySelector('#matricula').value = "";
                  document.querySelector('#odontologoTableBody').innerHTML = "";
                  getOdontologos();
                  tableOdontologos();
              }


    function tableOdontologos(){
      sectionOdontologos.innerHTML = `<table class="table table-striped table-sm odontologoTable">
            <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Apellido</th>
                  <th scope="col">Nombre</th>
                  <th scope="col">Matricula</th>
                  <th scope="col">Eliminar</th>
                  <th scope="col">Modificar</th>
                </tr>
              </thead>
              <tbody id="odontologoTableBody">

              </tbody>
            </table>`
    }

    })



    })

    function findOdontologoBy(id) {
                  const url = '/odontologos'+"/"+id;
                  const settings = {
                      method: 'GET'
                  }
                  fetch(url,settings)
                  .then(response => response.json())
                  .then(data => {
                      let odontologo = data;
                      document.querySelector('#odontologo_id').value = odontologo.id;
                      document.querySelector('#nombre_update').value = odontologo.nombre;
                      document.querySelector('#apellido_update').value = odontologo.apellido;
                      document.querySelector('#matricula_update').value = odontologo.matricula;

                  }).catch(error => {
                      alert("Error: " + error);
                  })
           }

           function deleteOdontologoBy(id)
                  {
                             //con fetch invocamos a la API de odontologos con el método DELETE
                             //pasandole el id en la URL
                            if (confirm("¿Está seguro de que desea eliminar al odontologo?")) {
                              // Código que se ejecutará si el usuario hace clic en "Aceptar"
                               const url = '/odontologos/'+ id;
                                        const settings = {
                                            method: 'DELETE'
                                        }
                                        fetch(url,settings)
                                        .then(response => console.log(response.json()))

                                        //borrar la fila del odontologo eliminado
                                        let row_id = "#tr_" + id;
                                        document.querySelector(row_id).remove();
                            } else {
                              // Código que se ejecutará si el usuario hace clic en "Cancelar"
                              history.back();
                            }



                  }

function getOdontologos(){
      //con fetch invocamos a la API de odontologos con el método GET
          //nos devolverá un JSON con una colección de odontologos
          const url = '/odontologos';
          const settings = {
            method: 'GET'
          }

          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
            //recorremos la colección de odontologos del JSON
               for(odontologo of data){
                  //por cada odontologo armaremos una fila de la tabla
                  //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos el odontologo
                  var table = document.querySelector(".odontologoTable");
                  var odontologoRow =table.insertRow();
                  let tr_id = 'tr_' + odontologo.id;
                  odontologoRow.id = tr_id;

                  //por cada odontologo un boton delete que agregaremos en cada fila para poder eliminar el mismo
                  //dicho boton invocara a la funcion de java script deleteByKey que se encargará
                  //de llamar a la API para eliminar un odontologo
                  let deleteButton = '<button' +
                                            ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
                                            ' type="button" onclick="deleteOdontologoBy('+odontologo.id+')" class="btn btn-danger btn_delete">' +
                                           '<i class="bi bi-trash3"></i>' +
                                            '</button>';

                  //por cada odontologo un boton y que al hacerle clic invocará
                  //a la función de java script findBy que se encargará de buscar el odontologo que queremos
                  //modificar y mostrar los datos del mismo en un formulario.
                  let updateButton = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
                                            ' type="button" onclick="findOdontologoBy('+odontologo.id+')" class="btn btn-secondary btn_id" data-bs-toggle="modal" data-bs-target="#modal-update-odontologo">' +
                                            '<i class="bi bi-pencil-square"></i>'  +
                                            '</button>';

                  //armamos cada columna de la fila
                  odontologoRow.innerHTML =
                          '<td class=\"td_id\">' + odontologo.id + '</td>' +
                          '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                          '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                          '<td class=\"td_matricula\">' + odontologo.matricula.toUpperCase() + '</td>' +
                          '<td>' + deleteButton + '</td>'+
                          '<td>' + updateButton + '</td>';

              }})

    }
