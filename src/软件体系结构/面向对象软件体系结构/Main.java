package 软件体系结构.面向对象软件体系结构;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        input.input("E:\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("E:\\output.txt");

    }
}
