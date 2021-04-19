
package blood.bank.project;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

public class Donor {
    private String Name;
    private  String phone;
    private  String Blood;
    private  String address;
    private  String gender;
    private  String age;
    private  String weight;
    private  String Health_Disorder;
    

    public Donor(String Name, String phone, String Blood, String address, String gender, String age, String weight, String Health_Disorder) {
        this.Name = Name;
        this.phone = phone;
        this.Blood = Blood;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.Health_Disorder = Health_Disorder;
        
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBlood() {
        return Blood;
    }

    public void setBlood(String Blood) {
        this.Blood = Blood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHealth_Disorder() {
        return Health_Disorder;
    }

    public void setHealth_Disorder(String Health_Disorder) {
        this.Health_Disorder = Health_Disorder;
    }
   
   
}
