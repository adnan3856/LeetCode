/**
 * @param {object} obj1
 * @param {object} obj2
 * @return {object}
 */
function objDiff(obj1, obj2) {
    if (obj1 === obj2) { // for int, bools, same reference, etc
        return {};
    }
    else if (obj1 === null || obj2 === null) { // for nulls
        return [obj1, obj2];
    }
    else if (typeof obj1 !== 'object' || typeof obj2 !== 'object') { // if one is not object (and other is)
        return [obj1, obj2];
    }
    else if (Array.isArray(obj1) !== Array.isArray(obj2)) { // if one is array (and the other object)
        return [obj1, obj2];
    }
    else { // if both are objects or arrays
        let out = {};
        for (let key of Object.keys(obj1)) {
            if (key in obj2) { // if key is shared
                out[key] = objDiff(obj1[key], obj2[key]); // recursively compare
                if (Object.keys(out[key]).length == 0) delete out[key] // delete if empty
            }
        }
        return out;
    }
};