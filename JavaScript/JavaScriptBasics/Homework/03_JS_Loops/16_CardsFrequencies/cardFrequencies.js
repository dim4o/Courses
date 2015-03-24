function findCardFrequency(str){
    str = str.split(/\W+/);
    var cardFaces = str.slice(0, str.length - 1);
    var cardMap = [];
    for(var index in cardFaces){
        var key = cardFaces[index] + " ";
        if(cardMap.hasOwnProperty(key)){
            cardMap[key]++;
        } else {
            cardMap[key.toString()] = 1;
        }
    }
        for(var key in cardMap){
            var freq = (cardMap[key]/cardFaces.length*100).toFixed(2);
            console.log(key + ' -> ' + freq +'%');
        }
}
findCardFrequency('8♥ 2♣ 4♦ 10♦ J♥ A♠ K♦ 10♥ K♠ K♦');
console.log();
findCardFrequency('J♥ 2♣ 2♦ 2♥ 2♦ 2♠ 2♦ J♥ 2♠');
console.log();
findCardFrequency('10♣ 10♥');