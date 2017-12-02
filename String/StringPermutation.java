package Strings;


import java.util.Vector;

public class StringPermutation {
	Vector<String> obj;
	//String str, subString;

	public static void main(String[] args) {
		String str="abcd";
		StringPermutation obj=new StringPermutation();
		obj.permutation("",str);
		obj.print();
	}
	public StringPermutation() {
		obj = new Vector<String>();
	}
	public void permutation(String prefix, String remaining) {

		if (remaining.length() == 0) {
			if (!obj.contains(prefix)) {
				obj.add(prefix);
				return;
			}
		}
		for (int i = 0; i < remaining.length(); i++) {
		String	newPrefix = prefix + remaining.charAt(i);
		String newRemaining = remaining.substring(0, i)+remaining.substring(i+1, remaining.length());
			permutation(newPrefix, newRemaining);
		}
	}

	public void print() {
		for (int i = 0; i < obj.size(); i++) {
			System.out.println(i + " " + obj.elementAt(i));
		}
	}

}
