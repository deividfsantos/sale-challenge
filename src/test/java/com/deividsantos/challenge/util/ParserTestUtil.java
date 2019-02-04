package com.deividsantos.challenge.util;

import java.util.List;

import static java.util.Arrays.asList;

public class ParserTestUtil {

    public static List<String> buildLines() {
        return asList(("001ç1234567891234çPedroç50000\n" +
                "001ç3245678865434çPauloç40000.99\n" +
                "002ç2345675434544345çJose da SilvaçRural\n" +
                "002ç2345675433444345çEduardo PereiraçRural\n" +
                "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro\n" +
                "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo").split("\n"));
    }

    public static List<String> buildWrongLines() {
        return asList(("dofhiofhieif\n" +
                "002ç23gas456dssd7543454sf434safs5çgsagasgJose da SilvaçRural\n" +
                "002ç2345sg6754ds33444345çEdafsguardo PereiraçRural\n" +
                "003ç08sadç[1-34dsass-10,sddssd2da33-gdg-0.10]çPasddaulo").split("\n"));
    }

}
