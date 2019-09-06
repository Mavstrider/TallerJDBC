package org.springframework.samples.petclinic.owner;



import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{
	
	 /**
     * Save a <code>Visit</code> to the data store, either inserting or updating it.
     *
     * @param visit the <code>Visit</code> to save
     * @see BaseEntity#isNew
     */
	
	    /**
	     * Retrieve a {@link Pet} from the data store by id.
	     * @param id the id to search for
	     * @return the {@link Pet} if found
	     */
	    @Transactional(readOnly = true)
	    Bill findById(Integer id);

	   




}