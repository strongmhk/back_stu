package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // 실무의 멀티스레드 환경에서는 그냥 해쉬맵말고 ConcurrentHashMap 사용해야함
    // static 사용했음에 주의! -> ItemRepository 객체마다 store가 달라지면 안되기 때문에
    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values()); // 실제 store에 접근해서 변경할 수 없게 ArrayList로 감싸서 반환
    }

    // ItemParamDto로 만들어서 id제외하고 넘기는게 좋음
    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    // 테스트용
    public void clearStore(){
        store.clear();
    }


}
