shapes = (function () {
    Function.prototype.inherits = function(parent) {
        this.prototype = Object.create(parent.prototype);
        this.prototype.constructor = this;
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

    // Pseudo classes
    var Point = (function () {
        function Point(x, y) {
            this.setX(x);
            this.setY(y);
        }

        Point.prototype.getX = function () {
            return this._x;
        };
        Point.prototype.setX = function (x) {
            isValidCoordinate(x);
            this._x = x;
        };

        Point.prototype.getY = function () {
            return this._y;
        };
        Point.prototype.setY = function (y) {
            isValidCoordinate(y);
            this._y = y;
        };

        Point.prototype.toString = function () {
            return "(" + this.getX() + ", " + this.getY() + ")";
        };
        return Point;
    }());

    // Shape - abstract class
    var Shape = (function () {
        // constructor
        function Shape(point, color) {
            // not necessary
            if ( this.constructor === Shape) {
                throw Error("Can not instantiate!")
            }
            Point.call(this, point._x, point._y);
            this.setPoint(point);
            this.setColor(color);
        }

        Shape.inherits(Point);

        Shape.prototype.getPoint = function () {
            return this._point;
        };
        Shape.prototype.setPoint = function (point) {
            this._point = point;
        };

        Shape.prototype.getColor = function () {
            return this._color;
        };
        Shape.prototype.setColor = function () {

        };
        Shape.prototype.getColor = function () {
            return this._color;
        };
        // validates color format
        Shape.prototype.setColor = function (color) {
            isValidColor(color);
            this._color = color;
        };

        Shape.prototype.toString = function () {
            return "Color = "+ this.getColor().toUpperCase() + ", First point: "
                + this.getPoint();
        };

        return Shape;
    }());

    var Circle = (function () {
        function Circle(point, radius, color) {
            Shape.call(this, point, color);
            this.setRadius(radius);
        }

        Circle.inherits(Shape);

        Circle.prototype.getRadius = function () {
            return this._radius;
        };
        Circle.prototype.setRadius = function (radius) {
            isValidDimension(radius);
            this._radius = radius;
        };

        Circle.prototype.toString = function () {
            return Shape.prototype.toString.call(this).replace("First", "Center")
                + ", radius: " + this.getRadius();
        };
        return Circle;
    }());

    var Line = (function () {
        function Line(firstPoint, endPoint, color) {
            Shape.call(this, firstPoint, color);
            this.setEndPoint(endPoint);
        }

        Line.inherits(Shape);

        Line.prototype.getEndPoint = function () {
            return this._endPoint;
        };
        Line.prototype.setEndPoint = function (endPoint) {
            this._endPoint = endPoint;
        };

        Line.prototype.toString = function () {
            return Shape.prototype.toString.call(this)
                + ", Second point: " + this.getEndPoint();
        };

        return Line;
    }());

    var Segment = (function () {
        function Segment(firstPoint, endPoint, color) {
            Line.call(this, firstPoint, endPoint, color);
        }

        Segment.inherits(Line);

        return Segment;
    }());

    var Rectangle = (function () {
        function Rectangle(startPoint, width, height, color) {
            Shape.call(this, startPoint, color);
            this.setWidth(width);
            this.setHeight(height);
        }

        Rectangle.inherits(Shape);

        Rectangle.prototype.getWidth = function () {
            return this._witdh;
        };
        Rectangle.prototype.setWidth = function (width) {
            isValidDimension(width);
            this._witdh = width;
        };

        Rectangle.prototype.getHeight= function () {
            return this._height;
        };
        Rectangle.prototype.setHeight = function (height) {
            isValidDimension(height);
            this._height = height;
        };

        Rectangle.prototype.toString = function (){
            return Shape.prototype.toString.call(this)
                + ", width: " + this.getWidth()
                + ", height: " + this.getHeight();
        };
        return Rectangle;
    }());

    var Triangle  = (function () {
        function Triangle(startPoint, secondPoint, thirdPoint, color) {
            Line.call(this, startPoint, secondPoint, color);
            this.setThirdPoint(thirdPoint);
        }
        Triangle.inherits(Line);

        Triangle.prototype.getThirdPoint = function () {
            return this._thirdPoint;
        };
        Triangle.prototype.setThirdPoint = function (thirdPoint) {
            this._thirdPoint = thirdPoint;
        };

        Triangle.prototype.toString = function (){
            return Line.prototype.toString.call(this)
                + ", Third point: " + this.getThirdPoint();
        };
        return Triangle;
    }());

    return {
        Point: Point,
        Line: Line,
        Segment: Segment,
        Rectangle: Rectangle,
        Triangle: Triangle,
        Circle: Circle
    }
}());



var point1 = new shapes.Point("3",5);
var point2 = new shapes.Point(6,"7");
var point3 = new shapes.Point(12, 8);

console.log("Point: " + point1.toString());

var rec = new shapes.Rectangle(point1, "20", 30, "#123ffd");

console.log("Rectangle: " + rec.toString());

var line = new shapes.Line(point1, point2, "#abc");
console.log("Line: " + line.toString());

var tri = new shapes.Triangle(point1, point2, point3, "#Ab4586");
console.log("Triangle: " + tri.toString());

var seg = new shapes.Segment(point1, point2, "#ffF321");
console.log("Segment: " + seg.toString());

var cir = new shapes.Circle(point1, 5, "#aaa");
console.log("Circle: " + cir.toString());