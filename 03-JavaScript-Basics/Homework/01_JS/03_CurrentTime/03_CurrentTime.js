var time = new Date();
var hours = time.getHours();
var minutes = time.getMinutes();

function padMinutes(min) {
	if (min < 10) {
		return '0' + min;	
	} else {
		return min;
	}
}

console.log(hours+':'+padMinutes(minutes));