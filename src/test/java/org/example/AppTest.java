package org.example;

import domain.Student;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import service.Service;
import validation.StudentValidator;
import validation.ValidationException;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase
{
    private Service service;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test 🙂
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void addGoodStudentTest()
    {
        validation.Validator<Student> studentValidator = (validation.Validator<Student>) new StudentValidator();
        validation.Validator<domain.Tema> temaValidator = (validation.Validator<domain.Tema>) new validation.TemaValidator();
        validation.Validator<domain.Nota> notaValidator = (validation.Validator<domain.Nota>) new validation.NotaValidator();

        repository.StudentXMLRepository fileRepository1 = new repository.StudentXMLRepository(studentValidator, "studenti.xml");
        repository.TemaXMLRepository fileRepository2 = new repository.TemaXMLRepository(temaValidator, "teme.xml");
        repository.NotaXMLRepository fileRepository3 = new repository.NotaXMLRepository(notaValidator, "note.xml");

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
        assert service.saveStudent("10", "Andrei mocanu", 935) == 0;
    }

    public void addBadStudentTest()
    {
        validation.Validator<Student> studentValidator = (validation.Validator<Student>) new StudentValidator();
        validation.Validator<domain.Tema> temaValidator = (validation.Validator<domain.Tema>) new validation.TemaValidator();
        validation.Validator<domain.Nota> notaValidator = (validation.Validator<domain.Nota>) new validation.NotaValidator();

        repository.StudentXMLRepository fileRepository1 = new repository.StudentXMLRepository(studentValidator, "studenti.xml");
        repository.TemaXMLRepository fileRepository2 = new repository.TemaXMLRepository(temaValidator, "teme.xml");
        repository.NotaXMLRepository fileRepository3 = new repository.NotaXMLRepository(notaValidator, "note.xml");

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
        assert service.saveStudent("9", "", 2) == 1;
    }
}