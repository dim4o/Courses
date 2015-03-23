function traverse(selector) {
    var node = document.querySelector(selector);
    traverseNode(node, '');
    function traverseNode(node, spacing) {
        spacing = spacing || '  ';
        console.log(spacing + node.nodeName.toLocaleLowerCase() + ":" + getAttributes(node));

        for (var i = 0, len = node.childNodes.length; i < len; i += 1) {
            var child = node.childNodes[i];
            if (child.nodeType === document.ELEMENT_NODE) {
                traverseNode(child, spacing + '  ');
            }
        }
    }
}

// formats and returns string with all tag's attributes
function getAttributes(node) {
    var result = " ";
    var atts = node.attributes;
    for (var i = 0; i < atts.length; i++) {
        result += atts[i].nodeName  + '=' + '"' + atts[i].value + '"' + ' ';
    }
    return result;
}

traverse(".birds");
