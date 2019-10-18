package com.practice.coding;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ZigZagIterator {
	
	public static void main(String[] args) {
		ZigZagIterator a = new ZigZagIterator();
		a.solve();
	}
	
	public void solve() {
		Integer[] a = {1,2};
		Integer[] b = {3,4,5,6};
		ZigZagIterator s = new ZigZagIterator(Arrays.asList(a), Arrays.asList(b));
		while(s.hasNext()) {
			System.out.print(s.next()+", ");
		}
		
	}
    
    private Iterator<Integer> i;
    private Iterator<Integer> j;
    private Iterator<Integer> temp;

    ZigZagIterator() {
    	
    }
    
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        
        i = v1.iterator();
        j = v2.iterator();

    }

    public int next() {
        
        if(i.hasNext()) {
            
            temp = i;
            i = j;
            j = temp;
            
        }
        
        return j.next();
        

    }

    public boolean hasNext() {
        
        return i.hasNext() || j.hasNext();

    }

}
