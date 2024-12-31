package com.api.tests.Pet;

import com.api.models.request.AddPetRequest;
import com.api.models.request.Category;
import com.api.models.request.Tag;
import com.api.services.PetService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestAddPet {
    AddPetRequest addPetRequest = new AddPetRequest();
    PetService petService = new PetService();
    Category category = new Category(2, "Sheru");
    Tag tags = new Tag(2, "sheru");
    @Test
    public void testAddNewPet(){

        addPetRequest = new AddPetRequest(1, category, "sheru",Arrays.asList(""), Arrays.asList(tags), "available");
        Response response = petService.createPet(addPetRequest);
        System.out.println(response.asPrettyString());

    }
}
