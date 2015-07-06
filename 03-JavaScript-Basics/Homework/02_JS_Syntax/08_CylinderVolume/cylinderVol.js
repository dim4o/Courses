function calcCylinder(radius, height) {
	return (Math.PI*radius*radius*height).toFixed(3);
}
console.log(calcCylinder(2, 4));
console.log(calcCylinder(5, 8));
console.log(calcCylinder(12, 3));