package hello.core.singleton;

//테스트 코드 만들기

public class StatefulService {

    //private int price; // 상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
    //this.price = price; // 여기가문제!
        return price;
    }

//    public int getPrice() {
//       return price;
//    }

}
