package ProyectHealthRest.Repository;

import ProyectHealthRest.Entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.List;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {

    @Query("SELECT s FROM Shift s WHERE (s.iShift < :finish AND s.finishShift > :start)")
    List<Shift> findOverlappingShifts(@Param("start") Calendar start, @Param("finish") Calendar finish);


}
