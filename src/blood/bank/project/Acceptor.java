
package blood.bank.project;

/**
 *
 * @author shahzaib saeed
 */
public class Acceptor {
    private String Name;
    private  String phone;
    private  String Blood;
    private  String address;
    private  String gender;
    private  String age;
    private  String disese;
    private  String hospital;

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

    public String getDisese() {
        return disese;
    }

    public void setDisese(String disese) {
        this.disese = disese;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Acceptor(String Name, String phone, String Blood, String address, String gender, String age, String disese, String hospital) {
        this.Name = Name;
        this.phone = phone;
        this.Blood = Blood;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.disese = disese;
        this.hospital = hospital;
    }
}
