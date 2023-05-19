var debounce = function (fn, t) {
  let pendingF = [];
  return function (...args) {
    let cur = Date.now();
    for (let obj of pendingF) {
      if (obj.start > cur) {
        clearTimeout(obj.timeout);
      }
    }

    myTimeout = setTimeout(() => fn(...args), t);
    pendingF.push({ timeout: myTimeout, start: cur + t });
  };
};