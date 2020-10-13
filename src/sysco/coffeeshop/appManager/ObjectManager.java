package sysco.coffeeshop.appManager;

public interface ObjectManager<T> {
	public abstract void create(T obj);
	public abstract T read(String id);
	public abstract void delete(String id);
	public abstract boolean exists(T obj);
}
