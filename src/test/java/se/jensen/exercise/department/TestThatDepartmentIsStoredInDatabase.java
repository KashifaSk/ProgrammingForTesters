package se.jensen.exercise.department;

import liquibase.pro.packaged.D;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.jensen.dao.DepartmentDao;
import se.jensen.dao.DepartmentDatabaseEntry;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestThatDepartmentIsStoredInDatabase {
    DepartmentDao departmentDao = mock(DepartmentDao.class);

    private final Integer DEPARMENTID = 5 ;
    private final String DEPARTMENTNAME = "Develop";

    @Before
    public void mockSettings() {
        when(departmentDao.save(any(DepartmentDatabaseEntry.class)))
                .thenReturn(DepartmentDatabaseEntry.builder()
                        .departmentId(DEPARMENTID)
                        .departmentName(DEPARTMENTNAME)
                .build());

    }

    @Test
    public void testToSaveInDatabase() {

        DepartmentDatabaseEntry departmentDatabaseEntry = DepartmentDatabaseEntry.builder()
                .departmentId(DEPARMENTID)
                .departmentName(DEPARTMENTNAME)
                .build();

        DepartmentDatabaseEntry departmentDatabaseEntrySaved = departmentDao.save(departmentDatabaseEntry);
        Assert.assertEquals(departmentDatabaseEntry.getDepartmentId(),departmentDatabaseEntrySaved.getDepartmentId());
        Assert.assertEquals(departmentDatabaseEntry.getDepartmentName(),departmentDatabaseEntrySaved.getDepartmentName());
    }




}
