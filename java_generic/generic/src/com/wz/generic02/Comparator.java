package com.wz.generic02;

public interface Comparator<T> {
}

class interC1<A> implements Comparator {}
class interC2<A> implements Comparator<Integer> {}
class interC3<T, A> implements Comparator<T> {}