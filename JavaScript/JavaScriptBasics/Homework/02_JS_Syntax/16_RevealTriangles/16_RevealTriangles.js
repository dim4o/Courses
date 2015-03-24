function revealTriangles(input) {
    var resultMap = new Array(input.length);
    for(var i in input) {
        resultMap[i] = input[i].split('');
    }
    var charArr = [];
    for(var i in input) {
        charArr[i] = input[i].split('');
    }
    for(var row = 0; row < charArr.length; row++){
        for(var col = 0; col < charArr[row].length; col++){
            var currChar = charArr[row][col];
            if( col - 1 >= 0 && row + 1 < charArr.length &&
                currChar == charArr[row + 1][col - 1] &&
                currChar == charArr[row + 1][col] &&
                currChar == charArr[row + 1][col + 1]){
                resultMap[row][col] = '*';
                resultMap[row + 1][col - 1] = '*';
                resultMap[row + 1][col] = '*';
                resultMap[row + 1][col + 1] = '*';
            }
        }
    }
    //print the result
    for(var i in resultMap){
        console.log(resultMap[i].join(''));
    }
}

//revealTriangles([
//    'abcdexgh',
//    'bbbdxxxh',
//    'abcxxxxx'
//
//]);
revealTriangles([
    'aa',
    'aaa',
    'aaaa',
    'aaaaa'
]);