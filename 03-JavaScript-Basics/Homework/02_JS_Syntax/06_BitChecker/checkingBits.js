function bitChecker(number){
	if ((number & 8) == 8) {
		return true;
	} else {
		return false;
	}
}
console.log(bitChecker(333));
console.log(bitChecker(425));
console.log(bitChecker(2567564754));