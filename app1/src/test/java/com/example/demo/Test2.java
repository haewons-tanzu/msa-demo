package com.example.demo;

/**
 * @author hwshin
 */
public class Test2 {

    private final String appName = "HUB-MENU";
    private final String appName1 = "https://hub-menu.apps.paas.local/hub";

    public void test() {
        String source = "http://" + appName + "/hub/rest";
        System.out.println("testhubmenu src: " + source);
        String source1 = "http://" + appName1 + "/hub/rest";
        System.out.println("testhubmenu src: " + source1);

    }

    public static void main(String args[]) {
        Test2 test = new Test2();
        test.test();
    }


}
