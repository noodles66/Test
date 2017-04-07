package hb.initialtest;

/*定义链表的API:
 * void		put(Key key)		向链表中插入一个节点
 * int		get()				查找得到Key值的位置(N值)
 * void		delete()			删除Key值的节点
 * void		deleteMin()			删除最小Key值的节点
 * void 	deleteMax()			删除最大Key值的节点
 * int 		size()				返回这个链表的大小
 */
class LinkedListDemo <Key extends Comparable<Key>>{
	
	/*定义链表类中的私有根节点和私有类节点
	 * 私有类节点中包括值，下一个节点，还有此节点的位置
	 */
	private Node root;
	private class Node{
		private Key key;
		private Node next;
		private int N;
		
		public Node(Key key){
			this.key = key;
			this.N = 1;
		}
	}
	
	/*定义put(Key key)是在链表的结尾插入一个值为key的节点
	 * 如果根节点是空的话，那么直接新建一个节点是根节点，值为key
	 * 否则遍历寻找到最后一个节点，新建一个值为key的节点加入到最后的节点的next
	 * 遍历时每个节点的大小N++
	 */
	public void put(Key key){
		if (this.root == null){
			root = new Node(key);
		}else{
			Node node = root;
			while (node.next != null){
				node.N++;
				node = node.next;
			}
			node.N++;
			node.next = new Node(key);
		}
	}
	
	/*定义get(Key key)方法，返回该节点的位置（N值）
	 * 从根节点处开始判断节点的值是否为key，不是的话到下一个节点去判断
	 * 如果节点是null，表示链表中不存在这个key值，返回0
	 * 否则找到这个节点之后返回node.N
	 */
	
	public int get(Key key){
		Node node = root;
		while (node.key != key){
			node = node.next;
			if (node == null){
				return 0;
			}
		}
		return node.N;
	}
	
	/*定义delete(Key key)方法，删除key值为key的节点
	 * 删除方法涉及到父节点的问题，所以定义两个节点，一个是正常遍历的节点，一个是其父节点
	 * 遍历找到删除的节点及其父节点，遍历的时候每个节点的N--，如果不存在直接返回
	 * 如果这个节点是根节点，那么直接将根节点连接到原来根节点的子节点
	 * 如果这个节点是尾节点，将其父节点的子节点设为null
	 * 如果这个节点在中间，那么将这个节点的子节点和其父节点的子节点相连
	 */
	public void delete(Key key){
		Node node = root;
		Node parent = root;
		while (node.key != key){
			node.N--;
			parent = node;
			node = node.next;
			if(node == null){
				return;
			}
		}
		if (node == root){
			root = node.next;
		}else if (node.next == null){
			parent.next = null;
		}else{
			parent.next = node.next;
		}
	}
	
	/* 定义deleteMin()方法，删除链表中最小的值：
	 * 初始化key为根节点的key值，遍历链表，如果发现节点的值比key值小，那么就更新key值
	 * 遍历到最小节点的key值之后，调用delete()方法将其删除
	 */
	public void deleteMin(){
		Node node = root;
		Key key = node.key;
		while (node != null){
			if (node.key.compareTo(key) < 0){
				key = node.key;
			}
			node = node.next;
		}
		delete(key);
	}
	/*定义deleteMax()方法，删除链表中最大的节点
	 *其方法同deleteMin()方法
	 */
	public void deleteMax(){
		Node node = root;
		Key key = node.key;
		while (node != null){
			if (node.key.compareTo(key) > 0){
				key = node.key;
			}
			node = node.next;
		}
		delete(key);
	}
	
	/*定义size()方法，返回这个链表的大小
	 * 直接返回根节点的大小root.N
	 */
	public int size(){
		return root.N;
	}

	/*定义print()方法，打印链表的所有节点
	 */
	public void print(){
		for (Node node = root; node != null; node = node.next){
			System.out.print(node.key);
		}
		System.out.println();
	}
}
public class LinkedList02 {
	public static LinkedListDemo<Integer> testPut(){
		LinkedListDemo<Integer> list = new LinkedListDemo<Integer>();
		list.put(1);
		list.put(2);
		list.put(3);
		list.put(4);
		list.put(5);
		list.put(6);
		list.put(7);
		list.put(8);
		list.put(9);
		list.put(10);
		return list;
	}
	public static void testPutSize(){
		LinkedListDemo<Integer> list = testPut();
		list.print();
		System.out.println(list.size());

	}
	public static void testDelete(){
		LinkedListDemo<Integer> list = testPut();
		list.deleteMax();
		list.deleteMin();
		list.delete(5);
		list.delete(61);
		list.print();
		System.out.println(list.size());
	}
	public static void testGet(){
		LinkedListDemo<Integer> list = testPut();
		System.out.println(list.get(2));
	}
	public static void main(String args[]){
		testPutSize();
		testDelete();
		testGet();
	}
}
