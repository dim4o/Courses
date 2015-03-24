function soccerResults(input) {
    var soccerMap = {};
    for (var index in input) {
        var currLine = input[index].split(/[\/:-]/g);
        var team1 = currLine[0].trim();
        var team2 = currLine[1].trim();
        var goals1 = parseInt(currLine[2].trim());
        var goals2 = parseInt(currLine[3].trim());

        if (!soccerMap.hasOwnProperty(team1)) {
           soccerMap[team1] = {"goalsScored": 0, "goalsConceded": 0, "matchesPlayedWith": []};
        }
        soccerMap[team1]["goalsScored"] += goals1;
        soccerMap[team1]["goalsConceded"] += goals2;
        if (soccerMap[team1]["matchesPlayedWith"].indexOf(team2) < 0) {
            soccerMap[team1]["matchesPlayedWith"].push(team2);
        }

        if (!soccerMap.hasOwnProperty(team2)) {
            soccerMap[team2] = {"goalsScored": 0, "goalsConceded": 0, "matchesPlayedWith": []};
        }
        soccerMap[team2]["goalsScored"] += goals2;
        soccerMap[team2]["goalsConceded"] += goals1;
        if (soccerMap[team2]["matchesPlayedWith"].indexOf(team1) < 0) {
            soccerMap[team2]["matchesPlayedWith"].push(team1);
        }
    }

    for (var obj in soccerMap) {
        soccerMap[obj]["matchesPlayedWith"].sort();
    }
    soccerMap = sortByKeys(soccerMap);
    console.log(JSON.stringify(soccerMap));

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

//TEST
soccerResults([
    'Germany / Argentina: 1-0',
    'Brazil / Netherlands: 0-3',
    'Netherlands / Argentina: 0-0',
    'Brazil / Germany: 1-7',
    'Argentina / Belgium: 1-0',
    'Netherlands / Costa Rica: 0-0',
    'France / Germany: 0-1',
    'Brazil / Colombia: 2-1'

]);