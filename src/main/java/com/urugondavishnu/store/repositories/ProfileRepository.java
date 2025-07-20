package com.urugondavishnu.store.repositories;

import com.urugondavishnu.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}