package genericArrays;


import java.util.Arrays;


public class MyList<T> {
	public Object[] t;
	public Object[] tempArray;
	int arrSize=0;
	public int capacity=10;
	
	
	@SuppressWarnings("unchecked")
	public MyList() {
		
		this.t=(T[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public MyList(int capacity) {
		
		
		this.t=(T[]) new Object[capacity];
	}
	
	
	
	public int size() {			
		return arrSize;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	
	
	public void add(T data) {
		for(int i=0;i<capacity;i++) {
			if(t[i]==null) {
				t[i]=data;
			//showArray(i);
			arrSize++;
			if(arrSize==capacity) {
				capacity=capacity*2;
				tempArray=new Object[capacity];
				for(int j=0;j<t.length;j++) {
					tempArray[j]=t[j];
									
				}
				t=tempArray;
			}
			break;
			}
			
			
		}
			
		
	}
	public Object get(int i) {	
		
		return t[i];
	}
//	public void showArray(int i) {
//		
//			System.out.println(t[i]);
//	}
	
	public void remove(int index) {
		if(index<0&&index>t.length) {
			System.out.println("null");;
		}
		t[index]=null;
		for(int i=index;i<t.length-1;i++) {
			t[i]=t[i+1];
		}
		
	}
	
	//set(int index, T data) : verilen indisteki veriyi yenisi ile de�i�tirme i�lemini yapmal�d�r. Ge�ersiz indis girilerse null d�nd�r�r.
	public void set(int index, T data) {
		if(index<0&&index>t.length) {
			System.out.println("null");;
		}
		t[index]=data;		
	}
	
	public String toString() {
		int stringSize=0;
		for(int i=0;i<t.length;i++) {
			if(t[i]!=null) 
				stringSize++;
		}
		String[] s=new String[stringSize];
		for(int i=0;i<t.length;i++) {
			if(t[i]!=null) {
			s[i]=String.valueOf(t[i]);	
			}				
		}
		String aString=Arrays.toString(s);
		return aString ;
		
	}
	
	//int indexOf(T data) : Parametrede verilen nesnenin listedeki indeksini verir. Nesne listede yoksa -1 de�erini verir.
	
	public int indexOf(T data) {
		for(int i=0;i<t.length;i++) {
			if(data==t[i])
				return i;
		}
		return -1;
	}
	
	
	//int lastIndexOf(T data) : Belirtilen ��enin listedeki son indeksini s�yler. Nesne listede yoksa -1 de�erini verir.
	
	public int lastIndexOf(T data) {
		for(int i=t.length-1;i>0;i--) {
			if(data==t[i])
				return i;
			
		}
		return -1;
	}
	
	//boolean isEmpty() : Listenin bo� olup olmad���n� s�yler.
	
	public boolean isEmpty() {
		for(int i=0;i<t.length;i++) {
			if(t[i]!=null) {
				return false;
			}			
		}
		return true;
	}
	
	//T[] toArray() : Listedeki ��eleri, ayn� s�rayla bir array haline getirir.
	
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		
		
		return Arrays.copyOf((T[]) t, arrSize);
	}
	
	//clear() : Listedeki b�t�n ��eleri siler, bo� liste haline getirir.
	
	public void clear() {
		for(int i=0;i<t.length;i++) {
			t[i]=null;
		}
	}
	
	//MyList<T> sublist(int start,int finish) : Parametrede verilen indeks aral���na ait bir liste d�ner.
	
	@SuppressWarnings("unchecked")
	public MyList<T> sublist(int start,int finish){
		MyList<T> subl = new MyList<>((finish-start )+1);
        for(int i = start ; i <=finish ; i++){
            subl.add((T) t[i]);
        }
        return subl;
	}
	
	//boolean contains(T data) : Parametrede verilen de�erin dizide olup olmad���n� s�yler.
	
	public boolean contains(T data) {
		for(Object o:t) {
			if(o==data) {
				return true;
			}			
		}
		return false;	
	}
}
