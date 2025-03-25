/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week8labactivity2task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sound Room
 */
public class SubtitleSeqFactory {

    // Return an empty subtitles sequence 
    public static SubtitleSeq getSubtitleSeq() {

        return new SubSeqImplemented();

    }

    // Load a subtitle sequence from an SRT file. If the file does not exist or // is corrupted (incorrect format), null is returned. 
    public static SubtitleSeq loadSubtitleSeq(String fileName) {

        File file = new File("newtext.txt");

        try {
            Scanner scanner = new Scanner(file);

            return new SubSeqImplemented();
            
        } catch (FileNotFoundException e) {

            return null;
        }

    }asdfasdfasdfsd

}
