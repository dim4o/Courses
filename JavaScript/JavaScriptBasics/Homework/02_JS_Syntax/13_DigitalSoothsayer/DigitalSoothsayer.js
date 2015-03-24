function randIndex() {
 	return rand = Math.floor(Math.random()*5);
}
function soothsayer(input){
	//numsArr, langsArr, citiesArr, carsArr
	var number = input[0][randIndex()];
	var language = input[1][randIndex()];
	var city = input[2][randIndex()];
	var car = input[3][randIndex()];
	var result = [number, language, city, car];
	console.log ('You will work ' + number + ' years on '+ language + '. You will live in ' + city + ' and drive ' + car + '.');
}
var inputValues = [[3, 5, 2, 7, 9], 
				['Java', 'Python', 'C#', 'JavaScript', 'Ruby'], 
				['Silicon Valley', 'London', 'Las Vegas', 'Paris', 'Sofia'], 
				['BMW', 'Audi', 'Lada', 'Skoda', 'Opel']];
soothsayer(inputValues);
