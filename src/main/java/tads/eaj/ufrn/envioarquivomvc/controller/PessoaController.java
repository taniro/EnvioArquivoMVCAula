package tads.eaj.ufrn.envioarquivomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import tads.eaj.ufrn.envioarquivomvc.model.Pessoa;
import tads.eaj.ufrn.envioarquivomvc.service.FileStorageService;
import tads.eaj.ufrn.envioarquivomvc.service.PessoaService;

import java.util.List;

@Controller
public class PessoaController {

    FileStorageService fileStorageService;
    PessoaService service;

    public PessoaController(FileStorageService fileStorageService, PessoaService service) {
        this.fileStorageService = fileStorageService;
        this.service = service;
    }


    @GetMapping("/cadastrar")
    public String getCadastrarPage(Model model){
        Pessoa p = new Pessoa();
        model.addAttribute("pessoa", p);

        return "cadastrar";
    }

    @GetMapping({"/", "/index"})
    public String getIndexPage(Model model){
        List<Pessoa> pessoaList = this.service.listAll();
        model.addAttribute("pessoas", pessoaList);
        return "index";
    }

    @PostMapping("/doSalvar")
    public String doSalvar(@ModelAttribute Pessoa p, @RequestParam(name = "file") MultipartFile file){

        p.setFotoUri(file.getOriginalFilename());
        this.fileStorageService.save(file);
        this.service.save(p);
        return "redirect:/";
    }

    @GetMapping("/formatada")
    public String getPaginaFormatada(Model model){
        List<Pessoa> pessoaList = this.service.listAll();
        model.addAttribute("pessoas", pessoaList);

        return "formatada";
    }
}
