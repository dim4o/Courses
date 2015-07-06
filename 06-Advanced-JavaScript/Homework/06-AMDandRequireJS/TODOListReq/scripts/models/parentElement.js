define(['view/view'], function () {
    // Main elements
    // Parent element ~ 'abstract class'

    function ParentElement(value) {
        this.setValue(value);
    }

    ParentElement.prototype.setValue = function (value) {
        if (value == '') {
            throw  new Error("Value can not be empty!");
        }
        this._value = value;
    };

    ParentElement.prototype.buildElementNode = function () {
        return null;
    };

    ParentElement.prototype._addToDOM = function (parent) {
        parent.insertBefore(this.buildElementNode(), parent.lastChild);
    };

    return ParentElement;

});
