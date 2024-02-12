package com.madhem.product_project;

import com.madhem.product_project.entities.Categorie;
import com.madhem.product_project.entities.Produit;
import com.madhem.product_project.repository.ProduitRepository;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProduitsApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Dell",2200.500,new Date());
        Produit prod1 = new Produit("iphone X",2200.500,new Date());
        Produit prod2 = new Produit("iphone",2200.500,new Date());
        produitRepository.save(prod);
    }


    @Test
    public void testFindProduit() {
        Optional<Produit> produitOptional = produitRepository.findById(2L);
        assertTrue(produitOptional.isPresent(), "Produit not found");
        Produit p = produitOptional.get();
        System.out.println(p);
    }

    @Test
    public void testUpdateProduit() {
        Produit p = produitRepository.findById(2L).get();
        p.setPrixProduit(1000.0);
        produitRepository.save(p);
    }

    @Test
    public void testDeleteProduit() {
        produitRepository.deleteById(3L);;
    }

    @Test
    public void testListerTousProduits() {
        List<Produit> prods = produitRepository.findAll();

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomProduit() {
        List<Produit> prods = produitRepository.findByNomProduit("iphone X");

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByNomProduitContains () {
        List<Produit> prods=produitRepository.findByNomProduitContains("iphone");

        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByNomPrix() {
        List<Produit> prods = produitRepository.findByNomPrix("iphone X", 1000.0);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByCategorie() {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);
        List<Produit> prods = produitRepository.findByCategorie(cat);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void findByCategorieIdCat() {
        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
        for (Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix() {
        List<Produit> prods = produitRepository.trierProduitsNomsPrix();
        for (Produit p : prods) {
            System.out.println(p);
        }
    }
}