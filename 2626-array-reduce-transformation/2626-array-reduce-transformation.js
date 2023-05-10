/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let len = nums.length;
    let val = init;
    //base case
    if(len === 0)
        return init;
    
    for( let value of nums){
        
        val = fn(val, value)
    }
    return val;
};