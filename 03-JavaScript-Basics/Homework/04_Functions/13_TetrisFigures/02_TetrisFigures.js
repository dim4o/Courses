function tetrisFigures (input){
    function checkForm(row, col , form, input){
        for(var i = 0 ; i < form.length ; i++ ){
            if(row + form[i][0] >= input.length ||
                row + form[i][0] < 0 ||
                col + form[i][1] >= input[0].length ||
                col + form[i][1] < 0 ||
                input[row + form[i][0]][col + form[i][1]] != 'o'){
                return false;
            }
        }
        return true;
    }
    var Iform = [[0,0], [1,0], [2,0], [3,0]];
    var Lform = [[0,0], [1,0], [2,0], [2,1]];
    var Jform = [[0,0], [1,0], [2,0], [2,-1]];
    var Oform = [[0,0], [1,0], [1,1], [0,1]];
    var Zform = [[0,0], [0,1], [1,1], [1,2]];
    var Sform = [[0,0], [0,1], [-1,1], [-1,2]];
    var Tform = [[0,0], [0,1], [0,2], [1,1]];

    var result = {"I":0,"L":0,"J":0,"O":0,"Z":0,"S":0,"T":0};
    for(var row = 0; row < input.length; row+=1 ){
        for(var col = 0; col < input[0].length; col+=1){
            if(checkForm(row, col , Iform, input)){
                result["I"]++;
            }
            if(checkForm(row, col , Lform, input)){
                result["L"]++;
            }
            if(checkForm(row, col , Jform, input)){
                result["J"]++;
            }
            if(checkForm(row, col , Oform, input)){
                result["O"]++;
            }
            if(checkForm(row, col , Zform, input)){
                result["Z"]++;
            }
            if(checkForm(row, col , Sform, input)){
                result["S"]++;
            }
            if(checkForm(row, col , Tform, input)){
                result["T"]++;
            }
        }
    }
    console.log(JSON.stringify(result));
}


//var arr = [['-','o', 'o'],['o','o', 'o'],['o','o', 'o']];
//console.log(arr[2][2]);
//tetrisFigures(arr);
//console.log(checkForm(2, 2 , [[0,0], [1,0], [2,0], [2,1]], arr));