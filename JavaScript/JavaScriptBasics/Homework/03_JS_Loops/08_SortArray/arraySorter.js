function sortArray (arr){
    for(var i=0; i < arr.length; i+=1){
        var minElement = Number.MAX_VALUE;
        var minElementIndex = 0;
        for(var k = i; k < arr.length; k+=1){
            if(arr[k] < minElement){
                minElement = arr[k];
                minElementIndex = k;
            }
        }
        var temp = arr[i];
        arr[i] = minElement;
        arr[minElementIndex] = temp;
    }
    return arr;
}
console.log( sortArray([5, 4, 3, 2, 1]));
console.log( sortArray([12, 12, 50, 2, 6, 22, 51, 712, 6, 3, 3]));