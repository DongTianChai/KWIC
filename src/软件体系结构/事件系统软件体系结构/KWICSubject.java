package �����ϵ�ṹ.�¼�ϵͳ�����ϵ�ṹ;

public class KWICSubject extends Subject{
    public void startKWIC(){
        for (int i = 0;i<4;i++){
            super.notifyOneObserver(i);
        }
    }
}
