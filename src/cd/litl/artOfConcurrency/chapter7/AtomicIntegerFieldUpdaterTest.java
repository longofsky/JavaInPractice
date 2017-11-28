package cd.litl.artOfConcurrency.chapter7;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    // ����ԭ�Ӹ���������������Ҫ���µĶ�����Ͷ��������
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater
            .newUpdater(User.class, "old");

    public static void main(String[] args) {
        // ���ÿ��ϵ�������10��
        User conan = new User("conan", 10);
        // ���ϳ���һ�꣬������Ȼ������ɵ�����
        System.out.println(a.getAndIncrement(conan));
        // ����������ڵ�����
        System.out.println(a.get(conan));
    }

    public static class User {
        private String name;

        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
