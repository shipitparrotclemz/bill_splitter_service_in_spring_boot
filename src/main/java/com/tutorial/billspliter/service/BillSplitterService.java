package com.tutorial.billspliter.service;

import com.tutorial.billspliter.models.InputItem;
import com.tutorial.billspliter.models.InputUser;
import com.tutorial.billspliter.models.OutputItem;
import com.tutorial.billspliter.models.OutputUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BillSplitterService {
    /**
     * Responsiblity: Take in an ArrayList<InputItems>, returns ArrayList<OutputUser>
     * I.E, splits the bill across users
     */

    private static HashMap<String, ArrayList<InputItem>> getUserToItems(ArrayList<InputItem> items) {
        // This hashmap's key is the user's name, and the value, is the arraylist of items this user is contributing to
        HashMap<String, ArrayList<InputItem>> userToItems = new HashMap<String, ArrayList<InputItem>>();

        // For each of the input items, we are appending the item to each user's userToItems arrayList;
        // This lets us keep track of which items each user is contributing to
        for (InputItem item: items) {
            for (InputUser user: item.users) {
                // For each of this user, append the current item into the userToItems hashmap
                ArrayList<InputItem> currentUserItems = userToItems.getOrDefault(user.name, new ArrayList<InputItem>());
                currentUserItems.add(item);
                userToItems.put(user.name, currentUserItems);
            }
        }
        return userToItems;
    }

    private static ArrayList<OutputUser> getOutputUsers(HashMap<String, ArrayList<InputItem>> usersToItems) {
        // Represents the users that we calculated their bill for
        ArrayList<OutputUser> outputUsers = new ArrayList<OutputUser>();

        // We are iterating through all users in the HashMap
        // For each of the list of items we have for each user, we calculate the price the user has to pay
        // and update it into the HashMap
        for (Map.Entry<String, ArrayList<InputItem>> singleUserToItems: usersToItems.entrySet()) {
            String userName = singleUserToItems.getKey();
            ArrayList<InputItem> userItems = singleUserToItems.getValue();

            double totalPayableToUser = 0.0;

            ArrayList<OutputItem> outputUserItems = new ArrayList<OutputItem>();

            // For each item a user is contributing to, calculate the price the user has to pay
            for (InputItem item: userItems) {
                // totalItemPrice is the product of price and quantity
                Double totalItemPrice = item.price * item.quantity;
                // Item Contributors
                ArrayList<InputUser> itemContributors = item.users;
                Integer usersContributing = itemContributors.size();

                // Represents the price the user needs to pay for this item
                double itemPayableToUser = totalItemPrice / usersContributing;

                totalPayableToUser += itemPayableToUser;

                OutputItem outputItem = new OutputItem(item);
                outputUserItems.add(outputItem);
            }
            // Successfully calculated the amount of money currOutputUser has to pay for
            OutputUser currOutputUser = new OutputUser(userName, totalPayableToUser, outputUserItems);
            outputUsers.add(currOutputUser);
        }
        return outputUsers;
    }

    public static ArrayList<OutputUser> splitBill(ArrayList<InputItem> items) {
        HashMap<String, ArrayList<InputItem>> userToItems = BillSplitterService.getUserToItems(items);
        return BillSplitterService.getOutputUsers(userToItems);
    }
}
