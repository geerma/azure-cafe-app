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
          <div className="font-notosanskr font-normal">
            <Image
              src={"/order_bubble_tea.jpg"}
              alt="drink image"
              width={150}
              height={150}
            />
            <h1 className="text-lg font-semibold">{drink.productName}</h1>
            <p>{drink.productDescription}</p>
            <fieldset className="flex flex-row gap-2 mt-2">
              <legend>Size Options</legend>
              {Object.entries(drink.drinkSizeOptions).map(([key, value]) => (
                <div key={key}>
                  <input type="radio" />
                  <label className="p-2">
                    {key}: ${String(drink.productCost + value)}
                  </label>
                </div>
              ))}
            </fieldset>
            <fieldset className="flex flex-row gap-2 mt-2">
              <legend>Sweetness Options</legend>
              {drink.drinkSweetnessOptions.map((sweetnessOption: Number) => (
                <div key={String(sweetnessOption)}>
                  <input
                    type="radio"
                    name="drinkSweetness"
                    value={String(sweetnessOption)}
                  />
                  <label className="p-2">{String(sweetnessOption)}%</label>
                </div>
              ))}
            </fieldset>
            <fieldset className="flex flex-col mt-2">
              <legend>Add-on Options (Additional Costs)</legend>
              {Object.entries(drink.drinkAddonsOptions).map(
                ([key, value]) => (
                  <div key={key}>
                    <input type="checkbox" />
                    <label className="p-2">
                      {key}: {String(value)}
                    </label>
                  </div>
                )
              )}
            </fieldset>
            <fieldset className="flex flex-col mt-2">
              <legend>Add-on Options</legend>
              {drink.drinkTemperatureOptions.map((temperatureOption: String) => (
                <div key={String(temperatureOption)}>
                  <input
                    type="radio"
                    name="drinkTemperature"
                    value={String(temperatureOption)}
                  />
                  <label className="p-2">{temperatureOption}</label>
                </div>
              ))}
            </fieldset>
            <div className="flex flex-col">
              <button className="items-center ">Add to Cart</button>
            </div>
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
};

export default ProductCard;
