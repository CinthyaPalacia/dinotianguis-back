package com.is.dinotianguis.commerce.initial;

import com.is.dinotianguis.commerce.base.model.CategoryModel;
import com.is.dinotianguis.commerce.base.model.seller.ProductModel;
import com.is.dinotianguis.commerce.base.model.seller.SellerModel;
import com.is.dinotianguis.commerce.base.model.seller.StoreModel;
import com.is.dinotianguis.commerce.base.service.CategoryService;
import com.is.dinotianguis.commerce.base.service.DefaultUserService;
import com.is.dinotianguis.commerce.base.service.ProductService;
import com.is.dinotianguis.user.enums.RolName;
import com.is.dinotianguis.user.model.Rol;
import com.is.dinotianguis.user.model.UserModel;
import com.is.dinotianguis.user.security.dto.Message;
import com.is.dinotianguis.user.service.RolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("/initial")
@CrossOrigin
public class InitialDataController
{
    private final static Logger logger = LoggerFactory.getLogger(InitialDataController.class);

    private static final String rootPath = System.getProperty("user.dir");

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private DefaultUserService userService;

    @Autowired
    private RolService rolService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @GetMapping("/create")
    public ResponseEntity<?> createCommerce()
    {
        final String UID = "seller@lapape.mx";
        Optional<UserModel> seller = userService.getByUID(UID);
        if (seller.isEmpty())
        {
            seller = createStore(UID);
        }
        return new ResponseEntity(new Message("Initial data is correct with seller " + seller.get().getUID()), HttpStatus.OK);
    }

    private Optional<UserModel> createStore(final String UID)
    {
        Rol userRol = new Rol();
        userRol.setRolName(RolName.ROLE_CUSTOMER);
        Rol sellerRol = new Rol();
        sellerRol.setRolName(RolName.ROLE_SELLER);
        rolService.save(userRol);
        rolService.save(sellerRol);
        final SellerModel user = new SellerModel(UID, passwordEncoder.encode("elpapelero"));
        Set<Rol> roles = new HashSet<>();
        Optional<Rol> customerRol = rolService.getByRolName(RolName.ROLE_SELLER);
        roles.add(customerRol.get());
        user.setRoles(roles);
        user.setAccountNonExpired(Boolean.TRUE);
        user.setAccountNonLocked(Boolean.TRUE);
        user.setCredentialsNonExpired(Boolean.TRUE);
        user.setEnabled(Boolean.TRUE);
        final StoreModel store = new StoreModel("La pape", "Papelería la pape, ¡lo mejor en papelerías!");
        store.setSeller(user);
        user.setStore(store);
        userService.save(user);
        proccessProducts(store);
        return Optional.of(user);
    }

    private void proccessProducts(final StoreModel store)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(rootPath + "/productos.csv")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] fields = line.split(",");
                final String image = fields[4].split("-")[0].replace("https://www.officedepot.com.mx/medias/","");
                if (image.endsWith("jpg") || image.endsWith("gif"))
                {
                    final String sku = fields[0];
                    final String name = fields[1];
                    final String description = fields[2];
                    final BigDecimal price = new BigDecimal(fields[3]);
                    final String brand = fields[5];
                    final String vendorSku = fields[6];
                    final String categories = fields[7];
                    final BigDecimal finalPrice = new BigDecimal(fields[9]);
                    createProduct(store,sku,name,description,image,price,brand,vendorSku,categories,finalPrice);
                }

            }
        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    private void createProduct(
            final StoreModel store,
            final String sku,
            final String name,
            final String description,
            final String image,
            final BigDecimal price,
            final String brand,
            final String vendorSku,
            final String categories,
            final BigDecimal finalPrice)
    {
        try
        {
            final ProductModel product = new ProductModel();
            product.setSku(sku);
            product.setName(name);
            product.setDescription(description);
            product.setImage(image);
            product.setPrice(price);
            product.setBrand(brand);
            product.setVendorSku(vendorSku);
            product.setFinalPrice(finalPrice);
            product.setCategories(getCategories(categories));
            product.setStore(store);
            productService.save(product);
        } catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    private Collection<CategoryModel> getCategories(final String categoryString)
    {
        final String[] categories = categoryString.split(">");
        Collection<CategoryModel> categoryList = new ArrayList<>();

        for (int i = 0; i < categories.length; i++)
        {
            Optional<CategoryModel> categoryModel = categoryService.findByName(categories[i]);
            CategoryModel category;
            if (categoryModel.isPresent())
            {
                category =  categoryModel.get();
            } else
            {
                category = new CategoryModel(categories[i]);
                if (i > 0)
                {
                    category.setParent(categoryService.findByName(categories[i-1]).orElse(null));
                }
                categoryService.save(category);
            }
            categoryList.add(category);
        }
        return categoryList;
    }
}
