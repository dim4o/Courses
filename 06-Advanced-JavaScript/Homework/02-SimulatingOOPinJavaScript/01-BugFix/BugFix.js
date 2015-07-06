function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.name = this.firstName + " " + this.lastName;
//    return {
//        name: this.firstName + " " + this.lastName,
//        firstName: firstName,
//        lastName: lastName
//    };
}

var peter = new Person("Peter", "Jackson");
console.log(peter.name);
console.log(peter.firstName);
console.log(peter.lastName);
