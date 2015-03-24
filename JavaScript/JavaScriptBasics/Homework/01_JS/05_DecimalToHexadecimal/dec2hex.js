var number = prompt('Enter number:');

function toHex(num){
	return number.toString(16).toUpperCase();
}
var hex = toHex(number);
console.log(hex);