package bit.lt.Services;

import bit.lt.DAO.KMIDAO;
import bit.lt.Entities.KMI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ServiceKMIImpl implements ServiceKMI{

    @Autowired
    private KMIDAO kmidao;

    @Transactional
    @Override
    public List<KMI> getKMIlist() {
        return kmidao.getKMIlist();
    }

    @Transactional
    @Override
    public KMI getKMI(Integer id) {
        return kmidao.getKMI(id);
    }

    @Transactional
    @Override
    public void saveKMI(KMI kmi) {
        kmidao.saveKMI(kmi);
    }

    @Transactional
    @Override
    public void deleteKMI(Integer id) {
        kmidao.deleteKMI(id);
    }
}
