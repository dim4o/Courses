function extractHyperlinks(inp){
    var input = '';
    for(var k = 0; k < inp.length; k++){
        input += (inp[k] + ' ');
    }
    var aTag = input[k];
    aTag = input.replace(/\s+/g, ' ');
    aTag = aTag .match(/<(\s+)?a(.*?)>/g);
    for(var i in aTag){
        if(aTag[i].indexOf('href') < 0){
            continue;
        }
        var a = aTag[i].match(/(href)(\s+)?(=)/g);
        if(a == null){
            continue;
        }
        console.log(linkExtract(aTag[i]));
    }

    function linkExtract(string){
        string = string.replace(/<(.*)(href)(\s+)?=(\s+)?/g, '');
        string = string.replace(/>/g, ' ');
        var pos = string.split(' ');
        var i = 0;
        while(pos[i] == '' || pos[i] == ' '){
            i++;
        }
        if(pos[i][0] == '\"'){
            pos[i] = pos[i].substring(1);
        }
        if(pos[i][pos[i].length - 1] == '\"'){
            pos[i] = pos[i].substring(0, pos[0].length-1);
        }
        if(pos[i][0] == '\''){
            pos[i] = pos[i].substring(1);
        }
        if(pos[i][pos[i].length - 1] == '\''){
            pos[i] = pos[i].substring(0, pos[0].length-1);
        }
        return pos[i].replace(/>/g,"");
    }
}
//extractHyperlinks(["<body><ul><li><a    href=\"/\"  id=\"home\">Home</a></li><li><  a    class=\"selected\" href=\"/courses\" >Courses</a>"]);
//extractHyperlinks(['<a href =#tyrt tretre>']);