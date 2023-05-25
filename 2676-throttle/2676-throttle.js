const throttle = function(fn, t) {
    let isThrottled = false, last, timeoutId;

    return function main(...args) {
        if (isThrottled) {
            last = args;
            return;
        }

        if (timeoutId) {
            clearTimeout(timeoutId);
        }


        timeoutId =  setTimeout(() => {
            isThrottled = false;
            if (last) {
                return main(...last);
            }
        }, t);

        isThrottled = true;
        last = null;
        return fn.apply(this, args);
    }
};