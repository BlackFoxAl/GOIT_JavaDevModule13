package module13.db;

import org.flywaydb.core.Flyway;

public class Migration {
    public Migration() {
        DbConfig dbConfig = new DbConfig();
        Flyway flyway = Flyway.configure()
                .dataSource(dbConfig.getDbUrl(),dbConfig.getUsername(), dbConfig.getPassword())
                .load();
        flyway.migrate();
    }
}
