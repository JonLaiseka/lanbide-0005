$(function() {
	$('<button class="btn btn-primary mb-3">Actualizar cantidades</button>').insertAfter('h2:contains(Productos)').on('click', function() {
		let id, cantidad, datos = '';

		$('form').each(function() {
			id = $(this).find('input[name=id]').val();
			cantidad = $(this).find('input[name=cantidad]').val();

			datos += `${id},${cantidad};`;
		});

		location.href = 'carrito-total?datos=' + datos;
	});
});