package wm2.as3.login_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import wm2.as3.login_app.entity.Country;
import wm2.as3.login_app.service.CountryService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    Logger logger = LoggerFactory.getLogger(CountryController.class);

    @GetMapping("")
    public String getCountries(Model model){

        List<Country> countries = countryService.getCountryList();

        model.addAttribute("countries", countries);

        logger.info("Here are all countries in the list!");

        return "country_list";
    }

    @GetMapping("/{id}")
    public String getCountryById(Model model, @PathVariable Long id) throws Exception{
        if (!countryService.existingCountry(id)) {
            throw new Exception("This country does not exist!");
        }

        logger.info("Viewing a particular country!");

        model.addAttribute("country", countryService.getById(id));

        return "country_view";
    }

    @GetMapping("/edit/{id}")
    public String updateById(Model model, @PathVariable Long id) throws Exception{
        if (!countryService.existingCountry(id)) {
            throw new Exception("Can't edit non-existent country!");
        }

        logger.warn("Editing a country! Don't leave any field blank!");

        model.addAttribute("country", countryService.getById(id));

        return "country_new";
    }

    @GetMapping("/new")
    public String addNewCountry(Model model){
        model.addAttribute("country", new Country());

        logger.warn("Adding a new country! Don't leave any field blank!");

        return "country_new";
    }

    @GetMapping("/back")
    public String getCountries(){
        logger.info("Returning to main page!");

        return "home";
    }

    @PostMapping("/save")
    public String saveChanges(Model model, @Valid Country country, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.error("Changes to the country can't be saved because of an error!");

            return "country_new";
        }

        logger.info("Changes saved!");

        Country updatedCountry = countryService.save(country);

        model.addAttribute("country", updatedCountry);

        return "country_view";
    }

    @GetMapping("/delete/{id}")
    public String deleteCountry(@PathVariable Long id) throws Exception{
        if (!countryService.existingCountry(id)) {
            throw new Exception("Can't delete non-existent country!");
        }

        logger.info("Deleting a country!");

        countryService.deleteById(id);

        return "country_deleted";
    }
}
