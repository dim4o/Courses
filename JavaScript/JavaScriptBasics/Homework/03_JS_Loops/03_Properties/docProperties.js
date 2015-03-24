function displayProperties() {
    var propArr = [];

    for (var properties in this) {
        propArr.push(properties);        
    }

    propArr.sort(function (a, b) {
        return a.toLowerCase().localeCompare(b.toLowerCase());
    });

    var output = propArr.join('\n');
    console.log(output);

    for (var i = 0; i < propArr.length; i++) {
        var li = document.createElement('li');
        li.innerHTML = propArr[i];
        document.getElementById('result').appendChild(li);
    }
}

displayProperties();