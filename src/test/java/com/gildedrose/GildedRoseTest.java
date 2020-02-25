package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


  /// RANDOM
  @ParameterizedTest
  @ValueSource(ints = {1, 3, 0, -3})
  // six numbers
  void randomItemsSellinShouldAlwaysDecreaseByOne(int sellin) {
    Item[] items = new Item[]{new Item("Random", sellin, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(sellin - 1, app.items[0].sellIn);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 0, -3})
    // six numbers
  void randomItemsQualityShouldAlwaysDecreaseByOne(int sellin) {
    Item[] items = new Item[]{new Item("Random", sellin, 1)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(0, app.items[0].quality);
  }


  //// SULFURAS
  @ParameterizedTest
  @ValueSource(ints = {1, 3})
    // six numbers
  void sulfurasItemsSellinShouldNeverDecrease(int sellin) {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", sellin, 80)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(sellin, app.items[0].sellIn);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 0, -3})
    // six numbers
  void sulfurasItemsQualityShouldNeverDecrease(int sellin) {
    Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", sellin, 80)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(80, app.items[0].quality);
  }


  ///AGED BRIE
  @ParameterizedTest
  @ValueSource(ints = {1, 3, 0, -3})
  // six numbers
  void agedBrieItemsSellinShouldAlwaysDecreaseByOne(int sellin) {
    Item[] items = new Item[]{new Item("Aged Brie", sellin, 0)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(sellin - 1, app.items[0].sellIn);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 3})
    // six numbers
  void agedBrieItemsQualityShouldIncreaseByOneWhenSellInGreaterThan0(int sellin) {
    Item[] items = new Item[]{new Item("Aged Brie", sellin, 1)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(2, app.items[0].quality);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -3})
    // six numbers
  void agedBrieItemsQualityShouldIncreaseByTwoWhenSellInIsLessThan0(int sellin) {
    Item[] items = new Item[]{new Item("Aged Brie", sellin, 1)};
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(3, app.items[0].quality);
  }

    @Test
    void agedBrieItemsQualityIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }



    //// BACKSTAGE PASSES
    @Test
    void backstagePassesItemsQualityIsNeverMoreThan50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 2, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void backstagePassesQualityIncreasesAsSellinApproaches() {
        Item[] items = new Item[]{new Item("Back")}
    }
}
