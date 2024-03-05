class MyCircularQueue {
     
     int front=-1;
     int rear=-1;
     int size=0;
     int [] arr;
    public MyCircularQueue(int k) {
        arr=new int[k];
       // this.k=k;
    }
    
    public boolean enQueue(int value) {
        if(size==arr.length)
        {
            return false;
        }
        else if(size==0)
        {
            front=rear=0;
            arr[0]=value;
            size++;
            return true;
        }
        else if(rear<arr.length-1)
        {
            arr[++rear]=value;
            size++;
            return true;
        }
        else if(rear==arr.length-1)
        {
            rear=0;
            arr[0]=value;
            size++;
            return true;
        }
        return false;

    }
    
    public boolean deQueue() {
        if(size==0)
        {
            return false;
        }
        else
        {
            int val=arr[front];
            if(front==arr.length-1) front=0;
            else
                front++;
                size--;
                return true;
                 
        }
       // return false;
    }
    
    public int Front() {
         if(size==0)
        {
            return -1;
        }
        int val =arr[front];
       // front++;
        return val;
    }
    
    public int Rear() {
          if(size==0)
        {
            return -1;
        }
        int val=arr[rear];
        return val;
    }
    
    public boolean isEmpty() {
        if(size==0)
        {
            return true;
        }
        else return false;
    }
    
    public boolean isFull() {
        if(size==arr.length)
        {
            return true;
        }
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */