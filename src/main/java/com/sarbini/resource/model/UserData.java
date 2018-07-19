package com.sarbini.resource.model;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sarbini.resource.constant.Constants;
import com.sarbini.resource.domain.Authority;
import com.sarbini.resource.domain.User;

import lombok.Getter;
import lombok.Setter;

/**
 * A DTO representing a user, with his authorities.
 */
@Getter
@Setter
public class UserData {

    private Long id;

    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Size(min = 5, max = 100)
    private String email;

//    @Size(max = 256)
//    private String imageUrl;
//
//    private boolean activated = false;
//
//    @Size(min = 2, max = 5)
//    private String langKey;
//
//    private String createdBy;
//
//    private Instant createdDate;
//
//    private String lastModifiedBy;
//
//    private Instant lastModifiedDate;
//
//    private Set<String> authorities;

    public UserData() {
        // Empty constructor needed for Jackson.
    }

    public UserData(User user) {
        this(user.getId(), user.getLogin(), user.getFirstName(), user.getLastName(),
            user.getEmail(), user.isActivated(), user.getImageUrl(), user.getLangKey(),
            user.getAuthorities().stream().map(Authority::getName)
                .collect(Collectors.toSet()));
    }

    public UserData(Long id, String login, String firstName, String lastName,
        String email, boolean activated, String imageUrl, String langKey,
        Set<String> authorities) {

        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
//        this.activated = activated;
//        this.imageUrl = imageUrl;
//        this.langKey = langKey;
//        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "login='" + login + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
//            ", imageUrl='" + imageUrl + '\'' +
//            ", activated=" + activated +
//            ", langKey='" + langKey + '\'' +
//            ", createdBy=" + createdBy +
//            ", createdDate=" + createdDate +
//            ", lastModifiedBy='" + lastModifiedBy + '\'' +
//            ", lastModifiedDate=" + lastModifiedDate +
//            ", authorities=" + authorities +
            "}";
    }

	public void buildUserData(User user) {
		setId(user.getId());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setLogin(user.getLogin());
	}
}
