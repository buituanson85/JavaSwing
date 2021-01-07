package Bai9;

import java.util.Comparator;

public class PhoneBookSortPhone
        implements Comparator<PhoneBook> {
    @Override
    public int compare(PhoneBook o1,
                       PhoneBook o2) {
        return o1.getPhone()
                .compareTo(o2.getPhone());
    }
}
