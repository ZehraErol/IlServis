package tr.zehraerol.IlServis.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tr.zehraerol.IlServis.exception.IlAlreadyExistsException;
import tr.zehraerol.IlServis.exception.IlNotFoundException;
import tr.zehraerol.IlServis.model.Il;
import tr.zehraerol.IlServis.repository.IlRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ILService {
    private final IlRepository ilRepository;
    public List<Il>getIller(String name){
        if (name == null) {
            return ilRepository.findAll();//Eğer Request param kısmında ben isim yollamadıysam tüm illeri getir
        }else {
            return ilRepository.findAllByName(name);
        }
    }
public Il createIl(Il newIl){
    Optional<Il> ilByName = ilRepository.findByName(newIl.getName());  //varsa hata verıyoruz yoksa save ediyoruz
    if (ilByName.isPresent()){
        throw new IlAlreadyExistsException("IL already exist with name :" +newIl.getName());
    }
    return ilRepository.save(newIl);
}

public void deleteIl(String id){
        ilRepository.deleteById(id);}
    public Il getIlById(String id){
        return ilRepository.findById(id)
                .orElseThrow(() -> new IlNotFoundException("IL Not Found with id:" +id));
}
public void updateIl(String id, Il newIl){
        Il oldIl = getIlById(id); //Güncellenecek id bulunuyor ve bir değişkene atanıyor
        oldIl.setName(newIl.getName()); //Kullanıcının gönderdiği ilin ismini setle
        ilRepository.save(oldIl); //eski il üzerine yeni ismi kaydet
}
}



