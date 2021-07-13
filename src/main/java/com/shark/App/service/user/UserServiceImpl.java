package com.shark.App.service.user;

import com.shark.App.dto.UserDto;
import com.shark.App.model.user.User;
import com.shark.App.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ConversionServiceFactoryBean;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionServiceFactoryBean factoryBean;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ConversionServiceFactoryBean factoryBean) {
        this.userRepository = userRepository;
        this.factoryBean = factoryBean;
    }

    @Override
    public Integer createUser(UserDto userDto) {
        User user = factoryBean.getObject().convert(userDto, User.class);
        return userRepository.save(user).getId();
    }

}
