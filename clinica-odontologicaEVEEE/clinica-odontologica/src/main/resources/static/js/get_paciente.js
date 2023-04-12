function findPacienteByDni(dni){
        let idPaciente = null;
        const url = '/pacientes/dni'+"/"+dni;

                      const settings = {
                          method: 'GET'
                      }
                      fetch(url,settings)
                      .then(response => response.json())
                      .then(data => {
                          let paciente = data;
                         console.log(paciente);
                         return paciente;
                      }).catch(error => {
                          alert("Error: " + error);
                      })


}