
// Returns true if the string starts with the provided substring and false otherwise
String.prototype.startsWith = function startsWith(substring) {

    return (this.indexOf(substring) == 0);
};

// Returns true if the string ends with the provided substring and false otherwise
String.prototype.endsWith = function endsWith(substring) {

    var len = substring.length;
    return (this.indexOf(substring) == this.length - len);
};

// Returns the first count characters of the string. If count is greater than the
// length of the string, returns the whole string
String.prototype.left = function left(count){

    if (count > this.left) {
        count = this.length;
    }
    return this.substr(0, count);
};

// Returns the last count characters of the string. If count is greater than the
// length of the string, returns the whole string
String.prototype.right = function right(count){

    if (count > this.left) {
        count = this.length;
    }

    return this.substr(this.length - count  , this.length - 1);
};

// Returns a new string which contains count times the specified character at its beginning.
// Character is optional and defaults to space
String.prototype.padLeft = function padLeft(count, character) {
    if (count < this.length) {
        return this.toString();
    }
    if (arguments.length == 1) {
        character = " ";
    }
    var help = character.repeat(count);
    return (help + this).right(count);
};

// returns a new string which contains count times the specified character at its end.
// character is optional and defaults to space
String.prototype.padRight = function padRight(count, character) {
    if (count < this.length) {
        return this.toString();
    }
    if (arguments.length == 1) {
        character = " ";
    }
    var help = character.repeat(count);
    return (this + help).left(count);
};

// Repeats the provided string count times. Do not use
// the default implementation here, write your own
String.prototype.repeat = function repeat(count) {

    return new Array(count + 1).join(this);
};

// TESTS
var example1 = "TThis is an example string used only for demonstration purposes.";
console.log(example1.startsWith("This"));
console.log(example1.startsWith("this"));
console.log(example1.startsWith("other"));
console.log();

var example2 = "This is an example string used only for demonstration purposes.";
console.log(example2.endsWith("poses."));
console.log(example2.endsWith ("example"));
console.log(example2.startsWith("something else"));
console.log();

var example3 = "This is an example string used only for demonstration purposes.";
console.log(example3.left(9));
console.log(example3.left(90));
console.log();

var example4 = "This is an example string used only for demonstration purposes.";
console.log(example4.right(9));
console.log(example4.right(90));
console.log();

var example4_1 = "abcdefgh";
console.log(example4_1.left(5).right(2));
console.log();

var hello1 = "hello";
console.log(hello1.padLeft(5));
console.log(hello1.padLeft(10));
console.log(hello1.padLeft(5, "."));
console.log(hello1.padLeft(10, "."));
console.log(hello1.padLeft(2, "."));
console.log();

var hello2 = "hello";
console.log(hello2.padRight(5));
console.log(hello2.padRight(10));
console.log(hello2.padRight(5, "."));
console.log(hello2.padRight(10, "."));
console.log(hello2.padRight(2, "."));

var character = "*";
console.log(character.repeat(5));
// Alternative syntax
console.log("~".repeat(3));
console.log();

// Another combination
console.log("*".repeat(5).padLeft(10, "-").padRight(15, "+"));










