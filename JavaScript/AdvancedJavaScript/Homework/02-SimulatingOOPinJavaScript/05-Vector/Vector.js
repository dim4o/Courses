var Vector = (function () {
    // Constructor
    function Vector(components) {
        this._components = components;
        if ( this._components === undefined || this._components.length === 0) {
            throw new Error("Invalid argument!");
        }
        this._vectorLength = this._components.length;
    }
    
    // Private method
    function componentsCompatibilityCheck(currVector, otherVector) {
        var currVectorLen = currVector._components.length;
        var otherVectorLen = otherVector._components.length;

        if (currVectorLen != otherVectorLen) {
            throw new Error("The vectors have different dimensions.");
        }
    }
    // Prototypes
    Vector.prototype = {

        add: function addVector(vector) {

            componentsCompatibilityCheck(this, vector);
            var newComponents = [];

            for (var i = 0; i < this._vectorLength; i++) {
                newComponents[i] = this._components[i] + vector._components[i];
            }

            return new Vector(newComponents);
        },

        subtract: function subtractVector(vector) {

            componentsCompatibilityCheck(this, vector);
            var newComponents = [];
            var len = this._components.length;

            for (var i = 0; i < this._vectorLength; i++) {
                newComponents[i] = this._components[i] - vector._components[i];
            }

            return new Vector(newComponents);
        },

        dot: function dot(vector) {

            componentsCompatibilityCheck(this, vector);

            var dotResult = 0;

            for (var i = 0; i < this._vectorLength; i++) {
                dotResult += this._components[i] * vector._components[i];
            }

            return dotResult;
        },

        norm: function normVector(vector) {
            var normResult = 0;

            for (var i = 0; i < this._vectorLength; i++) {
                normResult += this._components[i] * this._components[i];
            }

            return Math.sqrt(normResult);
        },

        toString: function vectorToString() {
            if (this._components instanceof Array) {
                var components = this._components;
                return "(" + components.join(",") + ")";
            } else {
                return this;
            }
        }
    };
    return Vector;
}());
var a1 = new Vector([1, 2, 3]);
var b1 = new Vector([4, 5, 6]);
var c1 = new Vector([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]);
console.log(a1.toString());
console.log(c1.toString());

// The following throw errors
//var wrong = new Vector();
//var anotherWrong = new Vector([]);


var a2 = new Vector([1, 2, 3]);
var b2 = new Vector([4, 5, 6]);
var c2 = new Vector([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]);
var result1 = a2.add(b2);
console.log(result1.toString());

//a2.add(c2); // Error

var a3 = new Vector([1, 2, 3]);
var b3 = new Vector([4, 5, 6]);
var c3 = new Vector([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]);
var result2 = a3.subtract(b3);
console.log(result2.toString());

//a3.subtract(c3); // Error

var a4 = new Vector([1, 2, 3]);
var b4 = new Vector([4, 5, 6]);
var c4 = new Vector([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]);
var result3 = a4.dot(b4);
console.log(result3.toString());

//a4.dot(c4); // Error

var a = new Vector([1, 2, 3]);
var b = new Vector([4, 5, 6]);
var c = new Vector([1, 1, 1, 1, 1, 1, 1, 1, 1, 1]);
console.log(a.norm());
console.log(b.norm());
console.log(c.norm());
console.log(a.add(b).norm());


