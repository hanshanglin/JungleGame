package hk.edu.polyu.comp.comp2021.jungle.model;

import java.util.Scanner;

public class IOController {
    private Scanner sc;
    public IOController(Scanner sc){
        this.sc = sc;
    }

    public void getCommand(){
        CmdHandle.checkCmd(sc.nextLine());
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
}
