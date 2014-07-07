package com.sirma.itt.javacourse.pagebeans;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		ArrayList<String> adf = new ArrayList<String>();
		for(int i=0;i<5;i++){
			String line ="";
			line+=i;
			adf.add(line);
		}
		
		PageBean pb = new PageBean(3,adf);
		System.out.println(pb.next());
		
	}
}
