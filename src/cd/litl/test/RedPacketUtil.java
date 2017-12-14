package cd.litl.test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RedPacketUtil {

    // 最小红包额度 金额以分为单位
    private static final int MINMONEY = 1;

    // 最大红包额度
    private static int MAXMONEY = 200 * 100;

    // 最大红包额度初始比值
    private static final double MAXMONEYP = 0.9;

    // 记总次数
    private static int SUM = 0;

    // 保存每次得到红包最大的人以及次数
    private static Map<String, Integer> maxPersonMap = new HashMap<String, Integer>();

    /**
     * @param money
     * @param count
     * @return
     * @Author:litl
     * @Description: 拆分红包
     */
    public Map<String, Integer> splitRedPackets(int money) {

        // 定义一个String数组，模拟随机抢到红包的前10个人
        String[] arrayPerson = { "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj" };

        int i = 0;

        int count = arrayPerson.length;

        // 记录每次抢红包的结果，并进行保存
        Map<String, Integer> map = new TreeMap<String, Integer>();

        for (String person : arrayPerson) {

            if (!isRight(money, count)) {
                return null;
            }
            // 红包最大金额为红包总金额的90%
            int max = (int) (money * MAXMONEYP);
            MAXMONEY = max;
            // 获取单个红包的金额
            int one = random(money, MINMONEY, max, count - i);

            if (maxPersonMap.containsKey(person) && maxPersonMap.get(person) > SUM * 0.3 - 1) {

                while (one > money / count) {
                    one = random(money, MINMONEY, max, count - i);
                }

            }

            map.put(person, one);

            money -= one;
            i++;

        }

        SUM++;
        return map;
    }

    /**
     * @param money
     * @param minS
     * @param maxS
     * @param count
     * @return
     * @Author:litl
     * @Description: 随机红包额度
     */
    private int random(int money, int minS, int maxS, int count) {
        // 红包数量为1，直接返回金额
        if (count == 1) {
            return money;
        }
        // 如果最大金额和最小金额相等，直接返回金额
        if (minS == maxS) {
            return minS;
        }
        int max = maxS > money ? money : maxS;
        // 随机产生一个红包
        int one = ((int) Math.rint(Math.random() * (max - minS) + minS)) % max + 1;
        int money1 = money - one;
        // 判断该种分配方案是否正确
        if (isRight(money1, count - 1)) {
            return one;
        } else {
            double avg = money1 / (count - 1);
            if (avg < MINMONEY) {
                // 递归调用，修改红包最大金额
                return random(money, minS, one, count);
            } else if (avg > MAXMONEY) {
                // 递归调用，修改红包最小金额
                return random(money, one, maxS, count);
            }
        }
        return one;
    }

    /**
     * @param money
     * @param count
     * @return
     * @Author:litl
     * @Description: 此种红包是否合法
     */
    private boolean isRight(int money, int count) {
        double avg = money / count;
        if (avg < MINMONEY) {
            return false;
        }
        if (avg > MAXMONEY) {
            return false;
        }
        return true;
    }

    /**
     * @param map
     * @param count
     * @return
     * @Author:litl
     * @Description: 此种红包是否合法
     */
    private static void getMaxPerson(Map<String, Integer> map) {

        String personKey = null;
        int flag = 0;

        for (String person : map.keySet()) {

            if (map.get(person) > flag) {

                personKey = person;
                flag = map.get(person);
            }
        }

        if (null != personKey) {
            if (maxPersonMap.containsKey(personKey)) {

                maxPersonMap.put(personKey, maxPersonMap.get(personKey) + 1);
            } else {
                maxPersonMap.put(personKey, 1);
            }
        }

    }

    public static void main(String[] args) {

        RedPacketUtil util = new RedPacketUtil();
        Map<String, Integer> map = null;

        // 模拟20次发红包
        for (int i = 0; i < 20; i++) {
            map = util.splitRedPackets(2000);

            // 保存手气最好的人
            getMaxPerson(map);

            for (String person : map.keySet()) {
                System.out.println(person + "-" + map.get(person));
            }

            
            for (String person : maxPersonMap.keySet()) {
                System.out.println(person + "-" + maxPersonMap.get(person));
            }

            // 清空
            map.clear();
        }

        maxPersonMap.clear();

    }
}
