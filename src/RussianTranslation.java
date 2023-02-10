public class RussianTranslation extends Translation {
    //region RU
    protected String[] ruFirstClass = {
            "ноль",
            "один",
            "два",
            "три",
            "четыре",
            "пять",
            "шесть",
            "семь",
            "восемь",
            "девять",
    };

    protected String[] ruPreComposite = {
            "десять",
            "одиннадцать",
            "двенадцать",
            "тринадцать",
            "четырнадцать",
            "пятнадцать",
            "шестнадцать",
            "семнадцать",
            "восемнадцать",
            "девятнадцать"
    };

    protected String[] ruSecondClass = {
            "двадцать",
            "тридцать",
            "сорок",
            "пятьдесят",
            "шестьдесят",
            "семьдесят",
            "восемьдесят",
            "девяносто"
    };

    protected RussianTranslation(int num) {
        super(num);
    }
    //endregion

    public synchronized String ru(int number) throws Exception {
        if (test(number)) {
            NumTypes type = analyze(number);
            var result = new StringBuilder();

            var first = getFirstClass(number);
            var second = getSecondClass(number);

            switch (type) {
                case SIMPLE -> result.append(ruFirstClass[number]);
                case PRE_COMPOSITE -> result.append(ruPreComposite[number - 10]);
                case COMPOSITE_DEC -> result.append(ruSecondClass[second - 2]);
                case COMPOSITE -> result
                        .append(ruSecondClass[second - 2])
                        .append(" ")
                        .append(ruFirstClass[first]);
                default -> throw new Exception("Something is went wrong");
            }

            return result.toString();
        }
        else {
            throw new Exception("Number is invalid");
        }
    }

    @Override
    public void run() {
        try {
            rT = ru(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
