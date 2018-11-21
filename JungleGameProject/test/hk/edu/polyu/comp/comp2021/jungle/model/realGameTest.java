package hk.edu.polyu.comp.comp2021.jungle.model;

import hk.edu.polyu.comp.comp2021.jungle.controller.Controller;
import hk.edu.polyu.comp.comp2021.jungle.view.GameUI;
import hk.edu.polyu.comp.comp2021.jungle.view.UIController;
import org.junit.*;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.security.Permission;


public class realGameTest {

    private boolean Test_Should_Pass=true;
    private boolean Test_Can_Exit=false;

    @Before
    public void setInfoPopupAvailability(){
        try {
            Class c = GameUI.class;
            Field f = c.getDeclaredField("isTestCase");
            f.setAccessible(true);
            f.setBoolean(null,Test_Should_Pass);
        }catch(Exception e){
            e.printStackTrace();
            assert false;
        }
    }

    class SystemExitMonitor extends SecurityManager{
        private boolean canExit;
        private Thread attachedThread;
        private SecurityManager oldman;
        public SystemExitMonitor(boolean canExit){
            this.canExit=canExit;
            oldman=System.getSecurityManager();
        }
        @Override
        public void checkPermission(Permission perm){}
        @Override
        public void checkExit(int status){
            super.checkExit(status);
            if(status==0&&!canExit){
                (new Thread(()->{attachedThread.interrupt();Thread.currentThread().interrupt();})).start();
                while(true);
            }
        }
        public void resetSecurityManager(){System.setSecurityManager(oldman);}
        public void attach(Thread thread){this.attachedThread=thread;}
    }

    @Before
    public void setSystemExitAvailability(){
        try{
            System.setSecurityManager(new SystemExitMonitor(Test_Can_Exit));
        }catch(Exception e){
            e.printStackTrace();
            assert false;
        }
    }

    private SystemExitMonitor getExitBlocker(){return (SystemExitMonitor)System.getSecurityManager();}

    @Before
    public void setUp(){
        ByteArrayInputStream in = new ByteArrayInputStream(("standalone\n" +
                "new\n" +
                "leo\n" +
                "hans\n" +
                "move c3 d3\n" +
                "move a7 a6\n" +
                "move d3 d4\n" +
                "move a6 b6\n" +
                "move d4 d5\n" +
                "move b6 b5\n" +
                "move d5 d6\n" +
                "move b5 b4\n" +
                "move d6 d7\n" +
                "move b4 b3\n" +
                "move d7 d8\n" +
                "move b3 a3\n" +
                "move d8 d9\n\n").getBytes());
        System.setIn(in);
    }

    @Test(timeout = 4000)
    public void testController(){
            Thread testThread=new Thread(()->{
                Controller controller = new Controller();
                UIController.instance.setCurrentController(controller);
                controller.gameSetUp();
            });
            getExitBlocker().attach(testThread);
            testThread.start();
            while(!testThread.isInterrupted());

            assert true;
    }

    @After
    public void enableSystemExit(){
        getExitBlocker().resetSecurityManager();
    }


}