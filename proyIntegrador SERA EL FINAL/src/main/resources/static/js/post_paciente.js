window.addEventListener('load', (event)=>{

    const formulario = document.getElementById('form-agregar');

    formulario.addEventListener('submit', function(event){

           //creamos un JSON que tendrá los datos del nuevo paciente
           const formData = {
            nombre: document.getElementById('nombre').value,
            apellido: document.getElementById('apellido').value,
            DNI: document.getElementById('DNI').value,
            domicilio : {
               calle:document.getElementById('calle').value,
               numero:document.getElementById('numero').value,
               localidad:document.getElementById('localidad').value,
               provincia: document.getElementById('provincia').value
            }
        };


        const url = '/pacientes/registrar'
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
        console.log('antes del fetch')
        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
               //Si no hay ningun error se muestra un mensaje diciendo que el paciente
               //se agrego bien
                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                     '<strong></strong> Paciente agregado </div>'

                 document.querySelector('#response').innerHTML = successAlert;
                 document.querySelector('#response').style.display = "block";
                 //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                 resetUploadForm();

            })
            .catch(error => {
                 //Si hay algun error se muestra un mensaje diciendo que el paciente
                 //no se pudo guardar y se intente nuevamente
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   //se dejan todos los campos vacíos por si se quiere ingresar otro paciente
                   resetUploadForm();})
    });

    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#DNI').value = "";
        document.querySelector('#calle').value="";
        document.querySelector('#numero').value="";
        document.querySelector('#localidad').value="";
        document.querySelector('#provincia').value="";
    }

})





