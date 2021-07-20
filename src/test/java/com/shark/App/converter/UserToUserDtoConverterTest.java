package com.shark.App.converter;

import com.shark.App.converter.user.fromUser.UserToUserDtoConverter;
import com.shark.App.converter.user.fromUserDto.UserDtoToUserConverter;
import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;
import com.shark.App.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserToUserDtoConverterTest {
    @Autowired
    UserRepository userRepository;

    UserToUserDtoConverter userToUserDtoConverter = new UserToUserDtoConverter();
    UserDtoToUserConverter userDtoToUserConverter = new UserDtoToUserConverter();

    @Test
    void convert() {
        User user = userRepository.findUserByName("User1").get();
        UserDto userDto = userToUserDtoConverter.convert(user);
        Assertions.assertAll(
                () -> assertEquals(user.getId(), userDto.getId()),
                () -> assertEquals(user.getName(), userDto.getName()),
                () -> assertEquals(user.getPassword(), userDto.getPassword()),
                () -> assertEquals(user.getEmail(), userDto.getEmail()),
                () -> assertEquals(user.getNativeLanguage(), userDto.getNativeLanguage()),
                () -> assertEquals(user.getLearningLanguage1(), userDto.getLearningLanguage1())
        );

        User newUser = userDtoToUserConverter.convert(userDto);
        Assertions.assertAll(
                () -> assertEquals(userDto.getId(), newUser.getId()),
                () -> assertEquals(userDto.getName(), newUser.getName()),
                () -> assertEquals(userDto.getPassword(), newUser.getPassword()),
                () -> assertEquals(userDto.getEmail(), newUser.getEmail()),
                () -> assertEquals(userDto.getNativeLanguage(), newUser.getNativeLanguage()),
                () -> assertEquals(userDto.getLearningLanguage1(), newUser.getLearningLanguage1())
        );
    }
}
