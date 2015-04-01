define('models/button', function () {
    function Button(buttonType, buttonContent) {
        this._buttonData = {
            'buttonType': buttonType,
            'buttonContent': buttonContent
        }
    }

    return Button;
});

