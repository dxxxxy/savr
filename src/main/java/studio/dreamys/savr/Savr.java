package studio.dreamys.savr;

import com.google.gson.Gson;
import studio.dreamys.savr.util.FileUtils;

@SuppressWarnings("unused")
public class Savr<T> {
    private static Gson gson = new Gson();

    private Class<T> clazz;
    private FileUtils fu;

    public Savr(Class<T> clazz, String path) {
        this.clazz = clazz;

        fu = new FileUtils(path);
    }

    public void save(T o) {
        fu.compress(gson.toJsonTree(o).toString());
    }

    public T load() {
        return gson.fromJson(fu.decompress(), clazz);
    }
}
