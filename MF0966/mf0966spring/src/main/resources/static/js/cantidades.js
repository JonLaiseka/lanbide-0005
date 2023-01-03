window.addEventListener('DOMContentLoaded', function() {
	const botones = document.querySelectorAll('button');

	botones.forEach(function(boton) {
		boton.addEventListener('click', function(e) {
			const boton = e.target;
			const input = boton.parentNode.querySelector('input[name=cantidad]');

			if (boton.classList.contains('menos')) {
				if (input.value > 0) {
					input.value--;
				}
			} else if (boton.classList.contains('mas')) {
				input.value++;
			} else {
				console.error('¿QUÉ BOTÓN ES ESE?', boton);
			}
		});
	});
});