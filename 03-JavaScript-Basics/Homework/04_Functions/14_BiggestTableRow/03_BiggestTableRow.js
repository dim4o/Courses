function  biggestTableRow(inputArr){
    var maxRow = -500000;//Number.MIN_VALUE;
    var maxRowData = undefined;
    for (var i = 2 ; i < inputArr.length - 1; i++){
        var rowDataArr = inputArr[i].match(/-?[.\d]+/g);
        var currRow = 0;
        for(var k in rowDataArr){
            if(rowDataArr[k] != '-'){
                currRow += parseFloat(rowDataArr[k]);
            }
        }
        if(currRow > maxRow){
            maxRow = currRow;
            maxRowData = rowDataArr;
        }
    }
    if(maxRowData == undefined) {
        console.log('no data')
    } else {
        console.log(maxRow + ' = ' + maxRowData.join(' + '));
    }
}
//biggestTableRow([
//
//'<table>',
//'<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
//'<tr><td>Sofia</td><td>26.2</td><td>8.20</td><td>-</td></tr>',
//    '<tr><td>Varna</td><td>11.2</td><td>18.00</td><td>36.10</td></tr>',
//    '<tr><td>Plovdiv</td><td>17.2</td><td>12.3</td><td>6.4</td></tr>',
//    '<tr><td>Bourgas</td><td>-</td><td>24.3</td><td>-</td></tr>',
//    '</table>'
//
//]);
//biggestTableRow([
//    '<table>',
//    '<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
//    '<tr><td>Sofia</td><td>-</td><td>-456</td><td>-</td></tr>',
//    '</table>'
//]);
//
//biggestTableRow([
//    '<table>',
//    '<tr><th>Town</th><th>Store1</th><th>Store2</th><th>Store3</th></tr>',
//    '<tr><td>Sofia</td><td>12850</td><td>-560</td><td>20833</td></tr>',
//    '<tr><td>Rousse</td><td>-</td><td>50000.0</td><td>-</td></tr>',
//    '<tr><td>Bourgas</td><td>25000</td><td>25000</td><td>-</td></tr>',
//    '</table>'
//
//]);
