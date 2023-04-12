function findOdontologoByMatricula(matricula){
        let idOdontologo = null;
        const url = '/odontologos/mat'+"/"+matricula;
                      const settings = {
                          method: 'GET'
                      }
                      fetch(url,settings)
                      .then(response => response.json())
                      .then(data => {
                          let odontologo = data;
                          console.log(odontologo);
                          return odontologo;
                      }).catch(error => {
                          alert("Error: " + error);
                      })
}