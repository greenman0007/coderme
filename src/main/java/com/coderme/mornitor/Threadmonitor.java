package com.coderme.mornitor;

import java.util.Map;
import java.util.Set;

public class Threadmonitor {

 

    public static void main(String[] args) {

       Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

       Set<Thread> set = map.keySet();

       for(Thread thread : set){

           System.out.println("检测到线程 ["+thread.getId()+":"+thread.getName()+"],线程详细信息：");

           for(StackTraceElement trace:map.get(thread)){

              System.out.println(trace);

           }

       }

    }

 

}