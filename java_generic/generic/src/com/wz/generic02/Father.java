package com.wz.generic02;

public abstract class Father<T1, T2> {
	
}

class C1<T1,T2> extends Father<Integer, T2>{}

class C2<T2> extends Father<Integer, T2>{}

class C3 extends Father<Integer, String>{
	
}

class C4 extends Father<Object, Object>{
	
}
