function extractContent(str){
    return str.replace(/<(.*?)>/g, "");
}

console.log(extractContent("<p>Hello</p><a href='http://w3c.org'>W3C</a>"));
console.log(extractContent("<td>Some text. The <span>problem</span> to <span>Some-text</span>the<s>aha</s>Alabala with</td>"));
