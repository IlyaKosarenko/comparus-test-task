package comparus.test.task.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;


@ConfigurationProperties(prefix = "task")
public class DataBaseConfigurationProperties {

    private List<DataSourceProperties> datasources;

    public List<DataSourceProperties> getDatasources() {
        return datasources;
    }

    public void setDatasources(List<DataSourceProperties> datasources) {
        this.datasources = datasources;
    }

    public static class DataSourceProperties {
        private String name;
        private String password;
        private String url;
        private String username;
        private String table;
        private String schema;
        private AttributesMapping mapping;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        public String getSchema() {
            return schema;
        }

        public void setSchema(String schema) {
            this.schema = schema;
        }

        public AttributesMapping getMapping() {
            return mapping;
        }

        public void setMapping(AttributesMapping mapping) {
            this.mapping = mapping;
        }

        @Override
        public String toString() {
            return "DataSourceProperties{" +
                    "name='" + name + '\'' +
                    ", password='" + password + '\'' +
                    ", url='" + url + '\'' +
                    ", username='" + username + '\'' +
                    ", table='" + table + '\'' +
                    ", schema='" + schema + '\'' +
                    ", attributesMapping=" + mapping +
                    '}';
        }

        public static class AttributesMapping {
            private String id;
            private String username;
            private String name;
            private String surname;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSurname() {
                return surname;
            }

            public void setSurname(String surname) {
                this.surname = surname;
            }

            @Override
            public String toString() {
                return "AttributesMapping{" +
                        "id='" + id + '\'' +
                        ", username='" + username + '\'' +
                        ", name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        '}';
            }
        }

    }
}

