/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprint;

/**
 *
 * @author Siddharth
 */

import java.io.FileInputStream;
import java.security.MessageDigest;
import javax.swing.*;

import sun.misc.BASE64Encoder;
public class FingerPrint {

    /**
     * @param args the command line arguments
     */
   
        // TODO code application logic her..

/**
 * Builds the finger print of file, crypto hash value
 */

  public static void main(String[] args) throws Exception {
    // get the file path e.g. c:\Docs\zigzag.txt
    String inputText = JOptionPane.showInputDialog("file path to be encrypted  ");

    // trying to build new message digest which represents and encapsulates
    // the Message Java Digest

    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    // calculating from the given file running its inside
    // while calculating the digest formula

    FileInputStream input = new FileInputStream(inputText);
    byte[] buffer = new byte[8192];
    int length;
    while( (length = input.read(buffer)) != -1 ) {
      messageDigest.update(buffer, 0, length);
    }
    byte[] raw = messageDigest.digest();

    //printout in 64 base
    BASE64Encoder encoder = new BASE64Encoder();
    String base64 = encoder.encode(raw);

    // and display the results
    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                                  "your file finger print is "
                                  + new String(base64.toString()));


  } // main method end

}  // class end
