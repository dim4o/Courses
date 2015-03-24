function studentsCoursesGradesVisits(inputArr) {
    var studentsMap = {};
    for (var i in inputArr) {
        var currLine = inputArr[i].split(/[|]/g);
        var studentName = currLine[0].trim();
        var courseName = currLine[1].trim();
        var grade = currLine[2].trim();
        var visits = currLine[3].trim();

        if(!studentsMap.hasOwnProperty(courseName)) {
            studentsMap[courseName] = {"avgGrade": [], "avgVisits": [], "students": []};
        }
        studentsMap[courseName]["avgGrade"].push(grade);
        studentsMap[courseName]["avgVisits"].push(visits);
        if (studentsMap[courseName]["students"].indexOf(studentName) < 0) {
            studentsMap[courseName]["students"].push(studentName);
        }
    }

    for (var obj in studentsMap) {
        studentsMap[obj]["students"].sort();
        studentsMap[obj]["avgGrade"] = sumArr(studentsMap[obj]["avgGrade"]);
        studentsMap[obj]["avgVisits"] = sumArr(studentsMap[obj]["avgVisits"]);
    }
    console.log(JSON.stringify(sortByKeys(studentsMap)));

    function sumArr(arr) {
        var sum = 0;
        for (var i in arr) {
            sum+=parseFloat(arr[i]);
        }
        var avg = sum/arr.length;
        return parseFloat(avg.toFixed(2));
    }
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

studentsCoursesGradesVisits([
    'Peter Nikolov | PHP  | 5.50 | 8',
    'Maria Ivanova | Java | 5.83 | 7',
    'Ivan Petrov   | PHP  | 3.00 | 2',
    'Ivan Petrov   | C#   | 3.00 | 2',
    'Peter Nikolov | C#   | 5.50 | 8',
    'Maria Ivanova | C#   | 5.83 | 7',
    'Ivan Petrov   | C#   | 4.12 | 5',
    'Ivan Petrov   | PHP  | 3.10 | 2',
    'Peter Nikolov | Java | 6.00 | 9'

]);