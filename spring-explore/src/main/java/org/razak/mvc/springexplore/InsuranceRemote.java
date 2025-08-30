package org.razak.mvc.springexplore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
save    >> insert object into table row
findAll >> read rows convert into List<Entity>
findById>> read one row based on primary key
delete  >> delete one row by specifying Entity object
deleteById>delete one row by primary key

 */

@Repository // this has become bean and it can be autowired
public interface InsuranceRemote extends JpaRepository<Insurance,Integer> {
    List<Insurance> findAllByMaturityAmountBetween(double start, double end);
    List<Insurance> findAllBySchemeType(String type);
    List<Insurance> findAllByPremiumGreaterThanEqualAndDurationEquals(int prem, int dur);
//    @Query(value = "from Insurance where schemeName like %:str%")
    @Query(value = "select * from Insurance where scheme_name like %:str%",nativeQuery = true)
    List<Insurance> generateByLike(String str);
}
