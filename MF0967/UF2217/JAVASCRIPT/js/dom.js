'use strict';

// const bdd = [
//     { id: 1, nombre: 'Javier' },
//     { id: 2, nombre: 'Pepe' },
//     { id: 3, nombre: 'Prueba' },
// ];

window.addEventListener('DOMContentLoaded', async function() {
    console.log('DOMContentLoaded');
    
    const h1 = document.querySelector('h1');

    console.log(h1);

    console.log(h1.innerHTML);

    h1.innerText = 'Modificado desde JavaScript';

    const p = document.querySelector('p');

    p.style.display = 'none';

    const form = document.querySelector('form');

    form.addEventListener('submit', (evento) => {
        evento.preventDefault();

        const inputNombre = document.getElementById('nombre');
        const spanSaludo = document.getElementById('saludo');

        console.log(inputNombre);
        console.log(spanSaludo);

        spanSaludo.innerText = 'Hola ' + inputNombre.value;
    });

    const respuesta = await fetch('http://localhost:3000/personas');

    console.log(respuesta);

    const bdd = await respuesta.json();

    console.log(bdd);
    
    let ul = document.getElementById('lista');

    let li;

    for(let fila of bdd) {
        li = document.createElement('li'); // <li></li>

        li.innerHTML = fila.id + ' ' + fila.nombre; // <li>1 Javier</li>

        ul.appendChild(li); // <ul><li>1 Javier</li></ul>
    }

    bdd.forEach((fila) => {
        li = document.createElement('li'); // <li></li>

        li.appendChild(document.createTextNode(`${fila.id} ${fila.nombre}`)); // <li>1 Javier</li>

        ul.appendChild(li); // <ul><li>1 Javier</li></ul>
    });
});
