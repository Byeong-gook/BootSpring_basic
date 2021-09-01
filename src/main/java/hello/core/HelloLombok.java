package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdfas");

        String name = helloLombok.getName();;
        System.out.println("name = " + name);

        // 롬복을 통해 Getter Setter가 없음에도 Get Set 메서드를 선언 없이도 사용가능.

        //toStirng
        System.out.println("helloLombok = " + helloLombok);
    }
}
