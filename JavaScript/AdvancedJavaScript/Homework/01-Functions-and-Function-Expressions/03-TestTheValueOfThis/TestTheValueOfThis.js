// Create a function testContext() with no parameters.
// The function should print the this object.
function testContext() {

    console.log(this);
}

// Call the function three times

// 1. From the global scope
testContext();
// result: global object

// 2. Inside another function
function test() {
    testContext();
}
test();
// result: global object

// 3. As an object (for example, using new testContext())
new testContext();
// result: empty object