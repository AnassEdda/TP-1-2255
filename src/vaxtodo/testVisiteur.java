package vaxtodo;

public class testVisiteur {

    public void runTests() {
        testValid();
        testValidFail();
    }

    public void testValid() {
        String[] infos = { "Achard", "Fred", "2000-02-06", "frederic.achard-groleau@umontreal.ca",
                "1600,Pennsylvania", "20500", "Washington", "6038320277"};
        boolean result = Visitor.isValid(infos);
        
        assert result == true;
    }

    public void testValidFail() {
        String[] infos = { "Achard", "Fr_d", "2000/02/06", "frederic.achard-groleauatumontreal.ca",
                "16oo,Pennsylvania", "20_500", "Washington", "(603)832"};
        boolean result = Visitor.isValid(infos);
        
        assert result == false;
    }

}
