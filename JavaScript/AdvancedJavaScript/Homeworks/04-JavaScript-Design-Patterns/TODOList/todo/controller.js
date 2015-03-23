var todo = todo || {};

(function (scope) {

    document.body.addEventListener('click', addElement, false);

    function addElement(el) {
        var currClassName = el.target.className;
        var currElement = el.target;

        var inputNode = currElement.parentNode.firstChild;
        var inputValue = inputNode.value;
        inputNode.value = '';

        switch(currClassName) {
            case 'containerButton':
                addNewSection(currElement, inputValue);
                break;
            case 'sectionButton':
                addNewItem(currElement, inputValue);
                break;
            case 'checkbox':
                changeStatus(currElement);
                break;
            case 'closeButton':
                fadeOut(currElement);
                break;
            default :
                var div = currElement.parentNode.lastChild;
                if (div.className == 'error-visible') {
                    div.className = 'error-hidden';
                }
                break;
        }
    }

    // Event listeners
    // Adds new section to container
    function addNewSection(currElement, inputValue) {
        showOrHideErrorMsg(currElement, inputValue);
        var errorDiv = currElement.parentNode.lastChild.className;
        if ( errorDiv !== 'error-visible') {
            var currSection = new scope._models.Section(inputValue);
            currSection._addToDOM(document.getElementById('container'));
            // edit
            var len = document.getElementById('container').childNodes.length;
            fadeIn(document.getElementById('container').childNodes[len-2].firstChild);
        }
    }
    // Adds new item to current section
    function addNewItem(currElement, inputValue) {
        showOrHideErrorMsg(currElement, inputValue);
        var errorDiv = currElement.parentNode.lastChild.className;
        if (errorDiv != 'error-visible') {
            var currItem = new scope._models.Item(inputValue, 'todo');
            currItem._addToDOM(currElement.parentNode.parentNode);
            // edit
            var len = currElement.parentNode.parentNode.childNodes.length;
            fadeIn(currElement.parentNode.parentNode.childNodes[len-2].firstChild);
        }
    }
    // change item status from 'done' to 'to-do' or or vice versa
    function changeStatus(currElement) {
        var currStatus = currElement.parentNode.childNodes[1].className;
        if ( currStatus === 'todo') {
            currElement.parentNode.childNodes[1].className = 'done';
        } else {
            currElement.parentNode.childNodes[1].className = 'todo';
        }
    }
    // removes specific element from DOM
    function removeElement(currElement) {
        if (currElement.parentNode.parentNode) {
            currElement.parentNode.parentNode
                .removeChild(currElement.parentNode);
        }
    }

    // Fade-out element
    function fadeOut(currElement) {
        var i = 100;
        var interval = setInterval(function () {
            currElement.parentNode.style.opacity = i/100;
            i--;
            if (i == 0) {
                removeElement(currElement);
                clearInterval(interval);
            }
        }, 3);
    }

    // Fade-in element
    function fadeIn(currElement) {
        var i = 1;
        var interval = setInterval(function () {
            currElement.parentNode.style.opacity = i/100;
            i++;
            if (i == 100) {
                clearInterval(interval);
            }
        }, 3);
    }
    // Error message - show or hide
    function showOrHideErrorMsg(currElement, inputValue) {
        var div = currElement.parentNode.lastChild;
        var value = inputValue.replace(/\s+/g, '');
        if (!value) {
            div.className = 'error-visible';
        } else {
            div.className = 'error-hidden';
        }
    }

}(todo));