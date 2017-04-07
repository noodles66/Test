package hb.initialtest;

/*定义FibonacciDemo的API:
 * 			FibonacciDemo(int N)	初始化	输入N表示求N个斐波那契序列
 * void 	fibonacci()				循环求得斐波那契序列
 * void     print()					打印斐波那契序列
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
	
	/*定义fibonacci()方法，得到初始化N值的斐波那契数列
	 * 如果N小于等于2的话，返回数列中的初始值
	 * 否则从数列中的第三个元素开始，该元素等于前两个元素的和
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
