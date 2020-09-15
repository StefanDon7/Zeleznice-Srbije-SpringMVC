package fon.zeleznicesrbije.repository;


import java.util.List;
import fon.zeleznicesrbije.domain.Polazak;

///**
// *
// * @author Stefan
// */
public interface PolazakRepository {
   List<Polazak> getAll();
   Polazak getById(int id);

   
}
