package com.madhem.product_project.service;

import java.util.List;

import com.madhem.product_project.dto.ProduitDTO;
import com.madhem.product_project.entities.Categorie;
import com.madhem.product_project.entities.Produit;

public interface ProduitService {
    // Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    //Produit getProduit(Long id);
    //List<Produit> getAllProduits();
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom, Double prix);
    List<Produit> findByCategorie (Categorie categorie);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();

    Produit convertDtoToEntity(ProduitDTO produitDto);
    ProduitDTO convertEntityToDto (Produit produit);
    ProduitDTO saveProduit(Produit p);
    ProduitDTO getProduit(Long id);
    List<ProduitDTO> getAllProduits();
    ProduitDTO saveProduit(ProduitDTO p);
    ProduitDTO updateProduit(ProduitDTO p);
}