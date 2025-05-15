package com.example.springdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {
    @Getter
    @Setter
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;

    @Getter
    @Setter
    @JsonProperty()
    private String username;

    @Getter
    @Setter
    @JsonProperty()
    private String password;

    @Getter
    @Setter
    @JsonProperty()
    private String fullname;

}
