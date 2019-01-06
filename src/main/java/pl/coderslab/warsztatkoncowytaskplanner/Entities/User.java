package pl.coderslab.warsztatkoncowytaskplanner.Entities;


import pl.coderslab.warsztatkoncowytaskplanner.DTO.UserDto;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;



    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Transient
    public UserDto toDto() {
        UserDto dto = new UserDto();
        dto.setId(this.getId());
        dto.setName(this.getName());
        return dto;
    }
}
