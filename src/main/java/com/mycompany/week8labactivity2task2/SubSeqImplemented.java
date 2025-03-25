/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week8labactivity2task2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sound Room
 */
public class SubSeqImplemented implements SubtitleSeq {

    //the very big list of subtitles
    ArrayList<Subtitle> subtitleList = new ArrayList<>();

    //so you have to add each subtitle manually
    @Override
    public void addSubtitle(Subtitle st) {
        subtitleList.add(st);
    }

    //returns the list of subtitles you just made
    @Override
    public List<Subtitle> getSubtitles() {
        return subtitleList;
    }

    //gets the subtitle object at the given time
    @Override
    public Subtitle getSubtitle(Time time) {

        //loops through the subtitle list and if the time matches up return it
        for (Subtitle subtitle : subtitleList) {

            if (((SubtitleImplemented) subtitle).getTimeInMilliseconds() == ((TimeImplemented) time).getTimeInMS()) {

                return subtitle;

            }

        }

        return null;
    }

    @Override
    public List<Subtitle> getSubtitles(Time startTime, Time endTime) {

        //returning all the subtitles between the certain time
        ArrayList<Subtitle> subtitlesWithinTime = new ArrayList<>();

        //loop through the subtitles in the big list then check the time then see if the subtitle is in the time 
        //then it them to the list if it is
        for (Subtitle subtitle : subtitleList) {
            if (((SubtitleImplemented) subtitle).getTimeInMilliseconds() >= ((TimeImplemented) startTime).getTimeInMS() && ((SubtitleImplemented) subtitle).getTimeInMilliseconds() <= ((TimeImplemented) endTime).getTimeInMS()) {
                subtitlesWithinTime.add(subtitle);
            }
        }

        return subtitlesWithinTime;
    }

    @Override
    public List<Subtitle> getSubtitles(String str) {

        //the list to return:
        ArrayList<Subtitle> subtList = new ArrayList<>();

        //if str is in the subtitle, add the subtitle to the list to return
        for (Subtitle subtitle : subtitleList) {

            if (subtitle.getText().contains(str)) {
                subtList.add(subtitle);
            }
        }

        return subtList;
    }

    @Override
    public void remove(String str) {

        //this is like getsubtitles - it searches through the subtitlelist and if the subtitle contains the 
        //string str we remove it from the big list
        for (Subtitle subtitle : subtitleList) {

            if (subtitle.getText().contains(str)) {
                subtitleList.remove(subtitle);
            }

        }

    }

    @Override
    public void replace(String str1, String str2) {

        //loop through the the big subtitle list, if the text is str1, replace it with str2
        for (Subtitle subtitle : subtitleList) {

            if (subtitle.getText().equalsIgnoreCase(str1)) {
                subtitle.setText(str2);

            }

        }

    }

    //shifts the time by the offset
    @Override
    public void shift(int offset) {

        //doing it in milliseconds: if the milliseconds would make the existing ms 1000 or more we add a minute and 
        //the leftovers are in ms.
        //if the offset is less than 0:
        if (offset < 0) {
            //loop through the subtitles and if the offset + the time would be 0 or less we take out the subtitle
            for (Subtitle subtitle : subtitleList) {

                Time updatedTime = new TimeImplemented();
                updatedTime.setMS(updatedTime.getMS() + offset);

                subtitle.setStartTime(updatedTime);

                if (((TimeImplemented) ((SubtitleImplemented) subtitle).getStartTime()).getTimeInMS() <= 0 || ((TimeImplemented) ((SubtitleImplemented) subtitle).getEndTime()).getTimeInMS() <= 0) {

                    subtitleList.remove(subtitle);

                }

            }

        } else {
            //if it's not, take all the subtitles in a loop and add the offset to the start and end times depending
            //on how big the offset is

            for (Subtitle subtitle : subtitleList) {

                //this only works if offset is under 1000, add if-elses to catch
                Time updatedTime = new TimeImplemented();

                updatedTime.setMS(subtitle.getStartTime().getMS() + offset);
                subtitle.setStartTime(updatedTime);

                updatedTime.setMS(subtitle.getEndTime().getMS() + offset);
                subtitle.setEndTime(updatedTime);

            }

        }

    }

    //cuts all the subtitles between a specific time - this is like getsubtitle(time) but reversed
    @Override
    public void cut(Time startTime, Time endTime) {
        //loop through the list of subtitles
        for (Subtitle subtitle : subtitleList) {

            //if it's within the given time get it out of the list
            if (((SubtitleImplemented) subtitle).getTimeInMilliseconds() >= ((TimeImplemented) startTime).getTimeInMS() && ((SubtitleImplemented) subtitle).getTimeInMilliseconds() <= ((TimeImplemented) endTime).getTimeInMS()) {
                subtitleList.remove(subtitle);
            }
        }

    }

}
