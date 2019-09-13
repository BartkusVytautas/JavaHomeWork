package bit.lt.DAO;

import bit.lt.Entities.KMI;

import java.util.List;

public interface KMIDAO {

    List<KMI> getKMIlist();
    KMI getKMI (Integer id);
    void saveKMI(KMI kmi);
    void deleteKMI(Integer id);
}
