function pricesTrends(input) {
    for (var i in input) {
        input[i] = parseFloat(parseFloat(input[i]).toFixed(2));
    }
    console.log('<table>');
    console.log('<tr><th>Price</th><th>Trend</th></tr>');
    for (var i in input) {
        if (i == 0 || input[i] == input[i - 1]) {
            console.log('<tr><td>' + input[i].toFixed(2) + '</td><td><img src=\"fixed.png\"/></td></td>');
        } else if (input[i] > input[i - 1]) {
            console.log('<tr><td>' + input[i].toFixed(2) + '</td><td><img src=\"up.png\"/></td></td>');
        } else {
            console.log('<tr><td>' + input[i].toFixed(2) + '</td><td><img src=\"down.png\"/></td></td>');
        }
    }
    console.log('</table>');
}

pricesTrends(['50', '60']);
pricesTrends(['36.333',
    '36.5',
    '37.019',
    '35.4',
    '35',
    '35.001',
    '36.225'
])

