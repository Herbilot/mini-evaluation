package dev.herbidev.minievaluation.controller;



import dev.herbidev.minievaluation.dto.CoursDto;
import dev.herbidev.minievaluation.service.CoursService;
import dev.herbidev.minievaluation.service.ICoursService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CoursController {
    private static final Logger logger = LoggerFactory.getLogger(CoursController.class);

    private ICoursService coursService = new CoursService();

    @GetMapping("/cours")
    public String showCours(Model model) {

        try {
            Optional<List<CoursDto>> cours = coursService.findAll();
            if (cours.isPresent()) {
                logger.info("La liste de cours a été chargée avec succès");
                model.addAttribute("coursList", cours.get());
                System.out.println("debbug");
            } else {
                logger.info("Aucun cours à afficher !");
                model.addAttribute("coursList", new ArrayList<CoursDto>());
            }
        } catch (Exception e) {
            logger.error("La récupération de la liste de cours à échouée", e);
        }

        return "cours";
    }

    @PostMapping("/cours")
    public String saveProduct(
            @RequestParam("matiere") String matiere,
            @RequestParam("professeur") String professeur,
            @RequestParam("classe") String classe)
    {
        CoursDto coursDto = new CoursDto();
        coursDto.setMatiere(matiere);
        coursDto.setProfesseur(professeur);
        coursDto.setClasse(classe);

        try {
            boolean coursSaved = coursService.save(coursDto);
            if (coursSaved) {
                logger.info("Cours enregistré avec succès");
            } else {
                logger.warn("Échec de l'enregistrement du cours");
            }
        } catch (Exception e) {
            logger.error("Erreur lors de l'enregistrement du cours", e);
        }
        return "redirect:/";
    }
}

