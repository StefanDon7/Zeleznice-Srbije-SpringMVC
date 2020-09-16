package fon.zeleznicesrbije.repository;


import java.util.List;
import fon.zeleznicesrbije.domain.Polazak;

///**
// *
// * @author Stefan
// */
public interface PolazakRepository {
   List<Polazak> getAll();
   List<Polazak> getAllByDate(Polazak p);
   Polazak getById(int id);

   
}
