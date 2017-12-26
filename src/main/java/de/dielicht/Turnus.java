package de.dielicht;

public enum Turnus
{
    monthly
    {
        @Override
        public int calculate(int betrag)
        {
            // TODO Auto-generated method stub
            return 0;
        }
    },
    quarterly
    {
        @Override
        public int calculate(int betrag)
        {
            // TODO Auto-generated method stub
            return 0;
        }
    },
    halfYearly
    {
        @Override
        public int calculate(int betrag)
        {
            // TODO Auto-generated method stub
            return 0;
        }
    },
    annual
    {
        @Override
        public int calculate(int betrag)
        {
            // TODO Auto-generated method stub
            return 0;
        }
    };

    abstract public int calculate(int betrag);
}
