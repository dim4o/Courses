define(['models/containerButtonArea', 'view/view', 'models/parentElement', 'libs/inherits'],
    function (ContainerButtonArea, view, ParentElement, inherits) {


    function Container(title) {
        ParentElement.call(this, title);
        this._date = new Date();
        this._inputArea =  new ContainerButtonArea();
    }

    Container.inherits(ParentElement);

    Container.prototype.buildElementNode = function () {
        return view.buildContainerNode(this);
    };

    Container.prototype.getDateString = function () {
        var day = this._date.getDate();
        var month = this._date.toString().split(' ')[1];
        var year = this._date.getFullYear();
        return day + "-" + month + "-" + year;
    };

    return Container;
});
