package hello.core.singleton;

public class SingletonService {

    //자바가 뜨면서 static 영역에 있는거 초기화 하면서
    private static final SingletonService instance = new SingletonService();


    //이건 조회할때
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }//밖에서 새롭게 new로 하는거 막는것

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출 !!! ");
    }

}
