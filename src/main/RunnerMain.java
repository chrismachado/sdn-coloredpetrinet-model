package main;

import comp.ControlDevice;
import comp.ForwardDevice;
import comp.NetDevice;
import cpn.EncodeDecode;
import cpn.JavaCPN;

import java.io.IOException;
import java.util.Scanner;

public class RunnerMain {

    public static void main(String[] args) throws IOException {
        JavaCPN connS = new JavaCPN();
        JavaCPN connR = new JavaCPN();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            NetDevice netdev = null;
            ForwardDevice fwdev = null;
            ControlDevice ctrdev = null;

            System.out.println("===========================================");
            System.out.println("Starting general communication.");
            System.out.println("Sending port(9000) to CPN tools.");
            connS.accept(9000);

            NetRunner.runSnd(connS, netdev);
            System.out.println("Receive port(9001) from CPN tools.");
            connR.accept(9001);

            fwdev = ForwardRunner.runRcv(connR);
            ForwardRunner.runSnd(connS, fwdev);
            ctrdev = ControlRunner.runRcv(connR);
            ControlRunner.runRcvAct(connR, ctrdev);

            ControlRunner.runDecideAction(connS, ctrdev);

            System.out.println("Ending general communication.");
            System.out.println("===========================================");

            System.out.println("Restart process? y/n");
            String decision = scanner.nextLine();
            if (!decision.equals("y"))
                break;

            connS.disconnect();
            connR.disconnect();
        }
    }
}
