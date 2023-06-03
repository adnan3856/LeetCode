var checkIfInstanceOf = function(obj, classFunction) {
    if(obj === null || obj === undefined || typeof classFunction !== 'function') return false;
    let inputObj = typeof obj === 'object' ? obj : Object(obj);
    return inputObj instanceof classFunction;
};