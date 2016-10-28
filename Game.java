import java.io.*;
import java.util.*;
import java.net.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JApplet implements ActionListener {
    /**
     * Description of instance variables
     * player1: boolean that denotes whether player1 or player2 is allowed
     * to click on a certain pile on the board
     * turn1: boolean denoting whose turn it is
     */
    public LinkedList<Pile> piles;
    private boolean player1;
    private boolean isLandedMancala;
    public Board aBoard;


    /**
     * Constructs a Board with a 12 piles and 2 mancalas in a linked list.
     * The 12 piles are populated with 6 stones/pebbles each.
     */
    public Game() {
        //add to our linkedlist
        aBoard = new Board();
        player1 = true;
        piles = new LinkedList<Pile>();
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(0));
        piles.get(6).toggleMancala(); //this pile becomes a mancala
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(6));
        piles.add(new Pile(0));
        piles.get(13).toggleMancala(); //this pile becomes a mancala
        isLandedMancala = false;
    }

    public String toString() {
        return piles.toString();

    }

    /**
     * Determines whether the game has reached its end, by using
     * isSideEmpty to check the state of each side of the board
     */
    public boolean isGameOver() {
        return isSideEmpty();
    }

    /**
     * Determines whether a side of the board is empty
     */
    public boolean isSideEmpty() {
        //one of two cases needs to be true:
        //either 0-5 are empty or 7-12 are empty
        if (isBottomSideEmpty() || isTopSideEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    //checks if labels 0-5 are empty 
    public boolean isBottomSideEmpty() {
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if (piles.get(i).isEmpty()) {
                counter++;
            }
        }
        return (counter == 6); //is empty is all 6 are empty
    }

    //checks if labels 7-12 are empty
    public boolean isTopSideEmpty() {
        int counter = 0;
        for (int i = 7; i < 13; i++) {
            if (piles.get(i).isEmpty()) {
                counter++;
            }
        }
        return (counter == 6); //is empty is all 6 are empty
    }

    /**
     * Takes a turn by distributing the contents of a chosen
     * pile across the other piles on the board. Traverses the
     * linked list, popping from the pile given as a parameter
     * and pushing the popped pebble onto the currrent pile. not 	  sure i m thinking correctly but still trying
     */
    //I think the parameter should be a number corresponding to it's place
    //in the linkedlist
    public void makeSingleMove(Integer currentPile) {
        //sets isLandedMancala to false just in case

        if ((player1 == false && currentPile < 6) || (player1 == true && currentPile > 6)) {
            //do nothing
        } else {


            isLandedMancala = false;
            int i = currentPile;
//I want to take the pile at piles.get(currentPile) and dump it 
            //into all of the corresponding piles
            //if player1==true, dump it into mancala 6
            //if player1==false, dump it into mancala 13
            //now I need to add pebbles to all of the rest piles
            i++; //increment to get to next pile
            while (!piles.get(currentPile).isEmpty()) {

                //now, need to check if it's the person's mancala or not

                //we need to check with conditions but i m still working on it