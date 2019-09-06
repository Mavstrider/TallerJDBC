package org.springframework.samples.petclinic.dao;


import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerDAO extends AbstractJpaDAO<Owner, Integer> implements IOwnerDAO {

	public OwnerDAO() {
		super();

		setClazz(Owner.class);
	}
}
