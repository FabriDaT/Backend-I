
window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del paciente
    const formulario = document.getElementById('update_paciente_form');
    formulario.addEventListener('submit', function (event) {
        let pacienteId = document.getElementById('paciente_id').value;

        //creamos un JSON que tendrá los datos del paciente
        //a diferencia de un paciente nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id_paciente: document.querySelector('#paciente_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            dni: document.querySelector('#DNI').value,
            id_domicilio: document.querySelector('#domicilio_id').value,
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value
        };

        //invocamos utilizando la función fetch la API pacientes con el método PUT
        //que modificará al paciente que enviaremos en formato JSON

        const url = '/pacientes/'+pacienteId;
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
              })
           })



          function findBy(id) {
                                            const url = '/pacientes'+"/"+id;
                                            const settings = {
                                                method: 'GET'
                                            }
                                            fetch(url,settings)
                                            .then(response => response.json())
                                            .then(data => {
                                                let pac = data;
                                                document.querySelector('#paciente_id').value = pac.id;
                                                document.querySelector('#nombre').value = pac.nombre;
                                                document.querySelector('#apellido').value = pac.apellido;
                                                document.querySelector('#DNI').value = pac.dni;
                                                document.querySelector('#domicilio_id').value = pac.id_domicilio;
                                                document.querySelector('#calle').value = pac.calle;
                                                document.querySelector('#numero').value = pac.numero;
                                                document.querySelector('#localidad').value = pac.localidad;
                                                document.querySelector('#provincia').value = pac.provincia;


                                              //el formulario por default esta oculto y al editar se habilita
                                                document.querySelector('#div_paciente_updating').style.display = "block";
                                            }).catch(error => {
                                            alert("Error: " + error);
                                            })
                                     }




