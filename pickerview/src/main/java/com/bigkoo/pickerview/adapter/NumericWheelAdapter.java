package com.bigkoo.pickerview.adapter;


import com.bigkoo.pickerview.utils.EnglishDate;
import com.contrarywind.adapter.WheelAdapter;

/**
 * Numeric Wheel adapter.
 */
public class NumericWheelAdapter implements WheelAdapter {

    private int minValue;
    private int maxValue;
    private boolean isEnglish;

    public NumericWheelAdapter(int minValue, int maxValue) {
        this(minValue, maxValue, false);
    }

    /**
     * Constructor
     *
     * @param minValue the wheel min value
     * @param maxValue the wheel max value
     */
    public NumericWheelAdapter(int minValue, int maxValue, boolean isEnglish) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.isEnglish = isEnglish;
    }

    @Override
    public Object getItem(int index) {
        if (index >= 0 && index < getItemsCount()) {
            int value = minValue + index;
            return isEnglish ? EnglishDate.getEnglishMonth(value) : value;
        }
        return 0;
    }

    @Override
    public int getItemsCount() {
        return maxValue - minValue + 1;
    }

    @Override
    public int indexOf(Object o) {
        try {
            return (int) o - minValue;
        } catch (Exception e) {
            return -1;
        }

    }
}
