public class Name {
    private String secname, name, father_name;

    public Name(String secname, String name, String father_name) {
        this.secname = secname;
        this.name = name;
        this.father_name = father_name;
    }

    @Override
    public String toString() { // здесь я решил не заморачиваться с полиморфизмом
        String s = "";
        if (secname != "") s += secname + " ";
        if (name != "") s += name + " ";
        if (father_name != "") s += father_name;
        if (s == "") s = "ФИО не было введено!";
        return s;
    }
}
