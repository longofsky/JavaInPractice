package cd.litl.crazyJava.chapter3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class SimpleEntry<K,V> implements Map.Entry<K,V>,java.io.Serializable {

	private final K key;
	private V value;
	//������������������
	public SimpleEntry (K key,V value) {
		this.key = key;
		this.value = value;
	}
	
	public SimpleEntry(Map.Entry<? extends K,? extends  V> entry) {
		this.key = entry.getKey();
		this.value = entry.getValue();
	}
	
	//��ȡkey
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	//��ȡvalue
	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	//�ı�key-value �����valueֵ
	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V oldValue = this.value;
		this.value = value;
		return oldValue;
	}
	//����key �Ƚ�����entry �Ƿ����
	
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
	
	//����key ����hashcode
	public int hashCode () {
		return key == null ? 0:key.hashCode();
	}
	
	public String toString() {
		return key + "=" +value;
	}
}
public class Set2Map<K,V> extends HashSet<SimpleEntry<K,V>> {

	//ʵ���������key-value �Եķ���
	public void clear() {
		super.clear();
	}
	//�ж��Ƿ����ĳ��key
	public boolean containsKey(Object key) {
		return super.contains(new SimpleEntry<K, V>((K) key,null));
	}
	//�ж��Ƿ����ĳ��value
	public boolean containsValue(Object value) {
		for (SimpleEntry<K,V> se : this) {
			if (se.getValue().equals(value)) {
				return true;
			}
			
		}
		return false;
	}
	//����ָ��key��ȡ��Ӧ��value
	public V getValue(Object key) {
		for (SimpleEntry<K,V> se : this) {
			if (se.getKey().equals(key)) {
				return se.getValue();
			}
			
		}
		return null;
	}
	
	//��ָ����key-value�Է��뼯��
	
	public V put (K key,V value) {
		add(new SimpleEntry<K, V>(key, value));
		return value;
	}
	//����һ��map��key-value�Է���map��
	public void putAll (Map<? extends K,? extends V> m) {
		
		for (K key : m.keySet()) {
			add(new SimpleEntry<K, V>(key, m.get(key)));
		}
	}
	//����ָ����keyɾ����Ӧ��key-value ��
	
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
	//��ȡ��map�а������ٸ�key-value��
	
	public int size() {
		return super.size();
	}
}
