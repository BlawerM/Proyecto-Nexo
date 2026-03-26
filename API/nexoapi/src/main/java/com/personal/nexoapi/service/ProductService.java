package com.personal.nexoapi.service;
import org.springframework.stereotype.Service;

import com.personal.nexoapi.model.Product;
import com.personal.nexoapi.repository.ProductRepository;
import com.personal.nexoapi.model.JewelryType;
import com.personal.nexoapi.repository.JewelryTypeRepository;
import com.personal.nexoapi.model.DetailType;
import com.personal.nexoapi.repository.DetailTypeRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    ProductRepository productRepository;
    JewelryTypeRepository jewelryTypeRepository;
    DetailTypeRepository detailTypeRepository;

	public ProductService(ProductRepository productRepository, JewelryTypeRepository jewelryTypeRepository, DetailTypeRepository detailTypeRepository) {
		this.productRepository = productRepository;
		this.jewelryTypeRepository = jewelryTypeRepository;
		this.detailTypeRepository = detailTypeRepository;
	}

    public Product createProduct (Product product){
        Long detailTypeId = product.getDetailType().getID();
        Long jewerlyTypeId = product.getJewelryType().getID();

        DetailType detailType = detailTypeRepository.findById(detailTypeId)
        .orElseThrow(() -> new RuntimeException("El detalle no existe"));
        JewelryType jewelryType = jewelryTypeRepository.findById(jewerlyTypeId)
        .orElseThrow(() -> new RuntimeException("El tipo de bisutería no existe"));

        validateProductData(product);
        product.setDetailType(detailType);
        product.setJewelryType(jewelryType);
        return productRepository.save(product);
    }

    public Optional<Product> findBySKU (String SKU){
        return productRepository.findBySKU(SKU);
    }

    public List<Product> findByDetailType_ID(Long idDetail){
        return productRepository.findByDetailType_ID(idDetail);
    }

    public List<Product> findByDetailType_DesignType_ID(Long idDesign){
        return productRepository.findByDetailType_DesignType_ID(idDesign);
    }

    public List<Product> findByJewelryType_ID(Long idJewelry){
        return productRepository.findByJewelryType_ID(idJewelry);
    }

    public List<Product> findAll (){
        return productRepository.findAll();
    }

    /*Lógica de Long = comparteTo
    a < b	a.compareTo(b) < 0
    a > b	a.compareTo(b) > 0
    a <= b	a.compareTo(b) <= 0
    a >= b	a.compareTo(b) >= 0
    a == b	a.compareTo(b) == 0 */
    public List<Product> findByPriceBetween(BigDecimal min, BigDecimal max){
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("El precio mínimo no puede ser mayor al máximo");
        }

        if (min.compareTo(BigDecimal.ZERO)  <= 0 || max.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Ningún precio puede ser menor que 0");
        }

        return productRepository.findByPriceBetween(min, max);
    }

    public Product update (Long id, Product productDetails){
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Producto no encontrado con el id" + id));

        if (productDetails.getDescription() != null && !productDetails.getDescription().trim().isEmpty()) {
            product.setDescription(productDetails.getDescription());
        }
        if (!(productDetails.getPrice().compareTo(BigDecimal.ZERO) <= 0)) {
            product.setPrice(productDetails.getPrice());
        }
        validateProductData(productDetails);
        return productRepository.save(product);
    }

    private void validateProductData(Product product) {
        if (product.getStock() <= 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a 0.");
        }
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
    }
}
