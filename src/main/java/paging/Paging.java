package paging;

public class Paging {
    //private 생성자(객체 생성을 위한 클래스가 아님(모든 메소드가 public static)
    private Paging(){}

    //한 페이지에 보여줄 요소의 개수
    private final static int pageCount=10;

    //현재페이지는 null
    private static String currentPage=null;


    //pageCount는 final로 Getter만
    public static int getPageCount() {
        return pageCount;
    }


    //Getter & Setter
    public static String getCurrentPage() {
        return currentPage;
    }

    public static void setCurrentPage(String currentPage) {
        Paging.currentPage = currentPage;
    }

    //currentPage를 인자로 받아서 현재 Blcok이 몇번째인지를 계산해서 반환하여주는 메소드
    public static int getBlockNum(int currentPage){
        //매개변수를 getPageCount()가 반환하는 값으로 나눠준다.(몫)
        int share=currentPage/Paging.getPageCount();
        //매개변수를 getPageCount()가 반환하는 값으로 나눠준다.(나머지)
        int remainder=currentPage%Paging.getPageCount();

        //1~10은 1이고, 2~20은 2가되어야하기 때문에 몫과 나머지를 모두 활용하여 알고리즘을 구현

        //result는 몫의 값이 되는데
        int result=share;
        //만약 몫은 0이아니고 나머지가 0이면(ex.10, 20, 30)
        if(share!=0 && remainder==0){
            //result값을 1빼준다.
            result=result-1;
        }
        //result가 0보다 작으면 0이되게해준다.
        if(result<0){
            result=0;
        }

        //이후 result를 10곱하고 1더해준다.
        result=(result*10)+1;

        return result;
    }
}
