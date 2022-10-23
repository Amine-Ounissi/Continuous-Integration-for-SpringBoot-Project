package tn.esprit.rh.achat.Dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.rh.achat.entities.Produit;

import java.util.Set;

@Getter
@Setter
public class DtoStock {

    private Long idStock;
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;

    private Set<Produit> produits;

    public DtoStock(String libelleStock, Integer qte, Integer qteMin) {
        super();
        this.libelleStock = libelleStock;
        this.qte = qte;
        this.qteMin = qteMin;
    }
}