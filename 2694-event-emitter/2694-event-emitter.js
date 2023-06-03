class EventEmitter {
  constructor(){
    this.subscriptionList = {};
  }

  subscribe(event, cb) {
      if( this.subscriptionList[event] ){
        this.subscriptionList[event].push( cb )
      }else{
        this.subscriptionList[event] = [];
        this.subscriptionList[event].push( cb )
      }

    return {
        unsubscribe: () => {
            this.subscriptionList[event].shift();
        }
    };

  }

  emit(event, args = []) {
    let res = [];
    if( this.subscriptionList[event] ){
        this.subscriptionList[event].forEach( (item)=>{
            // res = [...res, item(...args) ]
            console.log(item)
            res.push( item(...args) )
        })
    }
    return res;
  }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */