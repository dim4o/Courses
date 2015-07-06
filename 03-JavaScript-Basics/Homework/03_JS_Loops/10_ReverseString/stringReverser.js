function reverseString(str){
	var reversed ='';
	for (var i = 0; i < str.length; i++) {
		reversed = str[i] + reversed;
	}
	console.log(reversed);
}
reverseString('sample');
reverseString('softUni');
reverseString('java script');

