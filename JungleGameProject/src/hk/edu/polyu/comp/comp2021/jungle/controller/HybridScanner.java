package hk.edu.polyu.comp.comp2021.jungle.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * A multi-source concurrent input handler that mixes both System.in and explicitly inserted strings as one stream.
 * String feeding is always unblocked while fetching will block if stream cache is empty.
 * Enables one-way UI-to-Controller communication and solves main thread awaiting input deadlock.
 */
public class HybridScanner{

    /**
     * Singleton
     */
    public static final HybridScanner instance=new HybridScanner();

    private BufferedReader sc;
    private ConcurrentLinkedQueue<String> queue;

    /**
     *
     * Daemon thread that reads and caches every lines of inputs from System.in
     */
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
                return;
            }
        }
    }

    private ScannerSubroutine subroutine;

    /**
     *
     * constructor
     */
    public HybridScanner(){
        this.sc=new BufferedReader(new InputStreamReader(System.in));
        this.queue=new ConcurrentLinkedQueue<String>();
        this.subroutine=new ScannerSubroutine(sc,this);
        this.subroutine.start();
    }

    /**
     *
     * gets a line from input cache.
     * method is blocking caller thread until the cache is not empty
     * @return the content
     */
    public String nextLine(){
        while(true){
            if(!queue.isEmpty())
                return queue.poll();
        }
    }

    /**
     *
     * caches a string to the end of the input queue.
     * method is operating synchronized object and will never block the thread.
     * @param s the string
     */
    public void feed(String s){
        queue.add(s);
    }
}
