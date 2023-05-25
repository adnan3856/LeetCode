/**
 * @param {Array} arr
 * @return {Matrix}
 */
var jsonToMatrix = function(arr) {
  //find if is object or not
  const isObject = x => (x !== null && typeof x === 'object');

  // helper function to get keys
  const getKeys = item => {
    //base case
    if (!isObject(item)) return [''];

    const res = [];
    //recursive case
    for (const key of Object.keys(item)) {
      const childKeys = getKeys(item[key]);
      for (const childKey of childKeys) {
        res.push(childKey ? `${key}.${childKey}` : key);
      }
    }
    return res;
  }

  //Create new Set of unic keys
  const keysSet = arr.reduce((acc, cur) => {
    getKeys(cur).forEach((key) => acc.add(key));
    return acc;
  }, new Set());

  // Sort set's keys in an array
  const keys = Array.from(keysSet).sort();

  // helper function to get values from key path
  const getValue = (obj, path) => {
    const paths = path.split('.');
    let i = 0, value = obj;
    // iterate along paths to find value
    while (i < paths.length) {
      if (!isObject(value)) break;
      value = value[paths[i++]];
    }

    if (i < paths.length || isObject(value) || value === undefined) return '';
    return value;
  }

  // Build matrix
  const matrix = [keys];
  arr.forEach(obj => {
    matrix.push(keys.map(key => getValue(obj, key)));
  })

  return matrix;
};