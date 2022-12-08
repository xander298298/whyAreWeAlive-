package com.example.pleasesendhelpgodplease;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyChecker implements KeyListener{

    public boolean upPressed;
    public boolean downPressed;
    public boolean rightPressed;
    public boolean leftPressed;


    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(key == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(key == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(key == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(key == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(key == KeyEvent.VK_W){
            upPressed = true;
        }
        if(key == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(key == KeyEvent.VK_S){
            downPressed = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
        if(key == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(key == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(key == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(key == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(key == KeyEvent.VK_W){
            upPressed = false;
        }
        if(key == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(key == KeyEvent.VK_S){
            downPressed = false;
        }
    }
}