package ku.cs.kafe.service;


import ku.cs.kafe.entity.Category_Sorasak_6210451560;
import ku.cs.kafe.model.CategoryRequest_Sorasak_6210451560;
import ku.cs.kafe.repository.CategoryRepository_Sorasak_6210451560;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CategoryService_Sorasak_6210451560 {


    @Autowired
    private CategoryRepository_Sorasak_6210451560 categoryRepository;


    @Autowired
    private ModelMapper modelMapper;


    public List<Category_Sorasak_6210451560> getAllCategories() {
        return categoryRepository.findAll();
    }


    public void createCategory(CategoryRequest_Sorasak_6210451560 request) {
        Category_Sorasak_6210451560 record = modelMapper.map(request, Category_Sorasak_6210451560.class);
        categoryRepository.save(record);
    }
}
