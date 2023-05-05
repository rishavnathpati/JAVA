package Packages.mothTest;

import Packages.moth.Moth;

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
