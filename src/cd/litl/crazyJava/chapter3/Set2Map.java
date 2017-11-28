package cd.litl.crazyJava.chapter3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class SimpleEntry<K,V> implements Map.Entry<K,V>,java.io.Serializable {

	private final K key;
	private V value;
	//定义如下两个构造器
	public SimpleEntry (K key,V value) {
		this.key = key;
		this.value = value;
	}
	
	public SimpleEntry(Map.Entry<? extends K,? extends  V> entry) {
		this.key = entry.getKey();
		this.value = entry.getValue();
	}
	
	//获取key
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	//获取value
	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	//改变key-value 里面的value值
	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	//根据key 比较两个entry 是否相等
	
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (o.getClass() == SimpleEntry.class) {
			SimpleEntry se = (SimpleEntry)o;
			return se.getKey().equals(getKey());
		}
		
		return false;
	}
	
	//根据key 计算hashcode
	public int hashCode () {
		return key == null ? 0:key.hashCode();
	}
	
	public String toString() {
		return key + "=" +value;
	}
}
public class Set2Map<K,V> extends HashSet<SimpleEntry<K,V>> {

	//实现清空所有key-value 对的方法
	public void clear() {
		super.clear();
	}
	//判断是否包含某个key
	public boolean containsKey(Object key) {
		return super.contains(new SimpleEntry<K, V>((K) key,null));
	}
	//判断是否包含某个value
	public boolean containsValue(Object value) {
		for (SimpleEntry<K,V> se : this) {
			if (se.getValue().equals(value)) {
				return true;
			}
			
		}
		return false;
	}
	//根据指定key获取对应的value
	public V getValue(Object key) {
		for (SimpleEntry<K,V> se : this) {
			if (se.getKey().equals(key)) {
				return se.getValue();
			}
			
		}
		return null;
	}
	
	//将指定的key-value对放入集合
	
	public V put (K key,V value) {
		add(new SimpleEntry<K, V>(key, value));
		return value;
	}
	//将另一个map的key-value对放入map中
	public void putAll (Map<? extends K,? extends V> m) {
		
		for (K key : m.keySet()) {
			add(new SimpleEntry<K, V>(key, m.get(key)));
		}
	}
	//根据指定的key删除对应的key-value 对
	
	public V removeEntry (Object key) {
		for (Iterator<SimpleEntry<K, V>> it = this.iterator();it.hasNext();) {
			SimpleEntry<K, V> em = (SimpleEntry<K, V>)it.next();
			if(em.getKey().equals(key)) {
				V v = em.getValue();
				it.remove();
				return v;
			}
		}
		return null;
	}
	//获取该map中包含多少个key-value对
	
	public int size() {
		return super.size();
	}
}
