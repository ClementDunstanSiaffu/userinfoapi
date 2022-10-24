
package com.userinfo.userinfoapi;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryClass extends MongoRepository<EntityClass,String> {
    EntityClass findByDeviceId(String deviceId);
}
