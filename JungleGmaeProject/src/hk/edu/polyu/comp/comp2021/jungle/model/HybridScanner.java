package hk.edu.polyu.comp.comp2021.jungle.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

public class HybridScanner{

    public static final HybridScanner instance=new HybridScanner();

    private BufferedReader sc;
    private ConcurrentLinkedQueue<String> queue;

    private class ScannerSubroutine extends Thread{
        private BufferedReader sc;
        private HybridScanner parent;

        public ScannerSubroutine(BufferedReader sc,HybridScanner parent){
            this.sc=sc;
            this.parent=parent;
        }

        @Override
        public void run(){
            String s;
            try{
            while(true) {
                if ((s = sc.readLine())!=null)
                    parent.feed(s);
            }
            }catch(IOException e){

            }
        }
    }

    private ScannerSubroutine subroutine;

    public HybridScanner(){
        this.sc=new BufferedReader(new InputStreamReader(System.in));
        this.queue=new ConcurrentLinkedQueue<String>();
        this.subroutine=new ScannerSubroutine(sc,this);
        this.subroutine.start();
    }

    public String nextLine(){
        while(true){
            if(!queue.isEmpty())
                return queue.poll();
        }
    }

    public void feed(String s){
        queue.add(s);
    }
}
