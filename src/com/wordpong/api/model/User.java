package com.wordpong.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.googlecode.objectify.annotation.Indexed;
import com.googlecode.objectify.annotation.Unindexed;

@Unindexed
public class User implements Serializable {
    public static final String PROP_EMAIL = "email";
    public static final String PROP_FIRST_NAME = "firstName";
    public static final String PROP_LAST_NAME = "lastName";
    public static final String PROP_ACTIVATED = "activated";

    private static final long serialVersionUID = 1L;

    @Indexed
    @Id
    private Long id;

    @Indexed
    private String email;

    @Indexed
    private String firstName;

    @Indexed
    private String lastName;

    @Indexed
    private boolean activated;

    private String password; // encrypted by PasswordTypeConverter

    @Transient
    private Preferences preferences;
    /**
     * The secret key of the account, used to decrypt the information in the
     * account
     */
    @Transient
    private SecretKey encryptionKey = null;

    /* getters and setters... */

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    private List<Role> roles = new ArrayList<Role>();

    public List<Role> getRoles() {
        return roles;
    }

    public boolean hasRole(String role) {
        boolean result = Role.hasRole(roles, role);
        return result;
    }

    public SecretKey getEncryptionKey() {
        return encryptionKey;
    }

    public void getEncryptionKey(SecretKey s) {
        encryptionKey = s;
    }

    public void setEncryptionKey(SecretKey encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return String.format("User: %s %s (activated: %s) roles:%s", firstName, lastName, activated, roles);
    }

}