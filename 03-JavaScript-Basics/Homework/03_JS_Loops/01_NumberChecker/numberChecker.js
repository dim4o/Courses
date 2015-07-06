function printNumbers(number) {
	if (number < 1) {
		console.log('no');
		return;
	}
	var result = '';
	for (var i = 1; i <= number; i++) {
		if (i%4 != 0 && i%5 != 0) {
			result += i + ', ';
		}
	}
	console.log(result.substring(0, result.length-2));
}
printNumbers(20);
printNumbers(-5);
printNumbers(13);