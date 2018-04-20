package com.nabin.SpringSecurityJpa.startup;


import com.nabin.SpringSecurityJpa.domain.Role;
import com.nabin.SpringSecurityJpa.domain.UserRoles;
import com.nabin.SpringSecurityJpa.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
@Slf4j
public class RoleCreator {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleCreator(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    public  void init(){
        log.info("creating info...");
        if(roleRepository.count()==0){
            createRoles();
        }
    }

    private void createRoles() {
        for (UserRoles userRoles: UserRoles.values()){
            Role role=new Role();
           // role.setCreatedDate(new Date());
           // role.setLastModifiedDate(new Date());
            role.setDescription(addDescription(userRoles));
            role.setRoleName(userRoles.name());
            roleRepository.save(role);

        }
    }

    private String addDescription(UserRoles name) {
        switch (name){
            case ADMIN:
                return "This is admin Role";
            case USER:
                return "This belongs to user";
                default:
                    return null;


        }
    }
}
