public class BinarySemaphore {
    boolean value;
    public BinarySemaphore(boolean initValue) {
        value = initValue;
    }
    public synchronized void P() {
        while (value == false) 
            Util.myWait(this);// in the queue of blocked processes
        value = false;
    }
    public synchronized void V() {
        value = true;
        notify();
    }
}
//when one wants to enter the CS section, it checks whether the value is false, if false, 
//it shows there are people in the bathroom,
//so I would choose to spin and wait. If the value is true, I could go in bathroom, and I should set the value to false
