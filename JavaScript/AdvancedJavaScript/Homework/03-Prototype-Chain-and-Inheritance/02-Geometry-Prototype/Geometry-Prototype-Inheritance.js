var shapes = (function () {

    Object.prototype.inherits = function (properties) {
        function F() {}
        var prop;
        F.prototype = Object.create(this);
        for (prop in properties) {
            F.prototype[prop] = properties[prop];
        }

        F.prototype._super = this;
        return new F();
    };

    // Validations
    function isNumber(num) {
        return !isNaN(parseFloat(num)) && isFinite(num);
    }

    function isValidCoordinate(coordinate) {
        if (!isNumber(coordinate)) {
            throw new Error("Invalid point coordinate!");
        }
    }

    function isValidDimension(dim) {

        if (!isNumber(dim) || dim < 0) {
            throw new Error("Invalid dimension!");
        }
    }

    function isValidColor(color) {
        var regEx = /(^#[0-9A-F]{6}$)|(^#[0-9A-F]{3}$)/i;
        if (!regEx.test(color)) {
            throw  new Error("Invalid color hexadecimal format!");
        }
    }

    var point = {
        init: function init(x, y) {
            this.setX(x);
            this.setY(y);
            return this;
        },

        getX: function () {
            return this._x;
        },

        getY: function () {
            return this._y;
        },

        setX: function (x) {
            isValidCoordinate(x);
            this._x = x;
        },

        setY: function (y) {
            isValidCoordinate(y);
            this._y = y;
        },

        toString: function introduce() {
            return "(" + this.getX() + ", " + this.getY() +")";
        }
    };

    var shape = point.inherits({
        init: function init(firstPo, color) {
            this._super.init(firstPo._x, firstPo._y);
            this.setColor(color);
            return this;
        },

        getColor: function () {
            return this._color;
        },

        setColor: function (color) {
            isValidColor(color);
            this._color = color;
        },

        toString: function introduce() {
            return "color = " + this.getColor()
                + ", first point: " + this._super.toString.call(this);
        }
    });

    var line = shape.inherits({
        init: function init(firstPoint, secondPoint, color) {
            this._super.init(firstPoint, color);
            this.setSecondPoint(secondPoint);
            return this;
        },

        getSecondPoint: function () {
            return this._secondPoint;
        },

        setSecondPoint: function (secondPoint) {
            this._secondPoint = secondPoint;
        },

        toString: function introduce() {
            return this._super.toString()
                + ", second point: " + this.getSecondPoint();
        }
    });

    var segment = line.inherits({
        init: function init(firstPoint, secondPoint, color) {
            this._super.init(firstPoint, secondPoint, color);
            return this;
        },
        toString: function introduce() {
            return this._super.toString();
        }
    });

    var triangle = segment.inherits({
        init: function init(firstPoint, secondPoint, thirdPoint, color) {
            this._super.init(firstPoint, secondPoint, color);
            this.setThirdPoint(thirdPoint);
            return this;
        },

        getThirdPoint: function () {
            return this._thirdPoint;
        },

        setThirdPoint: function (thirdPoint) {
            this._thirdPoint = thirdPoint;
        },

        toString: function introduce() {
            return this._super.toString()
                + ", third point: " + this.getThirdPoint();
        }
    });

    var circle = shape.inherits({
       init: function (centerPoint, radius, color) {
           this._super.init(centerPoint, color);
           this._radius = radius;
           return this;
       },

        getRadius: function () {
            return this._radius;
        },

        setRadius: function (radius) {
            this._radius = radius;
        },

       toString: function introduce() {
           var result = this._super.toString()
               + ", radius: " + this._radius;
           return result.replace("first", "center");
       }
    });

    var rectangle = shape.inherits({
        init: function init(startPoint, width, height, color) {
            this._super.init(startPoint, color);
            this.setWidth(width);
            this.setHeight(height);
            return this;
        },

        getWidth: function () {
            return this._width;
        },
        getHeight: function () {
            return this._height;
        },

        setWidth: function (width) {
            isValidDimension(width);
            this._width = width;
        },
        setHeight: function (height) {
            isValidDimension(height);
            this._height = height;
        },

        toString: function toString() {
            return this._super.toString()
            + ", width: " + this.getWidth() + ", "
            + "height: " + this.getHeight();
        }
    });
    return{
        point: point,
        line: line,
        triangle: triangle,
        rectangle: rectangle,
        circle: circle,
        segment: segment
    }
}());

var p1 = Object.create(shapes.point).init(3, "4");
var p2 = Object.create(shapes.point).init(8, 11);
var p3 = Object.create(shapes.point).init(5, 7);

var li = Object.create(shapes.line).init(p1, p2, "#aa3455");
console.log("Line: " + li.toString());

var seg = Object.create(shapes.segment).init(p1, p2, "#aaaaaa");
console.log("Segment: " + seg.toString());

var tri = Object.create(shapes.triangle).init(p1, p2, p3, "#111111");
console.log("Triangle: " + tri.toString());

var rec = Object.create(shapes.rectangle).init(p1, 5, 6, "#333");
console.log("Rectangle: " + rec.toString());

var cir = Object.create(shapes.circle).init(p1, 12, "#778899");
console.log("Circle: " + cir.toString());
