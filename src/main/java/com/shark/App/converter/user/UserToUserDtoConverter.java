package com.shark.App.converter.user;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserToUserDtoConverter implements Converter<User, UserDto> {

    @Override
    public UserDto convert(@NonNull User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        Integer nativeLanguageId = user.getNativeLanguage() != null ? user.getNativeLanguage().getId() : null;
        Integer learningLanguage1Id = user.getLearningLanguage1() != null ? user.getLearningLanguage1().getId() : null;

        userDto.setNativeLanguageId(nativeLanguageId);
        userDto.setLearningLanguage1Id(learningLanguage1Id);
        return userDto;
    }
}
