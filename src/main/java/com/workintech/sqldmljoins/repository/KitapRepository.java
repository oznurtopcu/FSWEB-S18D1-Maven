package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {

    //Dram ve Hikaye türündeki kitapları listeleyin. JOIN kullanmadan yapın.
    String QUESTION_1 = "SELECT * FROM kitap WHERE turno = (SELECT turno FROM tur WHERE ad='Dram') or turno= (SELECT turno FROM tur WHERE ad='Hikaye');";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Kitap> findBooks();
    //SELECT k.* FROM kitap k, tur t WHERE k.turno=t.turno and t.ad in('Hikaye','Dram');

    //Tüm kitapların ortalama puanını bulunuz.
    String QUESTION_10 = "SELECT AVG(puan) FROM kitap;";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();


}
