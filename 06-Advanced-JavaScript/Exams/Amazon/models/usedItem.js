var models = models || {};

(function (scope) {
    "use strict";

    function UsedItem(title, description, price, condition) {
        scope._Item.apply(this, arguments);
        this.condition = condition;
        this._customerReviews = [];
    }
    UsedItem.inherits(scope._Item);


    scope.getUsedItem = function getUsedItem(title, description, price, condition, customerReviews) {
        return new UsedItem(title, description, price, condition, customerReviews);
    }

}(models));