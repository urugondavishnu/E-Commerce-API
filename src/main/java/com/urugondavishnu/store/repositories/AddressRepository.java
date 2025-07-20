package com.urugondavishnu.store.repositories;

import com.urugondavishnu.store.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}