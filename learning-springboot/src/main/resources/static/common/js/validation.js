var Validation = function() {};
Validation.regPhoneNumber = /^1\d{10}$/;

Validation.check = function(reg, value) {
    return reg.test(value);
};

Validation.isPhoneNumber = function(phoneNumber) {
    return Validation.check(Validation.regPhoneNumber, phoneNumber);
};

Validation.isIdentityCardNumber = function(field) {
    var isValid = true;
    var dateOfBirth;
    var dateOfBirthString;

    function isValidChecksum(valuePart, checkPart) {
        var wholeIdCardNumber = valuePart + checkPart;
        var S = 0;
        for (var i = 2; i <= 18; i++) {
            S = S +
                (wholeIdCardNumber.slice(-i).substr(0, 1) * (Math.pow(2,
                    i - 1) % 11));
        }
        var checkSum = (12 - (S % 11)) % 11;
        return checkSum == (checkPart == 'X' ? 10 : checkPart);
    }

    function isCorrectCheckPartFormat(checkPart) {
        return !(checkPart != 'X' && isNaN(checkPart));
    }

    function isAllDigits(argvalue) {
        argvalue = argvalue.toString();
        var validChars = "0123456789";
        var startFrom = 0;
        if (argvalue.substring(0, 2) == "0x") {
            validChars = "0123456789abcdefABCDEF";
            startFrom = 2;
        } else if (argvalue.charAt(0) == "0") {
            validChars = "01234567";
            startFrom = 1;
        } else if (argvalue.charAt(0) == "-") {
            startFrom = 1;
        }
        for (var n = startFrom; n < argvalue.length; n++) {
            if (validChars.indexOf(argvalue.substring(n, n + 1)) == -1)
                return false;
        }
        return true;
    }

    function isValidDate(day, month, year) {
        if (month < 1 || month > 12) {
            return false;
        }
        if (day < 1 || day > 31) {
            return false;
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) &&
            (day == 31)) {
            return false;
        }
        if (month == 2) {
            var leap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
            if (day > 29 || (day == 29 && !leap)) {
                return false;
            }
        }
        return true;
    }
    if (field == null || field.length == 0) {
        return false;
    } else if (field.length == 18) {
        // version 2 ID card xxxxxxYYMMDDzzz
        var valuePart = field.substring(0, 17); // all characters must be
        // numbers - except last
        // character which may be X
        var checkPart = field.substring(17, 18); // must be X or number
        var year = parseInt(field.substring(6, 10));
        var month = parseInt(field.substring(10, 12));
        var day = parseInt(field.substring(12, 14));
        if (isAllDigits(valuePart) && isCorrectCheckPartFormat(checkPart) &&
            (isValidChecksum(valuePart, checkPart)) && !isNaN(year) &&
            !isNaN(month) && !isNaN(day) &&
            isValidDate(day, month, year)) {
            dateOfBirth = new Date(year, month - 1, day);
            dateOfBirthString = year + "/" + month + "/" + day;
        } else {
            isValid = false;
        }
    } else {
        isValid = false;
    }
    // check if the birth day is not in future
    var today = new Date();
    if (dateOfBirth != null && dateOfBirth > today) {
        isValid = false;
    }
    return isValid;
};