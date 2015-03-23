var DOMManipulation = (function () {
    // Appends a child item to parent element
    function appendChild(element, child){
        var parent = retrieveElements(element);
        var childNode = document.createElement(child);

        for (var i = 0; i < parent.length; i++) {
            parent[i].appendChild(childNode.cloneNode());
        }
    }

    // Removes the first child item from parent element
    function removeChild(element, child){
        var parent = retrieveElements(element);
        
        for (var i = 0; i < parent.length; i++) {
            var childToRemove = parent[i].querySelector(child);
            parent[i].removeChild(childToRemove);
        }
    }
//    var add_the_handlers = function (nodes) {
//        var i;
//        for (i = 0; i < nodes.length; i += 1) {
//            nodes[i].onclick = function () {
//                alert(i);
//            };
//        }
//    };
//
//    var add_the_handlers = function (nodes) {
//        var i;
//        for (i = 0; i < nodes.length; i += 1) {
//            nodes[i].onclick = function (i) {
//                return function () {
//                    console.log(i);
//                };
//            }(i);
//        }
//    };
    // Adds a event to all selected elements
    function addHandler(selector, eventType, eventHandler) {
        var elements = retrieveElements(selector);
        add_the_handlers(elements);
        for (var i = 0; i < elements.length; i++) {
            elements[i].addEventListener(eventType, eventHandler);
        }
    }

    // Retrieves elements by a given CSS selector.
    // I decided to make this function private
    function retrieveElements(selector) {
        return document.querySelectorAll(selector);
    }

    // Public functions
    return {
        appendChild: appendChild,
        removeChild: removeChild,
        addHandler: addHandler
    };

})();


// Tests
DOMManipulation.appendChild("ul", "li");
DOMManipulation.removeChild("ul", "li");
DOMManipulation.addHandler("li", "click", function(){ alert("I'm a bird!") });




