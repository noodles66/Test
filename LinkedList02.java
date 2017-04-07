package hb.initialtest;

/*���������API:
 * void		put(Key key)		�������в���һ���ڵ�
 * int		get()				���ҵõ�Keyֵ��λ��(Nֵ)
 * void		delete()			ɾ��Keyֵ�Ľڵ�
 * void		deleteMin()			ɾ����СKeyֵ�Ľڵ�
 * void 	deleteMax()			ɾ�����Keyֵ�Ľڵ�
 * int 		size()				�����������Ĵ�С
 */
class LinkedListDemo <Key extends Comparable<Key>>{
	
	/*�����������е�˽�и��ڵ��˽����ڵ�
	 * ˽����ڵ��а���ֵ����һ���ڵ㣬���д˽ڵ��λ��
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
	
	/*����put(Key key)��������Ľ�β����һ��ֵΪkey�Ľڵ�
	 * ������ڵ��ǿյĻ�����ôֱ���½�һ���ڵ��Ǹ��ڵ㣬ֵΪkey
	 * �������Ѱ�ҵ����һ���ڵ㣬�½�һ��ֵΪkey�Ľڵ���뵽���Ľڵ��next
	 * ����ʱÿ���ڵ�Ĵ�СN++
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
	
	/*����get(Key key)���������ظýڵ��λ�ã�Nֵ��
	 * �Ӹ��ڵ㴦��ʼ�жϽڵ��ֵ�Ƿ�Ϊkey�����ǵĻ�����һ���ڵ�ȥ�ж�
	 * ����ڵ���null����ʾ�����в��������keyֵ������0
	 * �����ҵ�����ڵ�֮�󷵻�node.N
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
	
	/*����delete(Key key)������ɾ��keyֵΪkey�Ľڵ�
	 * ɾ�������漰�����ڵ�����⣬���Զ��������ڵ㣬һ�������������Ľڵ㣬һ�����丸�ڵ�
	 * �����ҵ�ɾ���Ľڵ㼰�丸�ڵ㣬������ʱ��ÿ���ڵ��N--�����������ֱ�ӷ���
	 * �������ڵ��Ǹ��ڵ㣬��ôֱ�ӽ����ڵ����ӵ�ԭ�����ڵ���ӽڵ�
	 * �������ڵ���β�ڵ㣬���丸�ڵ���ӽڵ���Ϊnull
	 * �������ڵ����м䣬��ô������ڵ���ӽڵ���丸�ڵ���ӽڵ�����
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
	
	/* ����deleteMin()������ɾ����������С��ֵ��
	 * ��ʼ��keyΪ���ڵ��keyֵ����������������ֽڵ��ֵ��keyֵС����ô�͸���keyֵ
	 * ��������С�ڵ��keyֵ֮�󣬵���delete()��������ɾ��
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
	/*����deleteMax()������ɾ�����������Ľڵ�
	 *�䷽��ͬdeleteMin()����
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
	
	/*����size()�����������������Ĵ�С
	 * ֱ�ӷ��ظ��ڵ�Ĵ�Сroot.N
	 */
	public int size(){
		return root.N;
	}

	/*����print()��������ӡ��������нڵ�
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
