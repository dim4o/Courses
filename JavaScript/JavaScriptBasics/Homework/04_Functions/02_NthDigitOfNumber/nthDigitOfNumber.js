function findNthDigit(arr) {
    var position = parseInt(arr[0]);
    var number = arr[1].toString().replace(/[.-]|[+]]/g, '');
    if (position <= number.length) {
        console.log(number[number.length - position ]);
    } else {
        console.log('The number doesn’t have ' + position + ' digits');
    }
}
findNthDigit([1, 6]);
findNthDigit([2, -55]);
findNthDigit([6, 923456]);
findNthDigit([3, 1451.78]);
findNthDigit([6, 888.88]);
