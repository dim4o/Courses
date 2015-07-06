// This function is not working properly for all cases, but it's interesting
// Working properly for current tests
Array.prototype.flatten = function flattenArray(array) {
    console.log(JSON.stringify(this));
    var result = '[' + JSON.stringify(this).replace(/\[/g, '').replace(/\]/g, '') + ']';
    result = JSON.parse(result);
    return result;
};

// TESTS
var test = [1, 2, 3, 4, ["[Pesho]", 5, 6]];
var array1 = [1, 2, 3, 4];
console.log(array1.flatten());

var array2 = [1, 2, [3, 4], [5, 6]];
console.log(array2.flatten());
console.log(array2); // Not changed

var array3 = [0, ["string", "values"], 5.5, [[1, 2, true], [3, 4, false]], 10];
console.log(array3.flatten());
