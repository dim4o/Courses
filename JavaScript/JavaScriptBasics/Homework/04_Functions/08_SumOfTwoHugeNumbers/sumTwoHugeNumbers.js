function sumTwoHugeNumbers(value) {
    value.sort(function(a,b){return a.length - b.length});
    var smaller = value[0];
    var greater = value[1];
    while(smaller.length != greater.length){
        smaller = '0' + smaller;
    }
    var a = greater.split('').map(Number);
    var b = smaller.split('').map(Number);
    var result = [];
    var reminder = 0;
    for (var i = a.length - 1; i >= 0; i--) {
        result.unshift(((a[i] + b[i])%10 + reminder)%10);
        reminder = Math.floor(((a[i] + b[i])+ reminder)/10);
    }
    console.log(result.join(''));
}

sumTwoHugeNumbers(['155', '65']);
sumTwoHugeNumbers(['123456789', '123456789']);
sumTwoHugeNumbers(['887987345974539','4582796427862587']);
sumTwoHugeNumbers(['347135713985789531798031509832579382573195807','817651358763158761358796358971685973163314321']);
