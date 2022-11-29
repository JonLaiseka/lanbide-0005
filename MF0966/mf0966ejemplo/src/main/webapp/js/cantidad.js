$(function() {
	$('.menos').on('click', function() {
		const menos = $(this).parent().find('input')[0];
		
		if(menos.value > 0) {
			menos.value--;
		}
	});
	
	$('.mas').on('click', function() {
		const mas = $(this).parent().find('input')[0];
		
		if(mas.value < 99) {
			mas.value++;
		}
	})

});