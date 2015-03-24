function findLargestBySumOfDigits(arr) {
    var maxSum = 0;
    var bestIndex = 0;
    for (var index in arr) {
        if (isInteger(arr[index])) {
            var currSum = sumOfDigits(arr[index]);
            if (currSum > maxSum) {
                maxSum = currSum;
                bestIndex = index;
            }
        } else {
            console.log(undefined);
            return;
        }
    }
    console.log(arr[bestIndex]);
    //help functions
    function isInteger(input) {
        if (typeof input == 'number' &&
            input.toString().indexOf('.') < 0) {
            return true;
        }
        return false;
    }
    function sumOfDigits(num) {
        num = Math.abs(num).toString();
        var sum = 0;
        for (var i in num) {
            sum += parseInt(num[i]);
        }
        return sum;
    }
}

findLargestBySumOfDigits([5, 10, 15, 111]);
findLargestBySumOfDigits([33, 44, -99, 0, 20]);
findLargestBySumOfDigits(['hello']);
findLargestBySumOfDigits([5, 3.3]);




