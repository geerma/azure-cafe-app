import Image from "next/image";
import React from "react";

import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "./Dialog";

interface Drink {
  productId: Number;
  productName: String;
  productDescription: String;
  productCategory: String;
  productCost: Number;
  productImageURL: String | null;
  drinkSizeOptions: {
    S: Number;
    L: Number;
    M: Number;
  };
  drinkSweetnessOptions: Number[];
  drinkTemperatureOptions: String[];
  drinkAddonsOptions: {
    Sago: Number;
    "Grass Jelly": Number;
    Pearls: Number;
  };
}

const ProductCard = ({ drink }: any) => {
  return (
    <div key={drink.productId.toString()}>
      <Dialog>
        <DialogTrigger className="w-[230px] h-fit p-4 font-notosanskr hover:shadow-xl">
          <Image
            src={"/order_bubble_tea.jpg"}
            alt="drink image"
            width={230}
            height={230}
          />
          <p className="text-lg">{drink.productName}</p>
          <p className="text-lg truncate">{drink.productDescription}</p>
          <p className="text-lg">${String(drink.productCost)}.00</p>
        </DialogTrigger>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>{drink.productName}</DialogTitle>
            <DialogDescription>
              <Image
                src={"/order_bubble_tea.jpg"}
                alt="drink image"
                width={230}
                height={230}
              />
              <span>{drink.productDescription}</span>
              <br></br>
              <span>${String(drink.productCost)}.00</span>
            </DialogDescription>
            <DialogDescription>
              <>
                <h1>Size Options</h1>
                {Object.entries(drink.drinkSizeOptions).map(([key, value]) => (
                  <div key={key}>
                    <input type="radio" />
                    <label>
                      {key}: {String(value)}
                    </label>
                  </div>
                ))}
              </>
            </DialogDescription>
            <DialogDescription>
              <fieldset>
                <legend>Sweetness Options</legend>
                {drink.drinkSweetnessOptions.map((sweetnessOption: Number) => (
                  <div key={String(sweetnessOption)}>
                    <input
                      type="radio"
                      name="drinkSweetness"
                      value={String(sweetnessOption)}
                    />
                    <label>{String(sweetnessOption)}</label>
                  </div>
                ))}
              </fieldset>
            </DialogDescription>
            <DialogDescription>
              <>
                <h1>Drink Add-on Options</h1>
                {Object.entries(drink.drinkAddonsOptions).map(
                  ([key, value]) => (
                    <div key={key}>
                      <input type="radio" />
                      <label>
                        {key}: {String(value)}
                      </label>
                    </div>
                  )
                )}
              </>
            </DialogDescription>
            <DialogDescription>
              <h1>Temperature Options</h1>
            </DialogDescription>
            <button>Add to Cart</button>
          </DialogHeader>
        </DialogContent>
      </Dialog>
    </div>
  );
};

export default ProductCard;
