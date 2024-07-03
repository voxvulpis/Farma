package br.unesp.farma.validation;

import br.unesp.farma.models.Item;
import br.unesp.farma.models.Product;
import br.unesp.farma.repos.Stock;
import br.unesp.farma.utils.DemonstrationUtils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;


public class ValidateStock {
    private static Validator validator;

    @BeforeClass
    public static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    public static Stock loadStockJson(){
        if(!Files.exists(Paths.get("Stock.json"))){
            DemonstrationUtils.startDemo();
        }
        return DemonstrationUtils.loadStockFromJson();
    }

    @Test
    public void validateItems(){
        Stock stock = loadStockJson();
        Iterator<Item> iterator = stock.getStockList().iterator();
        Set<ConstraintViolation<Item>> constraintViolations;

        while (iterator.hasNext()){
            Item item = iterator.next();

            constraintViolations = validator.validate(item);
            assertEquals(0, constraintViolations.size());
        }


    }


    @Test
    public void validateProducts(){
        Stock stock = loadStockJson();
        Iterator<Item> iterator = stock.getStockList().iterator();
        Set<ConstraintViolation<Product>> constraintViolations;

        while (iterator.hasNext()){
            Product product = iterator.next().getProduct();

            constraintViolations = validator.validate(product);
            assertEquals(0, constraintViolations.size());
        }


    }
}
