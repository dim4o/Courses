define(['models/parentElement', 'models/button', 'models/sectionInputArea', 'view/view', 'libs/inherits'],
    function (ParentElement, Button, SectionInputArea, view) {
    // Section element

    function Section(title) {
        ParentElement.call(this, title);
        this._inputArea = new SectionInputArea();
        this._closeButton = new Button('closeButton', 'x');
    }
    Section.inherits(ParentElement);


    Section.prototype.buildElementNode = function () {
        return view.buildSectionNode(this);
    };

    return Section;

});
