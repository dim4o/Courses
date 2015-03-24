function findMostFreqWord(str) {
	str = str.toLowerCase() + " ";
	var words = str.split(/\W+/);
	words = words.slice(0, words.length - 1);
	var wordMap = [];
	for(var index in words){
		if (wordMap.hasOwnProperty(words[index])){
			wordMap[words[index]]+=1;
		} else {
			wordMap[words[index]]=1;
		}
	}
	
	var keysSortedByValue = Object.keys(wordMap).sort(function(a,b){return wordMap[b]-wordMap[a]});
	var mostFrequent = wordMap[keysSortedByValue[0]];
	
	var result = [];
	for (var key in keysSortedByValue ) {
		if (wordMap[keysSortedByValue[key]] == mostFrequent) {
			result.push(keysSortedByValue[key]);
		}
	}
	result = result.sort();
	for (var index in result) {
		console.log(result[index] +' --> '+ mostFrequent + ' times');
	}
}

findMostFreqWord('in the middle of the night');
console.log();
findMostFreqWord('Welcome to SoftUni. Welcome to Java. Welcome everyone.');
console.log();
findMostFreqWord('Hello my friend, hello my darling. Come on, come here. Welcome, welcome darling.');
