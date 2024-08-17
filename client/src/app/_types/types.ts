type Drink = {
  productId: number;
  productName: String;
  productDescription: String;
  productCategory: String;
  productCost: number;
  productImageURL: String | null;
  drinkSizeOptions: {
    Small: number;
    Medium: number;
    Large: number;
  };
  drinkSweetnessOptions: number[];
  drinkTemperatureOptions: String[];
  drinkAddonsOptions: {
    Sago: number;
    "Grass Jelly": number;
    Pearls: number;
    "Crystal Pearls": number;
  };
};

export type HoverComponentProps = {
  title: string;
  description: string;
  imageURL: string;
};

export type BaseComponentProps = {
  title: string;
  imageURL: string;
};

