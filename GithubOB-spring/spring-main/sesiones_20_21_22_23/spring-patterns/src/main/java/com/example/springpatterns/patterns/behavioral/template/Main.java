package com.example.springpatterns.patterns.behavioral.template;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n********************* HOME *****************************");
        HtmlHome home = new HtmlHome();
        System.out.println(home.render());
        System.out.println("**********************************************************");

        System.out.println("\n********************* About Us *****************************");

        HtmlAboutUs about = new HtmlAboutUs();
        System.out.println(about.render());
        System.out.println("**************************************************************");
    }
}
