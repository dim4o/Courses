function findMostFreqNum(arr){
	var currNumCount = 1;
	var maxCount = 1;
	var currNum = arr[0];

	for (var i = 0; i < arr.length; i++) {
		for (var k = i+1; k < arr.length; k++) {
			if (arr[i] === arr[k] && arr[i] != undefined && arr[k]!=undefined) {
				currNumCount++;	 
				arr[k] = undefined;
			}
		}

		if (currNumCount > maxCount) {
			maxCount = currNumCount;
			currNum = arr[i];	
		}
		currNumCount = 1;
		arr[i] = undefined;
	}
	console.log(currNum+' ('+maxCount+' times)');
}

findMostFreqNum([4, 1, 1, 4, 2, 3, 4, 4, 1, 2, 4, 9, 3]);
findMostFreqNum([2, 1, 1, 5, 7, 1, 2, 5, 7, 3, 87, 2, 12, 634, 123, 51, 1]);
findMostFreqNum([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]);
