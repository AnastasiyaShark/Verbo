package com.shark.App.converter.user.fromUserDto;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUserConverter implements Converter<UserDto, User>, IUserDtoToUserConverter{

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }
}

