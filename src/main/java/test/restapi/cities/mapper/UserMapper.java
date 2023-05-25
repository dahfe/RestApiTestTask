package test.restapi.cities.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.restapi.cities.dto.entityDto.UserDto;
import test.restapi.cities.model.User;

@Component
public class UserMapper extends AbstractMapper<User, UserDto>{

    @Autowired
    public UserMapper() {
        super(User.class, UserDto.class);
    }
}
