package com.gson.adapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.gson.bean.User;

import java.io.IOException;

/**
 * 转换器
 * Created by devin on 2016/11/26.
 */
public class UserAdpater extends TypeAdapter<User> {

    @Override
    public void write(JsonWriter out, User value) throws IOException {
        out.beginObject();
        out.name("name");
        out.value(value.firstName + " " + value.secondName);
        out.endObject();
    }

    @Override
    public User read(JsonReader in) throws IOException {
        in.beginObject();
        in.nextName();
        String[] names = in.nextString().split(" ");
        User user = new User(names[0], names[1]);
        in.endObject();
        return user;
    }

}
