/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Authentication;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
/**
 *
 * @author Mushi
 */
public class Reader implements KeyListener{
    ArrayList<Long> timePress;
    ArrayList<String> pressedKey;    
    ArrayList<Long> timeRelease;
    ArrayList<String> releasedKey;
    
    public Reader() {
        timePress = new ArrayList();
        pressedKey = new ArrayList();
        timeRelease = new ArrayList();
        releasedKey = new ArrayList();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.print("");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        timePress.add(System.currentTimeMillis());
        pressedKey.add(KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        timeRelease.add(System.currentTimeMillis());
        releasedKey.add(KeyEvent.getKeyText(e.getKeyCode()));
    }
    
    
    public Integer[] pressedTime() {
        Integer[] pressTime = new Integer[timePress.size() - 1];
        for(int i = 1; i < timePress.size(); i++) {
            pressTime[i - 1] = (int) (timePress.get(i) - timePress.get(i - 1));
        }
        return pressTime;
    }
    
    public String pressedKeys() {
        String key = "";
        for(int i = 0; i < pressedKey.size() - 1; i++) {
            key = key + pressedKey.get(i) + " ";
        }
        key = key + pressedKey.get(pressedKey.size() - 1);
        return key;
    }
    
    public Integer[] difTime() {
        Integer[] timeDif = new Integer[timePress.size()];
        for(int i = 0; i < timePress.size(); i++) {
            timeDif[i] = (int) (timePress.get(i) - timeRelease.get(i));
        }
        return timeDif;
    }
    public void clear() {
        timePress.clear();
        timeRelease.clear();
        pressedKey.clear();
        releasedKey.clear();
    }
}
