package com.example.simplewebshopapplication.service.product;

import com.example.simplewebshopapplication.projection.ProductDto;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class FindAllTest extends ProductServiceTestBase {

    @Test
    public void Should_ReturnList() {
        List<ProductDto> expected = Instancio.ofList(ProductDto.class).create();

        //given
        given(productRepository.findProductAll()).willReturn(expected);

        //when
        List<ProductDto> actual =  productService.findAll();

        //then
        assertEquals(expected, actual);
    }
}
