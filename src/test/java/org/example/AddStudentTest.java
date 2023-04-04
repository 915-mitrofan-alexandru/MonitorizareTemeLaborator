package org.example;

import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

public class AddStudentTest {
    private Service service;

    @BeforeEach
    void setUp() throws Exception {
        Validator<Student> studentValidator = (Validator<Student>) new StudentValidator();
        Validator<Tema> temaValidator = (Validator<Tema>) new TemaValidator();
        Validator<Nota> notaValidator = (Validator<Nota>) new NotaValidator();

        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

        service = new Service(fileRepository1, fileRepository2, fileRepository3);
    }

    @Test
    void addGoodStudentTest(){
        assert service.saveStudent("10", "Andrei mocanu", 935) == 0;
    }

    @Test
    void addBadStudentTest(){
        assert service.saveStudent("9", "", 2) == 1;
    }
}
