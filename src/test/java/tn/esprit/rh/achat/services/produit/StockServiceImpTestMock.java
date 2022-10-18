package tn.esprit.rh.achat.services.produit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.IStockService;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImpTestMock {
@Mock
StockRepository stockRepository;

@InjectMocks
StockServiceImpl stockServiceImpl;

    Stock stock= Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build();
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(Stock.builder().libelleStock("stock test1").qte(150).qteMin(15).build());
            add(Stock.builder().libelleStock("stock test2").qte(300).qteMin(30).build());
        }
    };

    @Test
    public void testRetrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = stockServiceImpl.retrieveStock((stock.getIdStock());
        Assertions.assertNotNull(stock1);
        System.out.println(" Retrieve is working ");
        
    }
   

    @Test
    public void testRetrieveAllStock() {
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> lStocks = stockServiceImpl.retrieveAllStocks();
        Assertions.assertNotNull(lStocks);
        System.out.println(" Retrieve all is working ");
    }
    

    @Test
    public void testAddstock() {
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);
        Stock stock1 = stockServiceImpl.addStock(stock);
        Assertions.assertNotNull(stock1);
        System.out.println(" Save is working ");

    }
   @Test
    public void testUpdatestock() {
        stock.setQteMin(6);
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);
        Stock stock1 = stockServiceImpl.updateStock(stock);
        Assertions.assertEquals(stock,stock1);
        System.out.println(" update is working ");

    }

   @Test
   public void testDeletestock() {
       stockServiceImpl.deleteStock(stock.getIdStock());
       Mockito.verify(stockRepository, Mockito.times(1)).deleteById(stock.getIdStock());
       System.out.println(" delete is working ");
    }
}
