function findTurnoBy(id) {
                  const url = '/turnos'+"/"+id;

                  const settings = {
                      method: 'GET'
                  }

                  fetch(url,settings)
                  .then(response => response.json())
                  .then(data => {
                      let turno = data;
                      document.querySelector('#turno_id').value = turno.id;
                      document.querySelector('#paciente_update').value = turno.paciente.id;
                      document.querySelector('#odontologo_update').value = turno.odontologo.id;
                      document.querySelector('#fecha_hora_update').setAttribute('value', turno.fecha_hora) ;

                  }).catch(error => {
                      alert("Error: " + error);
                  })
}