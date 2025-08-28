package org.razak.mvc.springexplore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
save    >> insert object into table row
findAll >> read rows convert into List<Entity>
findById>> read one row based on primary key
delete  >> delete one row by specifying Entity object
deleteById>delete one row by primary key

 */

@Repository // this has become bean and it can be autowired
public interface InsuranceRemote extends JpaRepository<Insurance,Integer> {
}
