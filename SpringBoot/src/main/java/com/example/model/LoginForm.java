package com.example.model;

import javax.validation.constraints.Size;

    /**
     * @author Hugo Malglaive
     * @version 1.0
     * @since SpringBoot
     */
    public class LoginForm {

        private String email;

        private String pwd;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        @Override
        public String toString() {
            return "MailForm{" +
                    "email='" + email + '\'' +
                    '}';
        }
    }

