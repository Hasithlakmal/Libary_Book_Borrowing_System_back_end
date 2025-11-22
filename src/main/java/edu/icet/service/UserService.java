package edu.icet.service;

import edu.icet.model.dto.User;
import edu.icet.model.entity.UserEntity;
import edu.icet.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired

    UserRepository userRepository;

    private ModelMapper mapper =new ModelMapper();

    public void  add(User user){


        userRepository.save(new UserEntity(

                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPhoine(),
                user.getAdddress(),
                user.getMembershipDate()

        ));

    }

    public void deletbyOb(User user) {

        userRepository.delete(new UserEntity(

                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPhoine(),
                user.getAdddress(),
                user.getMembershipDate()

        ));

    }

    public void deletbyId(String id) {

        userRepository.deleteById(id);

    }

    public List<User> getAllUser() {

        List<UserEntity> all = userRepository.findAll();

        List<User> users=new ArrayList<>();

        for (UserEntity userEntity : all) {

//          users.add(new User(
//
//                  userEntity.getUserId(),
//                  userEntity.getName(),
//                  userEntity.getEmail(),
//                  userEntity.getPhoine(),
//                  userEntity.getAdddress(),
//                  userEntity.getMembershipDate()
//
//
//            )
//
//
//          );


            users.add(mapper.map(userEntity,User.class));   //

        }


        return users;

    }


    public User getIDInfo(String id) {

        Optional<UserEntity> byId = userRepository.findById(id);

        UserEntity userEntity = byId.get(); // doing  retrun  entity type  data  becuuse  as  entity have  userEntity type data therfore  doing  retrun    entity type data

        return  new User(

                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getPhoine(),
                userEntity.getAdddress(),
                userEntity.getMembershipDate()

        );



    }

    public void update(User user) {

        userRepository.saveAndFlush(new  UserEntity(

                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPhoine(),
                user.getAdddress(),
                user.getMembershipDate()


        ));

    }
}
