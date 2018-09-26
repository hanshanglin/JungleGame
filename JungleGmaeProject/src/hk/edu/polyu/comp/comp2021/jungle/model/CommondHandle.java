package hk.edu.polyu.comp.comp2021.jungle.model;

public class CommondHandle {
    public static void checkCommond(String cmd){
        if(cmd == "new game") creatHandle();
        if(cmd == "load path") openHandle("");/** */
        if(cmd == "move xy xy") moveHandle(-1,-1,-1,-1);
        if(cmd == "save path") saveHandle("");
    }
    private static void saveHandle(String path){

    }
    private static void creatHandle(){

    }
    private static void openHandle(String path){

    }
    private static void moveHandle(int x1,int y1,int x2,int y2){

    }
}

