package com.shark.App.converter.user;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.Language;
import com.shark.App.model.user.User;
import com.shark.App.repository.LanguageRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    private final LanguageRepository languageRepository;


    @Override
    public User convert(@NonNull UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);

        Language nativeLanguage = userDto.getNativeLanguageId() != null
                ? languageRepository.findLanguageById(userDto.getNativeLanguageId()) : null;
        Language learningLanguage = userDto.getLearningLanguage1Id() != null
                ? languageRepository.findLanguageById(userDto.getLearningLanguage1Id()) : null;
        user.setNativeLanguage(nativeLanguage);
        user.setLearningLanguage1(learningLanguage);
        return user;
    }
}

