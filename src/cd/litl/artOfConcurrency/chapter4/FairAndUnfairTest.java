package cd.litl.artOfConcurrency.chapter4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);

    private static Lock unfairLock = new ReentrantLock2(false);

    @Test
    public void fair() {
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        // ����5��Job���ԣ�
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            // ����2�δ�ӡ��ǰ��Thread�͵ȴ������е�Thread���ԣ�
        }
    }

    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }
}
