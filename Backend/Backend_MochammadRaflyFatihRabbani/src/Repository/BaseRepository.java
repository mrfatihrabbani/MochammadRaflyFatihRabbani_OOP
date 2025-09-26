package Repository;
import java.util.*;

public abstract class BaseRepository <T, ID>{

    protected List<T> dataList = new ArrayList<>();
    protected Map<ID, T> dataMap = new HashMap<>();

    public Optional<T> findById(ID id){
        return Optional.ofNullable(dataMap.get(id));
    }

    public List<T> findAll(){
        return new ArrayList<>(dataList);
    }

    public void deleteById(ID id){
        T entity = dataMap.remove(id);
        if (entity != null){
            dataList.remove(entity);
        }
    }


    public abstract void save(T entity);
    public abstract ID getId(T entity);


}
