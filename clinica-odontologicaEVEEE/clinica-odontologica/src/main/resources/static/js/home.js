window.addEventListener('load', function(){

    const btnInicio = document.querySelector('#btn-inicio');
    const sectionInicio = document.querySelector('.box-section')
    const nameSection = document.querySelector('.h1')
    sectionInicio.classList.add("text-center")
    nameSection.innerHTML = "Bienvenido"
    sectionInicio.innerHTML = `<img class="img-fluid" src="./img/img-home.png" alt="imagen-banner-portada"></img>`
    const btnModal = document.getElementById('btn-modal')


    btnInicio.addEventListener('click', function(){
        btnModal.classList.add("d-none");
        const sectionInicio = document.querySelector('.box-section')
        const nameSection = document.querySelector('.h1')
        sectionInicio.classList.add("text-center")
        nameSection.innerHTML = "Bienvenido"
        sectionInicio.innerHTML = `<img class="img-fluid" src="./img/img-home.png" alt="imagen-banner-portada"></img>`
    })
})