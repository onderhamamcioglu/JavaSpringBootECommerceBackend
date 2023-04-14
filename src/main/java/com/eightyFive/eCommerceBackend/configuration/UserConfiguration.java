package com.eightyFive.eCommerceBackend.configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//THIS CLASS IS WRITTEN IN ORDER TO UNDERSTAND HOW SINGLETON PATTERN IN BEANS WORK
@Scope("singleton")
@Component
public class UserConfiguration {

    public int counter = 0;

    public void increaseCounter(){
        counter ++;
    }
}
