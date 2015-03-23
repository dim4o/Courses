var specialConsole = (function () {
    // Private function
    function stringFormat(args) {
        var str = args[0];
        for (var i = 0; i < args.length - 1; i++) {
            var reg = new RegExp("\\{" + i + "\\}", "gm");
            if (str.replace(reg, args[i + 1]) == str) {
                throw new Error("Not enough arguments passed to the function!");
            }

            str = str.replace(reg, args[i + 1]);
        }
        return str;
    }
    // Write Line
    function writeLine(args) {
        var str = stringFormat(arguments);
        console.log(str);
    }
    // Write Error
    function writeError(args) {
        var str = stringFormat(arguments);
        console.error(str);
    }
    // Write Warning
    function writeWarning(args) {
        var str = stringFormat(arguments);
        console.warn(str);
    }
    // Write Info
    function writeInfo(args) {
        var str = stringFormat(arguments);
        console.info(str);
    }
    // public functions
    return {
        writeLine: writeLine,
        writeError: writeError,
        writeWarning: writeWarning,
        writeInfo: writeInfo
    }
})();

specialConsole.writeLine("I'm {0} {1} {2}", "Dimcho", "Nedev");
specialConsole.writeLine("Message: hello");
specialConsole.writeLine("Message: {1}", "hello");
specialConsole.writeLine("Object: {0}", { name: "Gosho", toString: function() { return this.name }});
specialConsole.writeError("Error: {0}", "A fatal error has occurred.");
specialConsole.writeWarning("Warning: {0}", "You are not allowed to do that!");
specialConsole.writeInfo("Info: {0}", "Hi there! Here is some info for you.");
specialConsole.writeError("Error object: {0}", { msg: "An error happened", toString: function() { return this.msg }});