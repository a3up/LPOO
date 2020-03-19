public class Ellipse extends Shape {
    private float xRadius, yRadius;

    public Ellipse(float xRadius, float yRadius) {
        this.xRadius = xRadius;
        this.yRadius = yRadius;
    }

    public float getxRadius() {
        return xRadius;
    }

    public void setxRadius(float xRadius) {
        this.xRadius = xRadius;
    }

    public float getyRadius() {
        return yRadius;
    }

    public void setyRadius(float yRadius) {
        this.yRadius = yRadius;
    }
}
