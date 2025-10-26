package prac2;

public class TestBall {
    public static void main(String[] args) {
        Ball ball1 = new Ball(10.5, 20.3);
        Ball ball2 = new Ball();

        System.out.println("ball1: " + ball1);
        System.out.println("ball2: " + ball2);

        ball2.setXY(5.0, 5.0);
        System.out.println("ball2 после setXY: " + ball2);

        ball1.move(2.5, -3.5);
        System.out.println("ball1 после move: " + ball1);

        System.out.println("Координаты ball2: X=" + ball2.getX() + ", Y=" + ball2.getY());
    }
}