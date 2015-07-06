function stringMatrixRotation(inputArr){
    var angle = parseInt(inputArr[0].replace(/[A-Za-z()]+/g, ''));
    var resultArr = inputArr.slice(1, inputArr.length);
    var rotCount = (angle%360)/90;

    for(var count = 0 ; count < rotCount; count++){
        resultArr = rotate(resultArr);
    }
    printArr(resultArr);

// FUNCTIONS DEFINITIONS
    function rotate(arr){
        var maxlength = 0;
        for(var i in arr){
            if(arr[i].length > maxlength){
                maxlength = arr[i].length;
            }
        }
        //console.log(maxlength)
        var newArr = new Array(maxlength);
        for (var k = 0; k < maxlength; k++) {
            newArr[k] = new Array(arr.length);
        }

        var newRow = 0;
        var newCol = 0;
        for(var row = arr.length -1; row >= 0; row--){
            for(var col = 0; col < maxlength; col++){
                //console.log(arr[row][col]);
                newArr[newRow][newCol] = arr[row][col];
                newRow++;
            }
            newCol++;
            newRow = 0;
        }
        //printArr(newArr);
        return newArr;
    }
    function printArr(inputArr){
        for(var row = 0; row < inputArr.length; row++){
            var rowStr = "";
            for(var col = 0; col < inputArr[0].length; col++){
                if(inputArr[row][col] != undefined){
                    rowStr += inputArr[row][col];
                } else {
                    rowStr += " ";
                }
            }
            console.log(rowStr);
        }
    }
}

//rotate(["hello", "softuni", "exam"]);
//var a = new Array();
//console.log(a[1][1]);
//stringMatrixRotation(['Rotate(270)', "hello", "softuni", "exam"]);