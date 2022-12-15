const URL = 'http://localhost:8080/mf0966ejemplo/api/v1/empleados/';
let form;
let tabla;
let jefes;

window.addEventListener('DOMContentLoaded', async function() {

	// Mapeamos los objetos más importantes
	form = document.querySelector('form');
	form.style.display = 'none';

	tabla = document.querySelector('table');
	jefes = document.querySelector('#jefe');

	// Gestionamos los eventos
	form.addEventListener('submit', async function(e) {
		e.preventDefault();

		const empleado = {};

		let metodo = 'POST';

		if (form.id.value) {
			empleado.id = parseInt(form.id.value);
			metodo = 'PUT';
		}

		empleado.nombre = form.nombre.value;
		empleado.nif = form.nif.value;

		if (form.jefe.value !== '0') {
			empleado.jefe = { id: parseInt(form.jefe.value) };
		}

		console.log(empleado);

		const respuesta = await fetch(URL + ((metodo === 'PUT') ? empleado.id: ''), {
			method: metodo,
			body: JSON.stringify(empleado),
			headers: {
				"Content-type": "application/json; charset=UTF-8"
			}
		});

		console.log(respuesta);
		
		if(!respuesta.ok) {
			alert('No se ha podido guardar el empleado');
			return;
		}
		
		await refrescarTabla();
		
		form.reset();

		tabla.style.display = 'table';
		form.style.display = 'none';
	});

	// Pedimos los empleados al servidor REST
	await refrescarTabla();

});

async function refrescarTabla() {
	const respuesta = await fetch(URL);

	console.log(respuesta);

	const empleados = await respuesta.json();

	console.log(empleados);

	const tbody = document.querySelector('tbody');

	tbody.innerHTML = '';
	jefes.innerHTML = '<option selected value="0">Seleccione un jefe</option>';

	empleados.forEach(function(empleado) {
		console.log(empleado);

		const tr = document.createElement('tr');

		// TODO No crear empleado que sea su propio jefe

		tr.innerHTML = `
			<th scope="row">${empleado.id}</th>
			<td>${empleado.nombre}</td>
			<td>${empleado.nif}</td>
			<td>${empleado.jefe.nombre ? empleado.jefe.nombre : ''}</td>
			<td><a class="btn btn-primary btn-sm"
				href="javascript:editar(${empleado.id})">Editar</a> <a
				class="btn btn-danger btn-sm"
				href="javascript:borrar(${empleado.id})">Borrar</a>
		`;

		tbody.appendChild(tr);

		const option = document.createElement('option');

		option.value = empleado.id;
		option.innerText = empleado.nombre;

		jefes.appendChild(option);
	});
}

async function editar(id) {
	tabla.style.display = 'none';
	form.style.display = 'block';

	if (!id) {
		return;
	}

	const respuesta = await fetch(URL + id);
	const empleado = await respuesta.json();

	console.log(empleado);

	form.id.value = empleado.id;
	form.nombre.value = empleado.nombre;
	form.nif.value = empleado.nif;
	form.jefe.value = empleado.jefe.id;
}

function borrar(id) {
	alert('borrar ' + id);
}