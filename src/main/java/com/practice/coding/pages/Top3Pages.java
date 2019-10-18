package com.practice.coding.pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Top3Pages {
	public List<String> findTop3Pages(Iterator<Tuple> iterator) {
		List<String> result = new ArrayList<>();
		Map<String, List<String>> pageMap = new HashMap<>();
		List<Tuple> list = new ArrayList<>();
		Tuple tmp;
		String page = "";
		
		Set<String> client = new HashSet<>();
		
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		
		for(int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			
			String cl = list.get(i).user;
			
			Tuple a;
			page = "";
			int j = i;
			for(;j < list .size() && j < i + 3 && cl.equals(list.get(j).user); j++) {
				a = list.get(j);
				page+=a.pageId;
			}
			if(j == i + 3) {
				result.add(page);
				
				if(pageMap.get(cl) != null) {
					pageMap.get(cl).add(page);
				} else {
					List<String> t = new ArrayList<>();
					t.add(page);
					pageMap.put(cl, t);
				}
			}
		}
		result.stream().forEach(i-> System.out.println(i));
		
		return result;
	}
	
	class Tuple {
		public String user;
		public Date time;
		public String pageId;
	}
	
	public static void main(String[] args) {
		Top3Pages claz = new Top3Pages();
		List<Tuple> a = new ArrayList<>();
		Tuple c = claz.new Tuple();
		c.pageId = "P1";
		c.time = new Date(17, 01, 10);
		c.user = "1";
		a.add(c);	
		c = claz.new Tuple();
		c.pageId = "P2";
		c.time = new Date(17, 01, 10);
		c.user = "1";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P3";
		c.time = new Date(17, 01, 10);
		c.user = "1";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P3";
		c.time = new Date(17, 01, 10);
		c.user = "1";
		a.add(c);
		
		c = claz.new Tuple();
		c.pageId = "P2";
		c.time = new Date(17, 02, 10);
		c.user = "2";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P1";
		c.time = new Date(17, 02, 10);
		c.user = "2";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P2";
		c.time = new Date(17, 02, 10);
		c.user = "2";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P3";
		c.time = new Date(17, 02, 10);
		c.user = "2";
		a.add(c);
		
		c = claz.new Tuple();
		c.pageId = "P3";
		c.time = new Date(17, 03, 10);
		c.user = "3";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P1";
		c.time = new Date(17, 03, 10);
		c.user = "3";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P2";
		c.time = new Date(17, 03, 10);
		c.user = "3";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P3";
		c.time = new Date(17, 03, 10);
		c.user = "3";
		a.add(c);
		
		c = claz.new Tuple();
		c.pageId = "P4";
		c.time = new Date(17, 04, 10);
		c.user = "4";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P1";
		c.time = new Date(17, 04, 10);
		c.user = "4";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P2";
		c.time = new Date(17, 04, 10);
		c.user = "4";
		a.add(c);
		c = claz.new Tuple();
		c.pageId = "P3";
		c.time = new Date(17, 04, 10);
		c.user = "4";
		a.add(c);
		
		claz.findTop3Pages(a.iterator());
	}
}
