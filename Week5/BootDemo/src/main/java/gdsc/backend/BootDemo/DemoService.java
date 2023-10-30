package gdsc.backend.BootDemo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
@Service
public class DemoService {
    private final List<DemoEntity> demoEntities = new ArrayList<>(Arrays.asList(
            new DemoEntity(1L, "1번"),
            new DemoEntity(2L, "2번"),
            new DemoEntity(3L, "3번")
    ));

    public List<DemoDto> getDemoEntities() {
        List<DemoDto> demoDtos = new ArrayList<>();
        for (DemoEntity demoEntity : demoEntities) {
            demoDtos.add(new DemoDto(demoEntity.getId(), demoEntity.getName()));
        }
        return demoDtos;
    }
    public void addDemoEntity(DemoDto demoDto) {
        demoEntities.add(new DemoEntity(demoDto.getId(), demoDto.getName()));
    }
    public DemoDto getDemoEntityById(Long id) {
        for (DemoEntity demoEntity : demoEntities) {
            if (demoEntity.getId().equals(id)) {
                return new DemoDto(demoEntity.getId(), demoEntity.getName());
            }
        }
        return null; // 지정된 id와 일치하는 엔터티를 찾지 못한 경우 null 반환.
    }
}
