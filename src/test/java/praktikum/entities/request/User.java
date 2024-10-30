package praktikum.entities.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class User {

        private String email;

        private String password;

        private String name;

        public User(String email, String password) {
            this.email = email;
            this.password = password;
        }

    }


