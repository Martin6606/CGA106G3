package CGA106G3.com.memoitem.Controller;

import CGA106G3.com.memoitem.DTO.MemoitemDTO;
import CGA106G3.com.memoitem.Service.MemoitemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memoitemManage")
public class MemoitemController {
    @Autowired
    private MemoitemServiceImpl service;
    @GetMapping("/getOne")
    public MemoitemDTO getOne(@RequestParam Integer mino){
        return service.getOne(mino);
    }
    @GetMapping("/SearchByName")
    public List<MemoitemDTO> getByMemoitemName(@RequestParam String miname){return  service.getByName(miname);}
    @GetMapping("/SearchBySTA")
    public List<MemoitemDTO> getByMemoitemSTA(@RequestParam Integer mista){return  service.getBySTA(mista);}
    @PostMapping("/UpdateMemoitem")
    public  MemoitemDTO updateMemoitem(@RequestBody MemoitemDTO memoitemDTO){
        return  service.addMemoitem(memoitemDTO);
    }
    @PostMapping("/addMemoitem")
    public void addMemoitem(@RequestBody MemoitemDTO memoitemDTO){
        service.addMemoitem(memoitemDTO);
    }
    @GetMapping("/getAll")
    public List<MemoitemDTO> getAllmemotiem(){return service.getAll();};
    @GetMapping("/SearchBymicateno")
    public List<MemoitemDTO> findByMicateno(@RequestParam Integer micateno){return service.findByMicateno(micateno);}
}
