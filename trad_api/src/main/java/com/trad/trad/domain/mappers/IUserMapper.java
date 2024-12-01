package com.trad.trad.domain.mappers;

import com.trad.trad.domain.dto.UserDto;
import com.trad.trad.infrastructure.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    @Mappings({
            @Mapping(source = "user.name" , target = "name"),
            @Mapping(source = "user.email", target = "email"),
            @Mapping(source = "user.phone" , target = "phone" )
    })
    UserDto toDto(User user);
    @Mappings({
            @Mapping(source = "userDto.name" , target = "name"),
            @Mapping(source = "userDto.email", target = "email"),
            @Mapping(source = "userDto.phone" , target = "phone" ),
            @Mapping(source = "userDto.password", target = "password")
    })
    User toEntity(UserDto userDto);


}
