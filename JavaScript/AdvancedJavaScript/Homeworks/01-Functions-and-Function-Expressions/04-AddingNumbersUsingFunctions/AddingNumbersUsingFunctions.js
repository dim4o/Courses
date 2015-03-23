function add(a) {

    var sum = a;

    function inner(b) {
        sum += b;
        //console.log(sum);
        return inner;
    }

    inner.toString = function() { return sum };
    //console.log("aaa");
    return inner;
}

console.log(+add(1));  // 1
console.log(+add(2)(3));  // 5
console.log(+add(1)(1)(1)(1)(1));  // 5
console.log(+add(1)(0)(-1)(-1));  // -1
//console.log(+add(1)(2)(3)(4)(5)(6)(7));

var addTwo = add(2);
console.log(+addTwo); // 2
console.log(+addTwo(3)); // 5

