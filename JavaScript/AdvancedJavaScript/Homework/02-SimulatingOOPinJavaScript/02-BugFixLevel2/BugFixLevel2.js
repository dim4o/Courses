function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
}

Object.defineProperty(Person.prototype, "name", {

    get: function() {
        return this.firstName + " " + this.lastName;
    },
    set: function(val) {
        var nameArr = val.split(" ");
        this.firstName = nameArr[0];
        this.lastName = nameArr[1];
        return this.firstName + " " + this.lastName;
    }
});


var peter = new Person("Peter", "Jackson");
console.log(peter.name);
console.log(peter.firstName);
console.log(peter.lastName);

peter.lastName = "Dobrev";
console.log(peter.name);

peter.firstName = "Ivan";
console.log(peter.name);

peter.name = "Atanas Petkov";
console.log(peter.firstName);
console.log(peter.lastName);





