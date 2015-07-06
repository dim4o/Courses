define(['models/container'], function (Container) {

    var buildButton = function(button){
        var resultButton = document.createElement('button');
        resultButton.innerHTML = button._buttonData.buttonContent;
        resultButton.className = button._buttonData.buttonType;
        //resultButton.type = 'submit';
        return resultButton;
    };

    var buildInputArea = function (element) {
        var buttonData = element._button._buttonData;
        var inputNode = document.createElement('input');
        var buttonNode = document.createElement('button');
        var inputArea = document.createElement('div');
        var buttonType = buttonData.buttonType;

        buttonNode.innerHTML = buttonData.buttonContent;
        inputNode.placeholder  = element._inputPlaceholder;
        buttonNode.className = buttonType;

        inputArea.appendChild(inputNode);
        inputArea.appendChild(buttonNode);
        // Error
        var divError = document.createElement('div');
        divError.className = 'error-hidden';
        divError.innerHTML = "this field cannot be empty";

        inputArea.appendChild(divError);
        // Error

        return inputArea;
    };

    var buildContainerNode = function (_container) {
        //var _container = new Container('TODO List');
        var title = _container._value;
        var containerButtonArea = _container._inputArea;
        var data = _container.getDateString();
        var titleNode = document.createElement('h1');
        var containerNode = document.createElement('div');
        var containerButtonAreaNode = buildInputArea(containerButtonArea);
        var dataNode = document.createElement('time');

        containerNode.id = 'container';
        titleNode.innerHTML = title;
        dataNode.innerHTML = data;

        containerNode.appendChild(titleNode);
        containerNode.appendChild(dataNode);
        containerNode.appendChild(containerButtonAreaNode);

        return containerNode;
    };

    var buildSectionNode = function (section) {
        //  alert('rfedfsdfsdfsd');
        var title = section._value;
        var sectionButtonArea = section._inputArea;
        var closerButton = buildButton(section._closeButton);
        var sectionNode = document.createElement('section');
        var titleNode = document.createElement('h2');
        var sectionButtonAreaNode =  buildInputArea(sectionButtonArea);

        titleNode.innerHTML = title;

        sectionNode.appendChild(closerButton);
        sectionNode.appendChild(titleNode);
        sectionNode.appendChild(sectionButtonAreaNode);

        sectionNode.style.opacity = 0;

        return sectionNode;
    };

    var buildItemNode = function (item) {
        var div = document.createElement('div');
        var content = item._value;
        var contentNode = document.createElement('span');
        var checkbox = document.createElement('input');
        var closeButton = buildButton(item._closeButton);


        checkbox.type = 'checkbox';
        checkbox.className = 'checkbox';
        contentNode.className = item._status;
        contentNode.innerHTML = content;

        div.appendChild(checkbox);
        div.appendChild(contentNode);
        div.appendChild(closeButton);

        div.style.opacity = 0;

        return div;
    };

    return  {
        buildInputArea: buildInputArea,
        buildContainerNode: buildContainerNode,
        buildSectionNode: buildSectionNode,
        buildItemNode: buildItemNode
    };
});





