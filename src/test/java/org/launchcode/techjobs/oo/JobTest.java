package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1, job2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job constructorJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(constructorJob.getName(), "Product tester");
        assertEquals(constructorJob.getEmployer().getValue(), "ACME");
        assertEquals(constructorJob.getLocation().getValue(), "Desert");
        assertEquals(constructorJob.getPositionType().getValue(), "Quality control");
        assertEquals(constructorJob.getCoreCompetency().getValue(), "Persistence");

        assertTrue(constructorJob.getName() instanceof String);
        assertTrue(constructorJob.getEmployer() instanceof Employer);
        assertTrue(constructorJob.getLocation() instanceof Location);
        assertTrue(constructorJob.getPositionType() instanceof PositionType);
        assertTrue(constructorJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job1.equals(job2), false);
    }
}
