package com.example.demo;

import java.util.Random;

/**
 * @author hwshin
 */
public class Test {

    //static String APP_NAME_PREFIX = "demo-app";
    static String APP_NAME_PREFIX = "DEMO-APP";

    static String applicationName = "demo-app3";

    static String[] func = {"a", "b", "c"};

    public static void main(String[] args) throws Exception {
        int len = applicationName.length();
        int my = Integer.parseInt(applicationName.substring(len-1, len));
        System.out.println("len: " + len + ", my: " + my);


//        int rand = new Random().nextInt(2000);
//        try {
//            Thread.sleep(rand);
//            System.out.println(rand);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        /*
        int number = 3;

        int len = applicationName.length();
        int my = Integer.parseInt(applicationName.substring(len-1, len));

        System.out.println("Hi, I'm " + applicationName + ".<br>");
        for (int i=0; i<number*10; i++) {
            int rand = new Random().nextInt(number) + 1;
            //System.out.println("rand: " + rand);
            int rand2 = new Random().nextInt(3);
            //System.out.println("rand2: " + rand2);

            if (Math.abs(rand - my) > 0) {
                System.out.println("https://" + APP_NAME_PREFIX + rand + "/" + func[rand2]);
            }
        }
        */
    }
}
