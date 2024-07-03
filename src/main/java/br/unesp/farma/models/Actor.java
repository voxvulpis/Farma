package br.unesp.farma.models;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.testng.annotations.BeforeClass;

import java.util.Date;

public abstract class Actor {

    @NotNull
    @Positive
    private Integer id;
    Date registrationDate;

//    private static Validator validator;
//    @BeforeClass
//    public static void setupValidator(){
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
