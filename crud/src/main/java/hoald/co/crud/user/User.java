package hoald.co.crud.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    @Column(nullable = false, length = 15)
    private String password;
    @Column(nullable = false, length = 10, name = "firstname")
    private String firstname;
    @Column(nullable = false, length = 10, name = "lastname")
    private String lastname;

    public User() {
    }

    public User(Integer id, String email, String password, String firstname, String lastname) {
        this.setId(id);
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstname(firstname);
        this.setLastname(lastname);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
