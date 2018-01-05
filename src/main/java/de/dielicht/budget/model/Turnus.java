package de.dielicht.budget.model;

public enum Turnus
{
    monthly
    {
        @Override
        public int getTurnusMonths()
        {
            return 1;
        }
    },
    quarterly
    {
        @Override
        public int getTurnusMonths()
        {
            return 3;
        }
    },
    halfYearly
    {
        @Override
        public int getTurnusMonths()
        {
            return 6;
        }
    },
    annual
    {
        @Override
        public int getTurnusMonths()
        {
            return 12;
        }
    };

    abstract public int getTurnusMonths();
}
