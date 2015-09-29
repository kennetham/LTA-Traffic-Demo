/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myguid;

import java.util.UUID;

/**
 *
 * @author kenneth
 */
public class GenerateUUID {

    public static final void main(String[] args) {
        //generate random UUIDs
        UUID _uuid = UUID.randomUUID();
        UUID _uuid2 = UUID.randomUUID();
        log("UUID: " + _uuid);
        log("UUID2: " + _uuid2);
    }

    private static void log(Object aObject) {
        System.out.println(String.valueOf(aObject));
    }
}
