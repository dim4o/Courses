using System;

namespace _05_EgyptianFractions
{
    class EgyptianFractions
    {
        static void Main()
        {
            string input = Console.ReadLine();
            var fractionParams = input.Split('/');
            var numerator = int.Parse(fractionParams[0]);
            var denominator = int.Parse(fractionParams[1]);

            if (numerator >= denominator)
            {
                Console.WriteLine("Error (fraction is equal to or greater than 1)");
                return;
            }

            Fraction number = new Fraction(numerator, denominator);
            string result = input + " = ";

            while (number.Numerator > 0)
            {
                int smallerDenominator = 2;

                while (number.CompareTo(new Fraction(1, smallerDenominator)) < 0)
                {
                    smallerDenominator++;
                }
                var biggestFraction = new Fraction(1, smallerDenominator);
                result += biggestFraction + " + ";

                if (number.CompareTo(biggestFraction) == 0)
                {
                    break;
                }
                number = number - biggestFraction;
            }

            Console.WriteLine(result.Substring(0, result.Length - 3));
        }
    }

    internal class Fraction : IComparable<Fraction>
    {
        public int Numerator { get; private set; }
        private int Denominator { get; set; }

        public Fraction(int numerator, int denominator)
        {
            this.Numerator = numerator;
            this.Denominator = denominator;
        }

        public int CompareTo(Fraction other)
        {
            return (this.Numerator*other.Denominator)
                .CompareTo(other.Numerator*this.Denominator);
        }

        public static Fraction operator -(Fraction first, Fraction second)
        {
            int nominator = first.Numerator * second.Denominator - second.Numerator * first.Denominator;
            int denominator = first.Denominator*second.Denominator;
            return new Fraction(nominator, denominator);
        }

        public override string ToString()
        {
            return String.Format("{0}/{1}", this.Numerator, this.Denominator);
        }
    }
}
