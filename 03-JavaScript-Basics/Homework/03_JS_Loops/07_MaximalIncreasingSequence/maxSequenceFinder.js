function findMaxSequence (arr) {
    var startIndex = 0;
    var bestStart = 0;
    var length = 1;
    var maxLength = 1;
    var exist = false;
    for (var i = 0; i < arr.length; i++) {
        if(arr[i] < arr[i+1] ){
            length++;
            if (length > maxLength) {
                maxLength = length;
                bestStart = startIndex;
                exist = true;
            }
        } else {
            startIndex = i + 1;
            length = 1;
        }
    }
    if(exist) {
        console.log(arr.slice(bestStart, bestStart + maxLength));
    } else {
        console.log('no');
    }
}
findMaxSequence([3, 2, 3, 4, 2, 2, 4]);
findMaxSequence([3, 5, 4, 6, 1, 2, 3, 6, 10, 32]);
findMaxSequence([3, 2, 1]);
