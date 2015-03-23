var add_the_handlers = function (nodes) {
    var i;
    for (i = 0; i < nodes.length; i += 1) {
        nodes[i] = function (e) {
            console.log(i);
        }(i);
    }
};

//    var add_the_handlers = function (nodes) {
//        var i;
//        for (i = 0; i < nodes.length; i += 1) {
//            nodes[i].onclick = function (i) {
//                return function () {
//                    console.log(i);
//                };
//            }(i);
//        }
//    };
var arr = ['a', 'b', 'c', 'd'];
add_the_handlers(arr);
console.log(arr[0]);
console.log(arr[1]);
console.log(arr[2]);