package hb.initialtest;

/*����FibonacciDemo��API:
 * 			FibonacciDemo(int N)	��ʼ��	����N��ʾ��N��쳲���������
 * void 	fibonacci()				ѭ�����쳲���������
 * void     print()					��ӡ쳲���������
 */
class FibonacciDemo{
	private int[] list;
	private int N;
	
	public FibonacciDemo(int N){
		list = new int[N];
		list[0] = 1;
		list[1] = 1;
		this.N = N;
	}
	
	/*����fibonacci()�������õ���ʼ��Nֵ��쳲���������
	 * ���NС�ڵ���2�Ļ������������еĳ�ʼֵ
	 * ����������еĵ�����Ԫ�ؿ�ʼ����Ԫ�ص���ǰ����Ԫ�صĺ�
	 */
	public void fibonacci(){
		if (N <= 2){
			return;
		}else{
			for (int i = 2; i<N; i++){
				list[i] = list[i-1] + list[i-2];
			}
		}
	}
	
	public void print(){
		for (int i =0; i < list.length; i++){
			System.out.print(list[i] + ",");
		}
		System.out.println();
	}
}

public class Fibonacci02 {
	public static void testFibonacci(int N){
		FibonacciDemo fib = new FibonacciDemo(N);
		fib.fibonacci();
		fib.print();
	}
	public static void main (String args[]){
		testFibonacci(100);
	}
}
