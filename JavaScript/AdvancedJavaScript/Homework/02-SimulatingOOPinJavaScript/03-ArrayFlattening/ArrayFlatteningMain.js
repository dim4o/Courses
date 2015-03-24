// Working properly for all cases
Array.prototype.flatten = function flattenArray() {

    var result = [];

    function traverseArr(array) {

        for (var i = 0; i < array.length; i++) {
            if (array[i] instanceof Array) {
               traverseArr(array[i]);
            } else {
                result.push(array[i]);
            }
        }
    }
    traverseArr(this);
    return result;
};

// TESTS
var array0 = [1, 2, 3 ,"[pesho]"];
console.log(array0.flatten());

var array1 = [1, 2, 3, 4];
console.log(array1.flatten());

var array2 = [1, 2, [3, 4], [5, 6]];
console.log(array2.flatten());
console.log(array2); // Not changed

var array3 = [0, ["string", "values"], 5.5, [[1, 2, true], [3, 4, false]], 10];
console.log(array3.flatten());
