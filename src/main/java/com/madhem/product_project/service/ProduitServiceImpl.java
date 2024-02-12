package com.madhem.product_project.service;

import java.util.List;
import java.util.stream.Collectors;

import com.madhem.product_project.dto.ProduitDTO;
import com.madhem.product_project.entities.Categorie;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import com.madhem.product_project.entities.Produit;
import com.madhem.product_project.repository.ProduitRepository;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProduitDTO saveProduit(Produit p) {
        return convertEntityToDto( produitRepository.save(p));
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }
    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }
    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto( produitRepository.findById(id).get());
    }
    @Override
    public List<ProduitDTO> getAllProduits() {


        return produitRepository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

	/* @Override
	public ProduitDTO convertEntityToDto(Produit produit) {
	ProduitDTO produitDTO = new ProduitDTO();
		produitDTO.setIdProduit(produit.getIdProduit());
		produitDTO.setNomProduit(produit.getNomProduit());
		produitDTO.setPrixProduit(produit.getPrixProduit());
		produitDTO.setDateCreation(produit.getDateCreation());
		produitDTO.setCategorie(produit.getCategorie());
		return produitDTO;
	} */

    public Produit convertDtoToEntity(ProduitDTO produitDto) {
        Produit produit = new Produit();
        produit = modelMapper.map(produitDto, Produit.class);
        return produit;
    }

    @Override
    public ProduitDTO saveProduit(ProduitDTO p) {
        return convertEntityToDto( produitRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public ProduitDTO updateProduit(ProduitDTO p) {
        return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);
        return produitDTO;
    }
}