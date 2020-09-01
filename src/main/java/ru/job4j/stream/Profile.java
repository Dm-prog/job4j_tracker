package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
        return result;
    }
}
