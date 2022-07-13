import models.Profile;
import models.User;
import utils.ReflectionUtils;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Profile profile = new Profile(1, "Jojo", "bio", 20);
        User user = new User(5, "Dima");
        Set<Object> models = Set.of(user, profile);
        Map<String, Object> columnNames = null;

        for (Object o : models) {
            columnNames = ReflectionUtils.getFilledMap(o);
            String tableName = ReflectionUtils.getTableName(o.getClass());
            ReflectionUtils.selectData(models, columnNames, tableName);

        }

    }

}
