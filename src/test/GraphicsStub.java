package test;


public class GraphicsStub extends ConcreteGraphics {
    int numbOfDrawOvalCalls;
    int numbOfFillOvalCalls;
    int x;
    int y;
    int width;
    int height;

    @Override
    public void fillOval(int x, int y, int width, int height) {
        numbOfFillOvalCalls++;
    }

    @Override
    public void drawOval(int x, int y, int width, int height) {
        numbOfDrawOvalCalls++;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
