define(['models/parentElement', 'models/button', 'view/view', 'libs/inherits'],
    function (ParentElement, Button, view) {
    // Item element

    function Item(content, status) {
        ParentElement.call(this, content);
        this._status = status;
        this._closeButton = new Button('closeButton', 'x');
    }
    Item.inherits(ParentElement);

    Item.prototype.buildElementNode = function () {
        return view.buildItemNode(this);
    };
    return Item;

});

