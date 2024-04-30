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

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.toString().startsWith(System.lineSeparator()));
        assertTrue(testJob.toString().endsWith(System.lineSeparator()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertEquals("""
                ID: 4
                Name: Product tester
                Employer: ACME
                Location: Desert
                Position Type: Quality control
                Core Competency: Persistence""", testJob.toString().trim());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        Assert.assertEquals("""
                ID: 3
                Name: Data not available
                Employer: Data not available
                Location: Data not available
                Position Type: Data not available
                Core Competency: Data not available""", testJob.toString().trim());
    }

}