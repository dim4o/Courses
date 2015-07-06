define(['models/inputArea', 'models/button', 'libs/inherits'], function (InputArea, Button) {

    // Container Button Area

    function ContainerButtonArea() {
        InputArea.call(this, new Button('containerButton', 'New Section'), 'Title...');
    }

    ContainerButtonArea.inherits(InputArea);

    return ContainerButtonArea;

});

