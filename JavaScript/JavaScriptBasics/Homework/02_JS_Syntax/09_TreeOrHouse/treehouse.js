function treeHouseCompare(a, b){
	var houseArr = (a*a + a*(2/3)*(a/2));
	var treeArr = (b*(b/3) + (4/9)*b*b*Math.PI);
	if (houseArr > treeArr) {
		return 'house/'+ houseArr.toFixed(2);
	} else {
		return 'tree/'+ treeArr.toFixed(2);
	}
}
console.log(treeHouseCompare(3, 2));
console.log(treeHouseCompare(3, 3));
console.log(treeHouseCompare(4, 5));