window.addEventListener('load', function () {

    const btnPacientes = document.querySelector('#btn-pacientes')

    btnPacientes.addEventListener('click', function(){

        const sectionPacientes = document.querySelector('.box-section')
        const btnModal = document.getElementById('btn-modal')
        btnModal.classList.remove("d-none");
        btnModal.dataset.bsTarget = "#modal-paciente";
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
    })

    const btnTurnos = document.querySelector('#btn-turnos')
    btnTurnos.addEventListener('click', function(){
        const sectionTurnos = document.querySelector('.box-section')
        const btnModal = document.getElementById('btn-modal')
        //Modal para agregar turno
                var modalAgregarHTML = `<div class="modal fade" id="modal-turno" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                         <div class="modal-dialog modal-dialog-centered">
                                             <div class="modal-content">
                                                 <div class="modal-header">
                                                     <h1 class="fs-5" id="exampleModalLabel">Nuevo Turno</h1>
                                                     <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                 </div>
                                                 <div class="modal-body">
                                                     <form class="add_new_turno">
                                                             <div class="input-group mb-3">
                                                               <span class="input-group-text">Id Paciente</span>
                                                               <input id="id_paciente" type="number" class="form-control" placeholder="Ingrese id del paciente" aria-label="Paciente" aria-describedby="paciente">
                                                             </div>
                                                             <div class="input-group mb-3">
                                                                <span class="input-group-text" >Id Odontologo</span>
                                                                <input id="id_odontologo" type="text" class="form-control" placeholder="Ingrese id del odontologo" aria-label="Odontologo" aria-describedby="odontologo">
                                                             </div>
                                                             <div class="input-group mb-3">
                                                               <span class="input-group-text">Fecha y Hora</span>
                                                                <input id="fecha_hora" type="datetime-local" >
                                                             </div>

                                                         <button type="submit" class="btn btn-success" id="btn-add-new-turno">Agregar</button>
                                                     </form>
                                                     <div id="response" style="display:none; margin-top:10px">
                                                     </div>
                                                 </div>
                                             </div>
                                         </div>
                                     </div>`

                // Insertar el modal para agregar turno después del botón
                btnModal.insertAdjacentHTML("afterend", modalAgregarHTML);

                // Obtener la referencia al modal recién creado
                var miModalAgregar = document.getElementById("modal-turno");

                // Inicializar el modal
                var modalA = new bootstrap.Modal(miModalAgregar);

                //Modal para actualizar turno
                var modalUpdateHTML = `<div class="modal fade" id="modal-update-turno" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered">
                                                  <div class="modal-content">
                                                        <div class="modal-header">
                                                             <h1 class="fs-5" id="exampleModalLabel">Turno</h1>
                                                             <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div class="modal-body">
                                                             <form id="update_turno-form">
                                                                <div class="input-group mb-3">
                                                                    <span class="input-group-text">Id</span>
                                                                    <input id="turno_id" type="number" class="form-control" placeholder="id" aria-label="Id" aria-describedby="id" disabled>
                                                                 </div>
                                                                  <div class="input-group mb-3">
                                                                       <span class="input-group-text">Paciente</span>
                                                                        <input id="paciente_update" type="number" class="form-control" aria-label="Paciente" aria-describedby="paciente" disabled>
                                                                  </div>
                                                                   <div class="input-group mb-3">
                                                                         <span class="input-group-text" >Odontologo</span>
                                                                          <input id="odontologo_update" type="number" class="form-control" aria-label="Odontologo" aria-describedby="odontologo">
                                                                   </div>
                                                                     <div class="input-group mb-3">
                                                                          <span class="input-group-text">Fecha y Hora</span>
                                                                          <input id="fecha_hora_update" type="datetime-local" >
                                                                      </div>
                                                                     <button type="submit" class="btn btn-success" id="btn-update-paciente">Modificar</button>
                                                                </form>
                                                                <div id="responseUpdate" style="display:none; margin-top:10px">
                                                                </div>
                                                        </div>
                                                  </div>
                                            </div>
                                       </div>`


                sectionTurnos.insertAdjacentHTML("afterend", modalUpdateHTML);

                var miModalUpdate = document.getElementById("modal-update-turno");

                // Inicializar el modal update turno
                var modalU = new bootstrap.Modal(miModalUpdate);

    })

})