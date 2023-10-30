package com.sysco.brakes.qe.webui.data;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sysco.brakes.qe.webui.model.User;
import com.sysco.brakes.qe.webui.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserData {
    private List<User> users;

    public UserData(String filename) throws IOException {
        JsonObject data = JsonUtil.getJsonData(filename);
        users = new ArrayList<>();
        JsonArray usersArray = data.getAsJsonArray("users");

        for (int i = 0; i < usersArray.size(); i++) {
            JsonObject userObject = usersArray.get(i).getAsJsonObject();
            String username = userObject.get("username").getAsString();
            String password = userObject.get("password").getAsString();
            String accountNumber = userObject.get("accountNumber").getAsString();
            users.add(new User(username, password, accountNumber));
        }
    }

    public List<User> getUsers() {
        return users;
    }
}

