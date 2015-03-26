var poppy = poppy || {};

(function (scope) {

    "use strict";

    var Notification = (function( ) {
        function Notification(title, message, position, type, closeButton, autoHide, timeOut, callback) {
            this._popupData = {
                position: position,
                type: type,
                autoHide: autoHide,
                timeout: timeOut,
                closeButton: closeButton,
                title: title,
                message: message,
                callback: callback
            };
        }
        return Notification;
    }());

    var Success = (function() {
        function Success(title, message) {
            Notification.call(this, title, message, 'bottomLeft', 'success', false, false);
        }
        Success.inherits(Notification);
        return Success;
    }());

    var Info = (function() {
        function Info(title, message) {
            Notification.call(this, title, message, 'topLeft', 'info', true, false);
        }
        Info.inherits(Notification);
        return Info;
    }());

    var Warning = (function() {
        function Warning(title, message, callback) {
            Notification.call(this, title, message, 'bottomRight', 'warning', false, false, 0, callback);
        }
        return Warning;
    }());

    var Error = (function() {
        function Error(title, message) {
            Notification.call(this, title, message, 'topRight', 'error', false, true, 2000)
        }
        Error.inherits(Notification);
        return Error;
    }());


    scope._models = {
        Success: Success,
        Info: Info,
        Error: Error,
        Warning: Warning
    }
}(poppy));