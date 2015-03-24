function findMaxSequence(arr) {
	var bestIndex = 0;
	var maxLength = 1;
	var possibleBestIndex = 0;
	var currLength = 1;

	for (var i = 0; i < arr.length - 1; i++) {
		if (arr[i] === arr[i + 1]) {
			currLength++;
			if (currLength >= maxLength) {
				maxLength = currLength;
				bestIndex = possibleBestIndex;
			}
		} else {
			currLength = 1;
			possibleBestIndex = i + 1;
		}
	}
	console.log(arr.slice(bestIndex, bestIndex + maxLength));
}

findMaxSequence([2, 1, 1, 2, 3, 3, 2, 2, 2, 1]);
findMaxSequence(['happy']);
findMaxSequence([2, 'qwe', 'qwe', 3, 3, '3']);