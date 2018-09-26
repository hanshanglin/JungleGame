package hk.edu.polyu.comp.comp2021.jungle.model;

public class CmdHandle {
    public static void checkCmd(String cmd){
        cmdParsing(cmd);
    }
    private static void cmdParsing(String cmd){
        /** for test , change to regex */
        cmd = cmd.toUpperCase();
        cmd = cmd.trim();
        if (cmd.equals("NEW")) crateHandle();
        else{
            String[] temp = cmd.split(" ");
            if (temp[0]=="OPEN") openHandle(temp[1]);
            else if(temp[0]=="SAVE") saveHandle(temp[1]);
            else if(temp[0]=="MOVE") moveHandle(temp[1].charAt(1)-'A',temp[1].charAt(0),temp[2].charAt(1)-'A',temp[1].charAt(0));
        }



    }
    private static void saveHandle(String path){
        /**
         * if path didn't exist, print error message and ask another command
         * if exist, call save function
         * */

    }
    private static void crateHandle(){
        /**
         * if a game has existed, ask user if need to save(Y/N)
         *  if Y, ask for a path, call saveHandle
         * else open a new game
         * */

    }
    private static void openHandle(String path){
        /**
         * if path didn't exist, print error message and ask another command
         * else load the game
         * */

    }
    private static void moveHandle(int x1,int y1,int x2,int y2){
        /**
         * check if move is allow,
         * if allow refresh the output
         * else ask another command
         * */
    }
}

