public class Box {


    float boxLength;
    float boxWidth;
    float boxHeight;

    public Box(float boxLength, float boxWidth, float boxHeight) {
        this.boxLength = boxLength;
        this.boxWidth = boxWidth;
        this.boxHeight = boxHeight;
    }

    public boolean validate(float length, float width, float height) {

        if(length>boxLength) {
            return false;
        }else if(width>boxWidth){
            return false;
        }else if(height>boxHeight){
            return false;
        }

        return true;
    }

}
