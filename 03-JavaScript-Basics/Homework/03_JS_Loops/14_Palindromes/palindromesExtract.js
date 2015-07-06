function findPalindromes(str){
	str=str.toLowerCase() + ' ';
	var words = str.split(/\W+/);
	words = words.slice(0, words.length - 1);
	var palindromes = [];
	for (var index in words) {
		var reversed = words[index].split('').reverse().join('');
		if(words[index] == reversed){
			palindromes.push(words[index]);
		}
	}
	return palindromes.join(', ');
}

console.log(findPalindromes('There is a man, his name was Bob.'));