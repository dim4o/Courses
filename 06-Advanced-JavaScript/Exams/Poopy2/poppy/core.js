var poppy = poppy || {};

(function (scope) {
    "use strict";

    // constants
    var FADE_IN_INTERVAL = 35,
        FADE_OUT_INTERVAL = 40,
        OPACITY_STEP = 0.04;

    function pop(type, title, message, callback) {
        var popup;
        switch (type) {
            case 'success':
                popup = new scope._models.Success(title, message);
                break;
            case 'info':
                popup = new scope._models.Info(title, message);
                break;
            case 'error':
                popup = new scope._models.Error(title, message);
                break;
            case 'warning':
                popup = new scope._models.Warning(title, message, callback);
                break;
        }

        var view = scope._viewFactory.createPopupView(popup);
        document.body.appendChild(view);
        processPopup(view, popup._popupData);
    }

    function processPopup(element, popupData) {
        element.style.opacity = 0;
        fadeIn(element, FADE_IN_INTERVAL);

        // Redirect onClick
        if (popupData.callback) {
            element.addEventListener('click', function () {
                popupData.callback();
            }, false);
        }

        // Fade out Info popup onClick
        if (popupData.closeButton) {
           document.getElementsByClassName('poppy-close-button')[0]
               .addEventListener('click', function () {
               fadeOut(element, FADE_IN_INTERVAL);
           }, false);
        }

        // Auto hide Error popup
        if (popupData.autoHide) {
            setTimeout(function () {
                fadeOut(element, FADE_OUT_INTERVAL);
            }, popupData.timeout);
        }
    }

    // Fade in effect
    function fadeIn(element, interval) {
        var i = 0;
        var fadeInTime = setInterval(function () {
            i+= OPACITY_STEP;
            element.style.opacity = i;
            if (i >= 1) {
               clearInterval(fadeInTime);
            }
        }, interval);
    }

    // Fade out effect
    function fadeOut(element, interval) {
        var i = 1;
        var fadeOutTime = setInterval(function () {
            i-= OPACITY_STEP;
            element.style.opacity = i;
            if (i <= 0) {
                clearInterval(fadeOutTime);
            }
        }, interval);
    }

    scope.pop = pop;

}(poppy));



