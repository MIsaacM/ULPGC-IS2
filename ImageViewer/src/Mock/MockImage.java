package Mock;

import Model.Bitmap;
import Model.Image;
import java.io.File;

public class MockImage implements Image {
    private final File file;
    private Image next;
    private Image prev;

    public MockImage(File file) {
        this.file = file;
    }

    @Override
    public Bitmap getBitmap() {
        return null;
    }

    @Override
    public Image getNext() {
        return next;
    }

    @Override
    public Image getPrev() {
        return prev;
    }

    @Override
    public void setNext(Image next) {
        this.next = next;
    }
    
    @Override
    public void setPrev(Image prev) {
        this.prev = prev;
    }
    
    
    
}
