var todo = todo || {};

(function (scope) {
    'use strict';
    Function.prototype.inherits = function(parent) {
        this.prototype = Object.create(parent.prototype);
        this.prototype.constructor = this;
    };

    var Button = (function() {
        function Button(buttonType, buttonContent) {
            this._buttonData = {
                'buttonType': buttonType,
                'buttonContent': buttonContent
            }
        }

        return Button;
    }());

    // Buttons and Input area
    var InputArea = (function() {
        function ButtonArea(button, inputPlaceholder) {
            this._button = button;
            this._inputPlaceholder = inputPlaceholder;
        }

        return ButtonArea;
    }());

    // Section Button Area
    var SectionInputArea = (function() {
        function SectionButtonArea() {
            InputArea.call(this, new Button('sectionButton', '+'), 'Add Item...');
        }

        SectionButtonArea.inherits(InputArea);

        return SectionButtonArea;
    }());

    // Container Button Area
    var ContainerButtonArea = (function() {
        function ContainerButtonArea() {
            InputArea.call(this, new Button('containerButton', 'New Section'), 'Title...');
        }

        ContainerButtonArea.inherits(InputArea);

        return ContainerButtonArea;
    }());

    // Main elements
    // Parent element ~ 'abstract class'
    var ParentElement = (function() {
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
    }());

    // Container element
    var Container = (function() {
        function Container(title) {
            ParentElement.call(this, title);
            this._date = new Date();
            this._inputArea =  new ContainerButtonArea();
        }
        Container.inherits(ParentElement);

        Container.prototype.buildElementNode = function () {
            return scope._view.buildContainerNode();
        };

        Container.prototype.getDateString = function () {
            var day = this._date.getDate();
            var month = this._date.toString().split(' ')[1];
            var year = this._date.getFullYear();
            return day + "-" + month + "-" + year;
        };

        return Container;
    }());

    // Section element
    var Section = (function() {
        function Section(title) {
            ParentElement.call(this, title);
            this._inputArea = new SectionInputArea();
            this._closeButton = new Button('closeButton', 'x');
        }
        Section.inherits(ParentElement);


        Section.prototype.buildElementNode = function () {
            return scope._view.buildSectionNode(this);
        };

        return Section;
    }());

    // Item element
    var Item = (function() {
        function Item(content, status) {
            ParentElement.call(this, content);
            this._status = status;
            this._closeButton = new Button('closeButton', 'x');
        }
        Item.inherits(ParentElement);

        Item.prototype.buildElementNode = function () {
            return scope._view.buildItemNode(this);
        };
        return Item;
    }());

    scope._models = {
        ContainerButtonArea: ContainerButtonArea,
        SectionButtonArea: SectionInputArea,
        Container: Container,
        Section: Section,
        Item: Item
    }
}(todo));

