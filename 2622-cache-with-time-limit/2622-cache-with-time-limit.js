var TimeLimitedCache = function() {
    this.result = {};
    this.total = 0;
    this.oldRef = undefined;
};

TimeLimitedCache.prototype.set = function(key, value, duration) {
    if(this.result[key]){
        this.result[key] = value;
        clearInterval(this.oldRef);
        this.oldRef = setTimeout(() => { 
            delete this.result[key];
            this.total = this.total - 1;
            }, duration);
        return true;
    } else {
        this.result[key] = value;
        this.total = this.total + 1;
        this.oldRef = setTimeout(() => { 
            delete this.result[key];
            this.total = this.total - 1;
            }, duration);
        return false;
    }
};

TimeLimitedCache.prototype.get = function(key) {
    if(this.result[key]) {
        return this.result[key];
    }
    return -1;
};

TimeLimitedCache.prototype.count = function() {
    return this.total;
};