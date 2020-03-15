package com.example.caricature.study;

/**
 * 继承的学习
 */


class  Art {
    Art(int i){
        System.out.println("Art");
    }
}

class  Drawing extends Art {
    Drawing(int i){
        super(i);
        System.out.println("Drawing");
    }
}

public  class Jicheng extends  Drawing{
    public Jicheng(int i){
        super(i);
        System.out.println("Cartoon");
    }

    public static void main(String[] args) {
        Jicheng jicheng =new Jicheng(1);
    }
}