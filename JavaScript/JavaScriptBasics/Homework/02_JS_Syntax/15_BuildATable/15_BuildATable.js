function buildATable(input){
    var start = parseInt(input[0]);
    var end = parseInt(input[1]);
    console.log('<table>');
    console.log('<tr><th>Num</th><th>Square</th><th>Fib</th></tr>');
    for(var num = start ; num <= end; num++){
        console.log('<tr><td>' + num + '</td><td>'
            + num*num + '</td><td>' + isFibonacci(num) + '</td></tr>')
    }
    console.log('</table>');

    function isFibonacci(number){
        var firstNum = 0;
        var secondNum = 1;
        var currFibNum = 0;
        while(currFibNum < number){
            currFibNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = currFibNum;
        }
        if(currFibNum == number){
            return 'yes';
        } else {
            return 'no';
        }
    }
}

//buildATable([2,6]);
//buildATable([55,56]);
//console.log(isFibonacci());
