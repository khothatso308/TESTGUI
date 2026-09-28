package com.mycompany.testgui;

import javax.swing.JOptionPane;
import java.util.*;

public class MenuSearch {

    public static void main(String[] args) {

        // Array that can hold up to 10 menu items
        String[] menu = new String[10];

        // Variables
        String entry = "";
        String menuList = "";

        int subscript = 0;
        int numEntered = 0;
        int highSubscript = menu.length - 1;

        // Fill unused positions with z characters
        Arrays.fill(menu, "zzzzzzz");

        // Get the first menu item
        entry = JOptionPane.showInputDialog(
                null,
                "Enter a menu item or zzz to quit:"
        );

        // Continue entering menu items
        while (!entry.equals("zzz") && subscript <= highSubscript) {

            menu[subscript] = entry;

            // Add item to the menu list
            menuList = menuList + entry + "\n";

            // Increase the array subscript
            subscript++;

            // Ask for another menu item
            if (subscript <= highSubscript) {
                entry = JOptionPane.showInputDialog(
                        null,
                        "Enter a menu item or zzz to quit:"
                );
            }
        }

        // Save the number of menu items entered
        numEntered = subscript;

        // Display the menu
        JOptionPane.showMessageDialog(
                null,
                "Today's Menu:\n\n" + menuList
        );

        // Sort only the menu items that were entered
        Arrays.sort(menu, 0, numEntered);

        // Ask the user what they want
        String request = JOptionPane.showInputDialog(
                null,
                "What menu item would you like?"
        );

        // Search for the requested item
        int result = Arrays.binarySearch(menu, 0, numEntered, request);

        // Check whether the item was found
        if (result >= 0 && result < numEntered) {

            JOptionPane.showMessageDialog(
                    null,
                    "Excellent choice!"
            );

        } else {

            JOptionPane.showMessageDialog(
                    null,
                    "Sorry, that item is not on today's menu."
            );
        }

        System.exit(0);
    }
}