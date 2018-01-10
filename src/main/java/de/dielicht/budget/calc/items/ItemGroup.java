package de.dielicht.budget.calc.items;

import java.util.List;

public class ItemGroup
{
    private final BaseItem header;
    private final List<BaseItem> items;
    private final BaseItem footer;

    public ItemGroup(final BaseItem header, final List<BaseItem> items, final BaseItem footer)
    {
        super();
        this.header = header;
        this.items = items;
        this.footer = footer;
    }

    public BaseItem getHeader()
    {
        return this.header;
    }

    public List<BaseItem> getItems()
    {
        return this.items;
    }

    public BaseItem getFooter()
    {
        return this.footer;
    }
}
