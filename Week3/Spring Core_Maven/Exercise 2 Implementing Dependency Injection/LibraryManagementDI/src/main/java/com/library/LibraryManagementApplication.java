package com.library;

import com.library.service.ReaderHelp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApplication {

public static void main(String[] args) {

ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
ReaderHelp rh = (ReaderHelp) ctx.getBean("helperGuy");
rh.doSomething();

}

}
