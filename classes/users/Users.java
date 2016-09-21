/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RYU
 */
public class Users {

    private String username;
    private String status;

    public Users(String username, String status) {
        this.username = username;
        this.status = status;
    }

    public void changeUsername(String name) {
        username = name;
    }

    public void statusOnline(String online) {
        status = online;
    }

    @Override
    public String toString() {
        return username + " status: " + status;
    }
}
