package vaxtodo;

public class testVisiteur {

    public void runTests() {
        testValidVisitor();
        testNumTell();
    }

    public void testValidVisitor() {
        String[] infos = { "Qazwsx123@", "Achard", "Fred", "2000-02-06", "frederic.achard-groleau@umontreal.ca",
                "1600,Pennsylvania", "20500", "Washington", "6038320277", "NON" };

        System.out.println(Visitor.isValid(infos));
    }

    public void testNumTell() {
        String[] infos = { "Bonjour", "Achard", "Fr_d", "2000/02/06", "frederic.achard-groleauatumontreal.ca",
                "16oo,Pennsylvania", "20_500", "Washington", "(603)832", "AHH" };

        System.out.println(Visitor.isValid(infos));
    }

}
