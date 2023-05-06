var createHelloWorld = function() {
    return function(...args) {
        return `
H   H  EEEEE  L      L      OOOOO        W   W  OOOOO  RRRR   L      DDD  
H   H  E      L      L      O   O        W   W  O   O  R   R  L      D  D 
HHHHH  EEEEE  L      L      O   O        W W W  O   O  R R    L      D   D
H   H  E      L      L      O   O        WW WW  O   O  R  R   L      D  D 
H   H  EEEEE  LLLLL  LLLLL  OOOOO        W   W  OOOOO  R   R  LLLLL  DDD
`.replaceAll(/^[\W\w\r]*$/g, 'Hello World');
    }
};