package com.iyengarcoders.groceries.security.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iyengarcoders.groceries.dto.AddressDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class SignUpRequest {

    // need to add more fields probably.

    @NotBlank
    @Size(min = 3, max = 25)
    @JsonProperty("username")
    private String username;

    @NotBlank
    @Size(max = 40)
    @Email
    @JsonProperty("email")
    private String email;

    @NotBlank
    @Size(min = 6, max = 20)
    @JsonProperty("password")
    private String password;

    @NotBlank
    @Size(min = 4, max = 40)
    @JsonProperty("firstName")
    private String firstName;


    @Size(min = 4, max = 40)
    @JsonProperty("middleName")
    private String middleName;

    @NotBlank
    @Size(min = 4, max = 40)
    @JsonProperty("lastName")
    private String lastName;

    @NotBlank
    @Size(min = 4, max = 40)
    @JsonProperty("cellPhone")
    private String cellPhone;


    @Size(min = 4, max = 40)
    @JsonProperty("homePhone")
    private String homePhone;

    @JsonProperty("shippingAddresses")
    private List<AddressDto> shippingAddresses;



    public SignUpRequest() {
    }

    SignUpRequest(@NotBlank @Size(min = 3, max = 25) String username, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(min = 6, max = 20) String password, @NotBlank @Size(min = 4, max = 40) String firstName, @Size(min = 4, max = 40) String middleName, @NotBlank @Size(min = 4, max = 40) String lastName, @NotBlank @Size(min = 4, max = 40) String cellPhone, @NotBlank @Size(min = 4, max = 40) String homePhone, List<AddressDto> shippingAddresses) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cellPhone = cellPhone;
        this.homePhone = homePhone;
        this.shippingAddresses = shippingAddresses;
    }

    public static SignUpRequest.SignUpRequestBuilder builder() {
        return new SignUpRequest.SignUpRequestBuilder();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public List<AddressDto> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<AddressDto> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", shippingAddresses=" + shippingAddresses +
                ", email='" + email + '\'' +
                '}';
    }

    public static class SignUpRequestBuilder {

        private String username;

        private String firstName;

        private String middleName;

        private String lastName;

        private String cellPhone;

        private String homePhone;

        private List<AddressDto> shippingAddresses;

        private String email;

        private String password;

        public SignUpRequestBuilder() {
        }

        public SignUpRequestBuilder username(String username) {
            this.username = username;
            return this;
        }

        public SignUpRequestBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public SignUpRequestBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public SignUpRequestBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public SignUpRequestBuilder cellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
            return this;
        }

        public SignUpRequestBuilder homePhone(String homePhone) {
            this.homePhone = homePhone;
            return this;
        }

        public SignUpRequestBuilder email(String email) {
            this.email = email;
            return this;
        }

        public SignUpRequestBuilder password(String password) {
            this.password = password;
            return this;
        }

        public SignUpRequestBuilder shippingAddresses(List<AddressDto> shippingAddresses) {
            this.shippingAddresses = shippingAddresses;
            return this;
        }

        public SignUpRequest build() {
            return new SignUpRequest(this.username,this.email,this.password,this.firstName, this.middleName, this.lastName, this.cellPhone, this.homePhone,this.shippingAddresses);
        }

        @Override
        public String toString() {
            return "SignUpRequestBuilder{" +
                    "username='" + username + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", cellPhone='" + cellPhone + '\'' +
                    ", homePhone='" + homePhone + '\'' +
                    ", shippingAddresses=" + shippingAddresses +
                    ", email='" + email + '\''+
                    '}';
        }
    }
}
