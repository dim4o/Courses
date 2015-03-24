function printArgsInfo() {
    for (var i = 0; i < arguments.length; i++) {
        var type;
        if (Array.isArray(arguments[i])) {
            type = "array";
        } else {
            type = typeof arguments[i];
        }
        console.log(arguments[i] + " (" + type +")");
    }
}

// Problem 2.	call() and apply()

printArgsInfo.call();
// result: no result

printArgsInfo.call(null, 1, 2, "3", [1, 2, 3]);
// result: 1,2,3 (array) => same as printArgsInfo(1, 2, "3", [1, 2, 3]);

printArgsInfo.apply();
// result: no result

printArgsInfo.apply(null, [1, 2, "3", [1, 2, 3]]);
// result: 1,2,3 (array) => same as printArgsInfo(1, 2, "3", [1, 2, 3]);

