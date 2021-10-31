import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TesseractDemo {
    public static void main(String[] args) throws TesseractException, IOException {
        //requires PNG
        File image = new File("src/main/resources/testMid.png");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/OCR/tessdata");
        tesseract.setLanguage("eng");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        tesseract.setTessVariable("user_defined_dpi", "350");
//        String result = tesseract.doOCR(ImageHelper.convertImageToGrayscale(ImageIO.read(image)));
//        cv2.resize(img, None, fx=1.2, fy=1.2, interpolation=cv2.INTER_CUBIC)
//        String result =  tesseract.doOCR(image);
        for(Integer i = 70; i<=2400; i++) {
            tesseract.setTessVariable("user_defined_dpi", i.toString());
            String result = tesseract.doOCR(ImageHelper.convertImageToGrayscale(ImageIO.read(image)));
            if(result.contains("Red team has slain")) {
                System.out.println("Red team has slain " + i);
            }
            if(result.contains("Red team has slain the Dragon")) {
                System.out.println("Red team has slain the Dragon " + i);
            }
        }
    }
}
