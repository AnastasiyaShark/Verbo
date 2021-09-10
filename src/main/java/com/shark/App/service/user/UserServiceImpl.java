package com.shark.App.service.user;

import com.shark.App.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;


//    @Override
//    public Integer createUser(SignupRequest signupRequest) {
//        User user = factoryBean.getObject().convert(userDto, User.class);
//        return userRepository.save(user).getId();
//    }

}
