function createArray (){
	var arr = [];
	for(var i = 0; i < 21; i++){
		arr[i] = i*5;
	}
	return arr.join(' ');
}

console.log(createArray());

