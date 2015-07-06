Function.prototype.inherits = function(parent) {
        this.prototype = Object.create(parent.prototype);
        this.prototype.constructor = this;
};