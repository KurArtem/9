public class EnglishTranslation extends Translation {
    //region EN
    protected String[] enFirstClass = {
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine"
    };

    protected String[] enPreComposite = {
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifty",
            "sixteen",
            "seventeen",
            "ninety"
    };

    protected String[] enSecondClass = {
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };

    protected EnglishTranslation(int num) {
        super(num);
    }
    //endregion

    public synchronized String en(int number) throws Exception {
        if (test(number)) {
            NumTypes type = analyze(number);
            var result = new StringBuilder();

            var first = getFirstClass(number);
            var second = getSecondClass(number);

            switch (type) {
                case SIMPLE -> result.append(enFirstClass[number]);
                case PRE_COMPOSITE -> result.append(enPreComposite[number - 10]);
                case COMPOSITE_DEC -> result.append(enSecondClass[second - 2]);
                case COMPOSITE -> result
                        .append(enSecondClass[second - 2])
                        .append(" ")
                        .append(enFirstClass[first]);
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
            eT = en(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
