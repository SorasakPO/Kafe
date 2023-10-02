package ku.cs.kafe.service;


import ku.cs.kafe.entity.Category_Sorasak_6210451560;
import ku.cs.kafe.entity.Menu_Sorasak_6210451560;
import ku.cs.kafe.model.MenuRequest_Sorasak_6210451560;
import ku.cs.kafe.repository.CategoryRepository_Sorasak_6210451560;
import ku.cs.kafe.repository.MenuRepository_Sorasak_6210451560;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class MenuService_Sorasak_6210451560 {


    @Autowired
    private MenuRepository_Sorasak_6210451560 menuRepository;


    @Autowired
    private CategoryRepository_Sorasak_6210451560 categoryRepository;


    @Autowired
    private ModelMapper modelMapper;


    public List<Menu_Sorasak_6210451560> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu_Sorasak_6210451560 getOneById(UUID id) {
        return menuRepository.findById(id).get();
    }



    public void createMenu(MenuRequest_Sorasak_6210451560 request) {
        Menu_Sorasak_6210451560 record = modelMapper.map(request, Menu_Sorasak_6210451560.class);
        Category_Sorasak_6210451560 category =
                categoryRepository.findById(request.getCategoryId()).get();
        record.setCategory(category);
        menuRepository.save(record);
    }
}
