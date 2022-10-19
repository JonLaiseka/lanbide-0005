'use strict';

// Java
// Script
// Object
// Notation

function ejemploJson() {
    const objeto = { id: 1, nombre: 'Javier', apellido: 'Lete' };

    console.log(objeto);

    const json = JSON.stringify(objeto);
    
    console.log(json);

    console.log(JSON.parse(json));
}

function objetos() {
    const objeto = new Object();

    objeto.nombre = 'Javier';
    objeto.apellidos = 'Lete';
    objeto['dato'] = 'Valor';

    objeto.otro = { profesion: 'profesor', materias: [ 'Java', '.NET' ] };

    objeto.nombreCompleto = function () {
        return `${this.nombre} ${this.apellidos}`;
    }

    objeto.apellido = 'González';

    objeto.yomismo = objeto;

    console.log(objeto.nombreCompleto());

    console.log(objeto);

    function Persona(id, nombre, apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    Persona.prototype.getNombreCompleto = function() {
        return `${this.nombre} ${this.apellidos}`;
    }

    class PersonaClase {
        constructor(id, nombre, apellidos) {
            this.id = id;
            this.nombre = nombre;
            this.apellidos = apellidos;
        }
        getNombreCompleto() {
            return `${this.nombre} ${this.apellidos}`;
        }
    }
    
    
    let persona = new Persona(1, 'Javier', 'Lete');
    
    console.log(persona, typeof persona);
    console.log(persona.getNombreCompleto());

    console.log('   asdfasdf   '.trim());
    
    String.prototype.trim = function() {
        return 'Te jodes';
    }
    
    console.log('   asdfasdf   '.trim());

    String.prototype.saludar = function() {
        return 'Hola ' + this;
    }

    console.log('Pepe'.saludar());

    let persona2 = new PersonaClase('asdfa', new Date(), 'asdf');

    console.log(persona2);
}

function arrays() {
    const arr = Array(3);
    
    arr[0] = 5;
    arr[1] = 10;
    arr[2] = 15;
    arr[3] = 76;
    arr[4] = new Date();
    arr[10] = 6;

    arr['pepe'] = 'Colega';
    arr.yepa = 'Que tal';

    arr.push('Otro añadido');

    for(let i = 0; i < arr.length; i++) {
        console.log(arr[i]);
    }

    for(let dato of arr) {
        console.log(dato);
    }

    for(let clave in arr) {
        console.log(clave, arr[clave]);
    }
    
    console.log(arr);

}

function bases() {
    console.log(texto);

    var texto = 'Ya no cuela';

    console.log(texto);

    console.log("Otro texto");

    console.log(
        `El valor de la variable texto es ${texto}
Para que conste`
    );

    console.log('El valor de la variable texto es ' + texto + '\n' +
        'Para que conste');

    console.log(typeof texto);

    let dato = 'asdg';

    console.log(dato, typeof dato);

    const numero = parseInt(dato, 10);

    console.log(numero, typeof numero);

    if (isNaN(numero)) {
        console.log('No es un número');
    } else {
        console.log(numero);
    }

    const mes = '6';
    let dias;

    // mes === case

    switch (mes) {
        case 2: dias = 28; break;
        case 4:
        case 6:
        case 9:
        case 11: dias = 30; break;
        default: dias = 31;
    }

    console.log(mes, dias);

    let consola = console.log;

    consola('Hola');

    consola(typeof consola);

}