function biggerThanNeighbors(index,  arr){
    if (arr[index] == undefined) {
        return undefined;
        } else if (index == 0 ||
                    index == arr.length - 1) {
        return 1;
        } else if (arr[index] <= arr[index - 1] ||
                    arr[index] <= arr[index + 1]) {
        return 0;
        } else {
        return 2;
        }
}
function printResult(index,  arr) {
    var bool = biggerThanNeighbors(index, arr);
    if (bool == undefined) {
        console.log('invalid index');
    } else if (!Boolean(bool)) {
        console.log('not bigger');
    } else if (bool == 1) {
            console.log('only one neighbor');
    } if (bool == 2) {
            console.log('bigger');
    }
}

printResult(2, [1, 2, 3, 3, 5]);
printResult(2, [1, 2, 5, 3, 4]);
printResult(5, [1, 2, 5, 3, 4]);
printResult(0, [1, 2, 5, 3, 4]);
