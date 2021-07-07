package com.shark.App.converter.user.fromUserDto;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;

public interface IUserDtoToUserConverter {
    User convert(UserDto userDto);
}
