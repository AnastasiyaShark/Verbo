package com.shark.App.converter.user.fromUser;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;

public interface IUserToUserDtoConverter {
    UserDto convert(User user);
}
