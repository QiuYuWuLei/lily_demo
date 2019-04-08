package com.lily.demo.service;

import com.google.gson.Gson;
import com.lily.demo.model.User;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Streams {
    private static Gson gson = new Gson();

    private enum Status {
        OPEN, CLOSED
    }

    public static final class Task {
        private final Status status;
        private final Double points;

        Task(final Status status, final double points) {
            this.status = status;
            this.points = points;
        }

        public Double getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("b", "b");
        map.put("a", "a");
        map.put("f", "f");
        map.put("c", "c");
        map.put("d", "d");
        map.put("n", "n");
        String jsonStr = gson.toJson(map);

        System.out.printf(jsonStr);

        Map mapReturn = gson.fromJson(jsonStr, Map.class);
        System.out.printf(mapReturn.toString());
//        final Collection<User> users = Arrays.asList(
//                new User("lily1", 5, new Date(1550428200000L)),
//                new User("lily2", 4, new Date(1550428200000L)),
//                new User("lily3", 3, new Date(1550349000000L)),
//                new User("lily4", 2, new Date(1550262600000L))
//        );
//
//        final Map<Object, List<User>> map = users
//                .stream()
//                .filter(user -> user.getAge() > 2)
//                .filter(user -> user.getName().equals("lily2"))
//                .collect(Collectors.groupingBy(user -> toDateString(user.getBirthday(), "yyyy-MM-dd")));
//        System.out.println(map);

//        Clock clock = Clock.systemUTC();
//        System.out.println(clock.millis());
//        System.out.println(clock.instant());
//        System.out.println(LocalDate.now());



    }

    public static String toDateString(Date date, String fomat) {
        SimpleDateFormat sdf = new SimpleDateFormat(fomat);
        if (date == null) {
//			date = new Date(System.currentTimeMillis());
            return "";
        }
        return sdf.format(date);
    }
}
