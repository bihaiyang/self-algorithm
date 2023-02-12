package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bihaiyang
 * @desc
 * @since 2023/01/04
 */
public class Reference {
    
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        List<MyResource> list = new ArrayList<>();
        list.add(new MyResource(new String("a"), queue));
        list.add(new MyResource(new String("b"), queue));
        list.add(new MyResource(new String("c"), queue));
        
        System.gc();
        Thread.sleep(100);
        Object ref;
        while ((ref = queue.poll()) != null){
            if(ref instanceof MyResource){
                ((MyResource) ref) .clean();
            }
        }
    }
    
    static class MyResource extends PhantomReference<String> {
    
        /**
         * Creates a new phantom reference that refers to the given object and is registered with the given
         * queue.
         *
         * <p> It is possible to create a phantom reference with a <tt>null</tt>
         * queue, but such a reference is completely useless: Its <tt>get</tt> method will always return
         * null and, since it does not have a queue, it will never be enqueued.
         *
         * @param referent the object the new phantom reference will refer to
         * @param q        the queue with which the reference is to be registered,
         */
        public MyResource(String referent, ReferenceQueue<? super String> q) {
            super(referent, q);
        }
        
        public void clean(){
            System.out.println("clean");
        }
    }
}
