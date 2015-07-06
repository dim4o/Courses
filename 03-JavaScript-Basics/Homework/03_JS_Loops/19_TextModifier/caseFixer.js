function toMixcase(str){
	str = str.replace(/<(.*?)>/g, '');
	var result = '';
	for (var i = 0; i < str.length; i++) {
		if (Math.random() < 0.5) {
			result += str[i].toUpperCase();
		} else {
			result += str[i].toLowerCase();
		}
	}
	return '<mixcase>' + result + '</mixcase>';
}
function toLowcase(str){
	str = str.replace(/<(.*?)>/g, '').toLowerCase();
	return '<lowcase>' + str + '</lowcase>';
}
function toUpcase(str){
	str = str.replace(/<(.*?)>/g, '').toUpperCase();
	return '<upcase>' + str + '</upcase>';
}

function fixCasing(str) {
	var mixcase = str.match(/(<mixcase>)(.*?)(<\/mixcase>)/g);
	var upcase = str.match(/(<upcase>)(.*)(<\/upcase>)/g);
	var lowcase = str.match(/(<lowcase>)(.*)(<\/lowcase>)/g);
	for(i in mixcase) {
		str = str.replace(mixcase[i], toMixcase(mixcase[i]));
	}
	for(i in upcase) {
		str = str.replace(upcase[i], toUpcase(upcase[i]));
	}
	for(i in lowcase) {
		str = str.replace(lowcase[i], toLowcase(lowcase[i]));
	}
	return str;
}

console.log(fixCasing("We are <mixcase>living</mixcase> in a <upcase>yellow submarine</upcase>. We <mixcase>don't</mixcase> have <lowcase>anything</lowcase> else."));
