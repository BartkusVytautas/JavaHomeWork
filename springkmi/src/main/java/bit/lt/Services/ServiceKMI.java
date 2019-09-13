package bit.lt.Services;

import bit.lt.Entities.KMI;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceKMI {

    List<KMI> getKMIlist();
    KMI getKMI (Integer id);
    void saveKMI(KMI kmi);
    void deleteKMI(Integer id);
}
