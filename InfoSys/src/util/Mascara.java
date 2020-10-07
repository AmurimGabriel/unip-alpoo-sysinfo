package util;

import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

public class Mascara {
    public static DefaultFormatterFactory getCpfMask() {
        MaskFormatter mask = null;

        try {
            mask = new MaskFormatter("###.###.###-##");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            throw new RuntimeException("Erro na formatação de CPF.");
        }

        return new DefaultFormatterFactory(mask);
    }

    public static DefaultFormatterFactory getFoneFixoMask() {
        MaskFormatter mask = null;

        try {
            mask = new MaskFormatter("(##) ####-####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            throw new RuntimeException("Erro na formatação do Telefone Fixo.");
        }

        return new DefaultFormatterFactory(mask);
    }

    public static DefaultFormatterFactory getCelularMask() {
        MaskFormatter mask = null;

        try {
            mask = new MaskFormatter("(##) #####-####");
            mask.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            throw new RuntimeException("Erro na formatação do Telefone Celular.");
        }

        return new DefaultFormatterFactory(mask);
    }

    public static DefaultFormatterFactory getValorMask() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        df.setRoundingMode(RoundingMode.HALF_UP);

        NumberFormatter nf = new NumberFormatter(df);
        nf.setAllowsInvalid(false);
        nf.setMinimum(0.00);
        nf.setMaximum(999999999.99);

        return new DefaultFormatterFactory(nf);
    }
}
