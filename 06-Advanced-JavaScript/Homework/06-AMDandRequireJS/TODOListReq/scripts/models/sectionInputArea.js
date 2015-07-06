define(['models/inputArea', 'models/button'], function (InputArea, Button) {
    function SectionButtonArea() {
        InputArea.call(this, new Button('sectionButton', '+'), 'Add Item...');
    }

    SectionButtonArea.inherits(InputArea);

    return SectionButtonArea;
});


