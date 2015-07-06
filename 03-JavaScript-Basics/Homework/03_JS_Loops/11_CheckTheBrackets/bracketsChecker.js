function checkBrackets(str){
	var openBracket = 0;
	var closeBracket = 0;
	for (var index in str) {
		if (str[index] == '(') {
			openBracket++
		} else if (str[index] == ')'){
			closeBracket++;	
		}
	}
	if (openBracket == closeBracket) {
		console.log('correct');
	} else {
		console.log('incorrect');
	}
}

checkBrackets('( ( a + b ) / 5 – d )');
checkBrackets(') ( a + b ) )');
checkBrackets('( b * ( c + d *2 / ( 2 + ( 12 – c / ( a + 3 ) ) ) )');