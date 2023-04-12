          function deletePacienteBy(id)
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