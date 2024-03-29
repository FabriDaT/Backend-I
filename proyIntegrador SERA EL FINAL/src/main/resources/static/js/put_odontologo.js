
window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del odontologo
    const formulario = document.getElementById('update_odontologo_form');
    formulario.addEventListener('submit', function (event) {
        let odontologoId = document.getElementById('odontologo_id').value;

        //creamos un JSON que tendrá los datos del odont
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#odontologo_id').value,
            nombre: document.querySelector('#nombre').value,
            apellido: document.querySelector('#apellido').value,
            matricula: document.querySelector('#matricula').value,

        };

        //invocamos utilizando la función fetch la API odontologos con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON

        const url = '/odontologos/'+odontologoId;
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
                                            const url = '/odontologos'+"/"+id;
                                            const settings = {
                                                method: 'GET'
                                            }
                                            fetch(url,settings)
                                            .then(response => response.json())
                                            .then(data => {
                                                let odont = data;
                                                document.querySelector('#odontologo_id').value = odont.id;
                                                document.querySelector('#nombre').value = odont.nombre;
                                                document.querySelector('#apellido').value = odont.apellido;
                                                document.querySelector('#matricula').value = odont.matricula;


                                              //el formulario por default esta oculto y al editar se habilita
                                                document.querySelector('#div_odontologo_updating').style.display = "block";
                                            }).catch(error => {
                                            alert("Error: " + error);
                                            })
                                     }




