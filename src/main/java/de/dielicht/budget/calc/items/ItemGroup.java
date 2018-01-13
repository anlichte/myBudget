package de.dielicht.budget.calc.items;

import java.util.List;

import com.google.common.base.MoreObjects;

public class ItemGroup<T>
{
    private final BaseItem header;
    private final List<T> items;
    private final BaseItem footer;

    public ItemGroup(final BaseItem header, final List<T> items, final BaseItem footer)
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

    public List<T> getItems()
    {
        return this.items;
    }

    public BaseItem getFooter()
    {
        return this.footer;
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this)
            .add("\nheader", this.getHeader())
            .add("\npayments", this.getItems())
            .add("\nfooter", this.getFooter())
            .toString();
    }
}
