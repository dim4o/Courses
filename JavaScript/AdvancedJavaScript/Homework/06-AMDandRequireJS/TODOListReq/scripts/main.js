require.config({
    //baseUrl: 'scripts',
    path: {
        // Models
        button: 'models/button',
        containerButtonArea: 'models/containerButtonArea',
        inputArea: 'models/inputArea',
        item: 'models/item',
        parentElement: 'models/parentElement',
        section: 'models/section',
        sectionInputArea: 'models/sectionInputArea',
        container: 'models/container',
        // Libraries, Core, View
        inherits: 'libs/inherits',
        app: 'core/app',
        view: 'view/view'
    }

});

require(['core/app'],
    function () {

});

