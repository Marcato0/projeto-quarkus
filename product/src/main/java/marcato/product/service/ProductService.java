package marcato.product.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import marcato.product.dto.ProductDTO;
import marcato.product.entity.ProductEntity;
import marcato.product.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductRepository productRepository;

    public List<ProductDTO> findAllProducts(){
        List<ProductDTO> customers = new ArrayList<>();

        productRepository
                .findAll()
                .stream()
                .forEach(
                        item->{
                            customers.add(mapProductEntityToDTO(item));
                        }
                );

        return customers;
    }

    public void createNewProduct(ProductDTO productDTO){
        productRepository
                .persist(mapProductDtoToEntity(productDTO));
    }

    public void changeProduct(Long id, ProductDTO productDTO){
        ProductEntity product = productRepository.findById(id);

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCulture(productDTO.getCulture());
        product.setArea_size(productDTO.getArea_size());

        productRepository.persist(product);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    private ProductDTO mapProductEntityToDTO(ProductEntity product){

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCulture(product.getCulture());
        productDTO.setArea_size(product.getArea_size());


        return productDTO;

    }

    private ProductEntity mapProductDtoToEntity(ProductDTO product){

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(product.getName());
        productEntity.setDescription(product.getDescription());
        productEntity.setCulture(product.getCulture());
        productEntity.setArea_size(product.getArea_size());


        return productEntity;

    }
}
