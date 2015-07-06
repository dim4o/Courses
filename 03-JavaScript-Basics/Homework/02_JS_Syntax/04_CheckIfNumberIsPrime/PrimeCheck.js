function isPrime(number){
	if (number < 2) {
		return false;
	}
	for (var i = 2; i <= Math.sqrt(number); i++) {
		if (number%i==0) {
			return false;
		}
	}
	return true;	
}

console.log(isPrime(-11));
console.log(isPrime(0));
console.log(isPrime(1));
console.log(isPrime(2));
console.log(isPrime(254));
console.log(isPrime(587));
console.log(isPrime(4575678));
console.log(isPrime(7));