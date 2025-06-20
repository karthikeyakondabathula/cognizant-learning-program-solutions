public class FactoryMethodPatternExample{
public static void main(String[] args){

DocumentFactory f;

f = new WordFactory();
Document d1 = f.createDocument();
d1.open();


    f = new PdfFactory();
    Document d2 = f.createDocument();
d2.open();


  f = new ExcelFactory(); Document d3 = f.createDocument(); d3.open();

}
}

interface Document{
void open();
}

class WordDocument implements Document{
public void open(){
System.out.println("opening word file");
}
}

class PdfDocument implements Document {
    public void open( ) {
System.out.println("openin pdf");
    }
}


class ExcelDocument implements Document {
public void open(){
    System.out.println("excel file opened");
}
}

abstract class DocumentFactory{
abstract Document createDocument();
}

class WordFactory extends DocumentFactory{
public Document createDocument(){
return new WordDocument();
}
}

class PdfFactory extends DocumentFactory {
public Document createDocument( ) {
    return new PdfDocument();
}
}

class ExcelFactory extends DocumentFactory{
public Document createDocument(){
return new ExcelDocument();
}
}
