package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Harry";
        byte age = 18;
        short height = 176;
        int weight = 82;
        long km = 6345L;
        float weightForFloat = 82.2f;
        double kmForDouble = 6345.2d;
        boolean man = true;
        char gender = 'M';
        LOG.debug("User info name : {}, age : {}, height : {}, weight : {}, km : {}, "
                        + "weightForFloat : {}, kmForDouble : {}, man: {}, gender: {} ",
                name, age, height, weight, km, weightForFloat, kmForDouble, man, gender);
    }
}