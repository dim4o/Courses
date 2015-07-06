Array.prototype.removeItem = function(value) {
    while(this.indexOf(value) >= 0){
        this.splice(this.indexOf(value), 1);
    }
    return this;
};

//tests
var arr = [1, 2, 1, 4, 1, 3, 4, 1, 111, 3, 2, 1, '1'];
console.log(arr.removeItem(1));

arr = ['hi', 'bye', 'hello' ];
console.log(arr.removeItem('bye'));
