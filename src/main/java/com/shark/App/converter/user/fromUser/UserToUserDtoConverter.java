package com.shark.App.converter.user.fromUser;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

public class UserToUserDtoConverter implements Converter<User, UserDto>, IUserToUserDtoConverter {

    @Override
    public UserDto convert (User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
