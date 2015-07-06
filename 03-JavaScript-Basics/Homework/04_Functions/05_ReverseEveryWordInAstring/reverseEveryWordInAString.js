function reverseWordsInString(str){
    var wordsArr = str.split(/\s+/g);
    for (var i in wordsArr) {
        wordsArr[i] =  wordsArr[i].split('').reverse().join('');
    }
    console.log(wordsArr.join(' '));
}

reverseWordsInString('Hello, how are you.');
reverseWordsInString('Life is pretty good, isn’t it?');