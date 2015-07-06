function concerts(inputArr) {
    var concertsMap = {};
    for (var i in inputArr) {
        var currLine = inputArr[i].split(/[|]/g);
        var band = currLine[0].trim();
        var town = currLine[1].trim();
        var venue = currLine[3].trim();

        if(!concertsMap.hasOwnProperty(town)) {
            concertsMap[town] = {};
            concertsMap[town][venue] = [];
        } else if (concertsMap[town][venue] == undefined) {
            concertsMap[town][venue] = [];
        }
        if (concertsMap[town][venue].indexOf(band) < 0) {
            concertsMap[town][venue].push(band);
        }
    }
    for (var townKey in concertsMap) {
        for (var venueKey in concertsMap[townKey]) {
            concertsMap[townKey][venueKey].sort();
        }
        concertsMap[townKey]= sortByKeys(concertsMap[townKey]);
    }
    console.log(JSON.stringify(sortByKeys(concertsMap)));

    function sortByKeys(inputMap) {
        var resultMap = {};
        var keyArr = Object.keys(inputMap);
        keyArr.sort();
        for (var key in keyArr) {
            resultMap[keyArr[key]] = inputMap[keyArr[key]];
        }
        return resultMap;
    }
}

concerts([
   ' ZZ Top | London | 2-Aug-2014 | Wembley Stadium',
    'Iron Maiden | London | 28-Jul-2014 | Wembley Stadium',
    'Metallica | Sofia | 11-Aug-2014 | Lokomotiv Stadium',
    'Helloween | Sofia | 1-Nov-2014 | Vassil Levski Stadium',
    'Iron Maiden | Sofia | 20-June-2015 | Vassil Levski Stadium',
    'Helloween | Sofia | 30-July-2015 | Vassil Levski Stadium',
    'Iron Maiden | Sofia | 26-Sep-2014 | Lokomotiv Stadium',
    'Helloween | London | 28-Jul-2014 | Wembley Stadium',
    'Twisted Sister | London | 30-Sep-2014 | Wembley Stadium',
    'Metallica | London | 03-Oct-2014 | Olympic Stadium',
    ' Iron Maiden | Sofia | 11-Apr-2016 | Lokomotiv Stadium',
    'Iron Maiden | Buenos Aires | 03-Mar-2014 | River Plate Stadium'
]);