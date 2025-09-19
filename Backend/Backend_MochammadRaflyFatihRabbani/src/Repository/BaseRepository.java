package Repository;
import java.util.*;

public abstract class BaseRepository <T, ID>{

    protected ArrayList<T> List = new ArrayList<>();
    HashMap<ID, T> Map = new HashMap<>();

    public Optional<T> findById(ID id){
        return ;
    }

    public Optional<T> findAll(){
        return ;
    }


    public void save(T entity){}
    public void getId(T entity){

    }




}
