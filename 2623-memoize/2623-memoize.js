/**
 * @param {Function} fn
 */
function memoize(fn) {
    let cache = new Map();
    return function(...args) {
        // We need to stringify the array because [1,2] !== [1,2]
        let strArgs = JSON.stringify(args);
        // Check for cached value
        if (cache.has(strArgs)) return cache.get(strArgs);
        // Else cache it
        cache.set(strArgs, fn(...args));
        return cache.get(strArgs);
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */