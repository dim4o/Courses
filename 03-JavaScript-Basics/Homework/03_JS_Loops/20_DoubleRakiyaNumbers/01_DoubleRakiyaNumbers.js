function printDoubleRakiaNumbers (inputStr){
    var start = parseInt(inputStr[0]);
    var end = parseInt(inputStr[1]);
    console.log("<ul>");
    for(var i = start ; i <= end; i+=1){
        var rowStr = "<li><span class=\'num\'>" + i + "</span></li>";
        if(isDoubleRakiaNum(i.toString())){
            var rowStr = "<li><span class=\'rakiya\'>" + i + "</span>" +
                "<a href=\"view.php?id=" + i + ">View</a></li>";
        }
        console.log(rowStr);
    }
    console.log("</ul>");
    function isDoubleRakiaNum (numberStr) {
        if (numberStr.length < 4){
            return false;
        }
        for(var i = 0; i <= numberStr.length - 4; i+=1){
            var count = 0;
            for(var k = i + 2; k <= numberStr.length - 2; k+=1){
                if((numberStr[i] + numberStr[i+1]) == (numberStr[k] + numberStr[k+1])){
                    return true;
                }
            }
        }
        return false;
    }
}

