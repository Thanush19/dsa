/**
//  * @param {integer} init
//  * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let count = init;
    function increment(){
        count++;
        return count;
    }
    function decrement(){
        count--;
        return count;
    }
    function reset(){
        count = init;
        return count;
    }
    return { increment, decrement, reset };
};
    