package spring_intro;
// паттерн одиночка, только я бы его назвал "братья", т.к. тут 2 инстанса, которые отдаются по-очереди.
public class SandBox {
    public static SandBox instance1;
    public static SandBox instance2;
    private static SandBox instanceToGive = instance1;

    public static SandBox OpenSandBox() {
        if (instance1 == null) instance1 = new SandBox();
        else if (instance2 == null) instance2 = new SandBox();

        if (instanceToGive == instance1) {
            instanceToGive = instance2;
            return instance2;
        } else {
            instanceToGive = instance1;
            return instance1;
        }
    }

    private SandBox() {
    }

    public static void main(String[] args) {
        SandBox s1 = SandBox.OpenSandBox();
        SandBox s2 = SandBox.OpenSandBox();
        SandBox s3 = SandBox.OpenSandBox();
        SandBox s4 = SandBox.OpenSandBox();
        System.out.println(s2 == s4);
        System.out.println(s1 == s3);
        System.out.println(s1 == s2);
    }
}
