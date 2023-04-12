package CGA106G3.com.process.Service;

import CGA106G3.com.process.DTO.ProDTO;
import CGA106G3.com.process.Entity.Pro;
import CGA106G3.com.process.repository.ProRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ProService {

    @Autowired
    private ProRepository proRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Pro addPro(Pro pro){
        return proRepository.save(pro);
    }
    public Pro updatePro(Pro pro){
        return proRepository.save(pro);
    }
    public Optional<Pro> findProById(Integer prono){
        return proRepository.findById(prono);
    }
    private ProDTO EntityToDTO(Pro pro){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ProDTO proDTO = new ProDTO();
        proDTO = modelMapper.map(pro, ProDTO.class);
        return proDTO;
    }

    public Page<Pro> findAll(Pageable pageable){
        return proRepository.findAll(pageable);
    }

    public Page<ProDTO> findAllProDTO(Pageable pageable) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Page<Pro> proPage = proRepository.findAll(pageable);
        List<ProDTO> pros = proPage.getContent()
                .stream()
                .map(this::EntityToDTO)
                .collect(Collectors.toList());
        return new PageImpl<>(pros, pageable, proPage.getTotalElements());
    }

    public long count(){
        return proRepository.count();
    }
}