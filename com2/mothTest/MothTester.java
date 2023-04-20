package com2.mothTest;

import com.moth.Moth;

public class MothTester {
    public static void main(String[] args) {
        Moth moth = new Moth(1, 1);
        System.out.println(moth);
        moth.moveToLight(2, 2);
        System.out.println(moth);
        moth.moveToLight(3, 3);
        System.out.println(moth);
    }

}
