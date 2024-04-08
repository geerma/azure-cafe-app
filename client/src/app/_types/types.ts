type Drink = {
    productId: number;
    productName: String;
    productDescription: String;
    productCategory: String;
    productCost: number;
    productImageURL: String | null;
    drinkSizeOptions: {
        S: number;
        L: number;
        M: number;
    };
    drinkSweetnessOptions: number[];
    drinkTemperatureOptions: String[];
    drinkAddonsOptions: {
        Sago: number;
        "Grass Jelly": number;
        Pearls: number;
    };
}