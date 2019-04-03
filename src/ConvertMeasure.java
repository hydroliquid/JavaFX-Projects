/* Exam 2 -
 * Michael Benton
 * Chemen Wong
 * Rodolfo Punzalan
 */

import javafx.scene.control.ComboBox;

public class ConvertMeasure
{
    static private double convertedMeasurement = 0.0;
    static private double endAmount = 0.0;

    public static Double Convert(double unconvertedMeasurement, ComboBox comboBox1, ComboBox comboBox2)
    {
        if (comboBox1.getValue() == "Teaspoons") {
            convertedMeasurement = fromTeaspoons(unconvertedMeasurement, comboBox1, comboBox2);
        } else if (comboBox1.getValue() == "Tablespoons") {
            convertedMeasurement = fromTablespoons(unconvertedMeasurement, comboBox1, comboBox2);
        } else if (comboBox1.getValue() == "Ounces") {
            convertedMeasurement = fromOunces(unconvertedMeasurement, comboBox1, comboBox2);
        } else if (comboBox1.getValue() == "Cups") {
            convertedMeasurement = fromCups(unconvertedMeasurement, comboBox1, comboBox2);
        } else if (comboBox1.getValue() == "Pints") {
            convertedMeasurement = fromPints(unconvertedMeasurement, comboBox1, comboBox2);
        } else if (comboBox1.getValue() == "Quarts") {
            convertedMeasurement = fromQuarts(unconvertedMeasurement, comboBox1, comboBox2);
        } else if (comboBox1.getValue() == "Gallons") {
            convertedMeasurement = fromGallons(unconvertedMeasurement, comboBox1, comboBox2);
        }

        return convertedMeasurement;
    }

    public static Double fromTeaspoons(double amount, ComboBox from, ComboBox to)
    {

        if (from.getValue() == "Teaspoons")
        {
            if (to.getValue() == "Tablespoons")
            {
                endAmount = amount / 3.0;
                return endAmount;
            }
            else if (to.getValue() == "Ounces")
            {
                endAmount = amount / 6.0;

                return endAmount;
            }
            else if (to.getValue() == "Cups")
            {
                endAmount = amount / 48.0;

                return endAmount;
            }
            else if (to.getValue() == "Pints")
            {
                endAmount = amount / 96.0;

                return endAmount;
            }
            else if (to.getValue() == "Quarts")
            {
                endAmount = amount / 192.0;

                return endAmount;
            }
            else if (to.getValue() == "Gallons")
            {
                endAmount = amount / 768.0;

                return endAmount;
            }
        }
        return amount;
    }

    public static Double fromTablespoons(double amount, ComboBox from, ComboBox to)
    {

        if (from.getValue() == "Tablespoons")
        {
            if (to.getValue() == "Teaspoons")
            {
                endAmount = amount * 3.0;

                return endAmount;
            }
            else if (to.getValue() == "Ounces")
            {
                endAmount = amount / 2.0;

                return endAmount;
            }
            else if (to.getValue() == "Cups")
            {
                endAmount = amount / 16.0;

                return endAmount;
            }
            else if (to.getValue() == "Pints")
            {
                endAmount = amount / 32.0;

                return endAmount;
            }
            else if (to.getValue() == "Quarts")
            {
                endAmount = amount / 64.0;

                return endAmount;
            }
            else if (to.getValue() == "Gallons")
            {
                endAmount = amount / 256.0;

                return endAmount;
            }
        }
        return amount;
    }

    public static Double fromOunces(double amount, ComboBox from, ComboBox to)
    {

        if (from.getValue() == "Ounces")
        {
            if (to.getValue() == "Teaspoons")
            {
                endAmount = amount * 6.0;

                return endAmount;
            }
            else if (to.getValue() == "Tablespoons")
            {
                endAmount = amount * 2.0;

                return endAmount;
            }
            else if (to.getValue() == "Cups")
            {
                endAmount = amount / 8.0;

                return endAmount;
            }
            else if (to.getValue() == "Pints")
            {
                endAmount = amount / 16.0;

                return endAmount;
            }
            else if (to.getValue() == "Quarts")
            {
                endAmount = amount / 32.0;

                return endAmount;
            }
            else if (to.getValue() == "Gallons")
            {
                endAmount = amount / 128.0;

                return endAmount;
            }
        }
        return amount;
    }

    public static Double fromCups(double amount, ComboBox from, ComboBox to)
    {
        if (from.getValue() == "Cups") {
            if (to.getValue() == "Teaspoons") {
                endAmount = amount * 48.0;

                return endAmount;
            } else if (to.getValue() == "Tablespoons") {
                endAmount = amount * 16.0;

                return endAmount;
            } else if (to.getValue() == "Ounces") {
                endAmount = amount * 8.0;

                return endAmount;
            } else if (to.getValue() == "Pints") {
                endAmount = amount / 2.0;

                return endAmount;
            } else if (to.getValue() == "Quarts") {
                endAmount = amount / 4.0;

                return endAmount;
            } else if (to.getValue() == "Gallons") {
                endAmount = amount / 16.0;

                return endAmount;
            }
        }
        return amount;

    }

    public static Double fromPints(double amount, ComboBox from, ComboBox to)
    {
        if (from.getValue() == "Pints")
        {
            if (to.getValue() == "Teaspoons") {
                endAmount = amount * 96.0;

                return endAmount;
            } else if (to.getValue() == "Tablespoons") {
                endAmount = amount * 32.0;

                return endAmount;
            } else if (to.getValue() == "Ounces") {
                endAmount = amount * 16.0;

                return endAmount;
            } else if (to.getValue() == "Cups") {
                endAmount = amount * 2.0;

                return endAmount;
            } else if (to.getValue() == "Quarts") {
                endAmount = amount / 2.0;

                return endAmount;
            } else if (to.getValue() == "Gallons") {
                endAmount = amount / 8.0;

                return endAmount;
            }
        }
        return amount;

    }

    public static Double fromQuarts(double amount, ComboBox from, ComboBox to)
    {
        if (from.getValue() == "Quarts") {
            if (to.getValue() == "Teaspoons") {
                endAmount = amount * 192.0;

                return endAmount;
            } else if (to.getValue() == "Tablespoons") {
                endAmount = amount * 64.0;

                return endAmount;
            } else if (to.getValue() == "Ounces") {
                endAmount = amount * 32.0;

                return endAmount;
            } else if (to.getValue() == "Cups") {
                endAmount = amount * 4.0;

                return endAmount;
            } else if (to.getValue() == "Pints") {
                endAmount = amount * 2.0;

                return endAmount;
            } else if (to.getValue() == "Gallons") {
                endAmount = amount / 4.0;

                return endAmount;
            }
        }
        return amount;
    }

    public static Double fromGallons(double amount, ComboBox from, ComboBox to)
    {
        if (from.getValue() == "Gallons") {
            if (to.getValue() == "Teaspoons") {
                endAmount = amount * 768.0;

                return endAmount;
            } else if (to.getValue() == "Tablespoons") {
                endAmount = amount * 256.0;

                return endAmount;
            } else if (to.getValue() == "Ounces") {
                endAmount = amount * 128.0;

                return endAmount;
            } else if (to.getValue() == "Cups") {
                endAmount = amount * 16.0;

                return endAmount;
            } else if (to.getValue() == "Pints") {
                endAmount = amount * 8.0;

                return endAmount;
            } else if (to.getValue() == "Quarts") {
                endAmount = amount * 4.0;

                return endAmount;
            }
        }
        return amount;
    }
}


