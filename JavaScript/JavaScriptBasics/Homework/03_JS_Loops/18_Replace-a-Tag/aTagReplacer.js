function replaceATag(str){
	var aHrefGroup = str.match(/<( {1,})?a(.+)>/g);
	aHrefGroup[0] = aHrefGroup[0].replace(/<( {1,})?a/g,'[URL');
	aHrefGroup[0] = aHrefGroup[0].replace(/a( {1,})?>/g,'URL]');
	aHrefGroup[0] = aHrefGroup[0].replace(/</g, '[');
	aHrefGroup[0] = aHrefGroup[0].replace(/>/g, ']');
	return str.replace(/<( {1,})?a(.+)>/g, aHrefGroup[0]);
}

console.log(replaceATag('<ul>\n<li>\n<a href=http://softuni.bg>SoftUni</a>\n</li>\n</ul>'));