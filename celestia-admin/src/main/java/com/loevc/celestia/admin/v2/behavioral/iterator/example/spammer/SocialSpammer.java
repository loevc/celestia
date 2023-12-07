package com.loevc.celestia.admin.v2.behavioral.iterator.example.spammer;

import com.loevc.celestia.admin.v2.behavioral.iterator.example.iterators.ProfileIterator;
import com.loevc.celestia.admin.v2.behavioral.iterator.example.profile.Profile;
import com.loevc.celestia.admin.v2.behavioral.iterator.example.social_networks.SocialNetwork;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/12/7 10:30
 * @Description TODO
 * @Version 1.0
 */
public class SocialSpammer {

    public SocialNetwork network;
    public ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("\nIterating over friends...\n");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("\nIterating over coworkers...\n");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendMessage(String email, String message) {
        System.out.println("Sent message to: '" + email + "'. Message body: '" + message + "'");
    }
}
