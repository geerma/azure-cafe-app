"use client"

import Image from "next/image";
import React, { useState } from "react";

import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "../../_components/Dialog";

const DrinkCard: React.FC<{ drink: Drink }> = ({ drink }) => {
  const [sizePrice, setSizePrice] = useState<number>(0);
  const [addonsPrice, setAddonsPrice] = useState<number>(0);
  const [totalDrinkPrice, setTotalDrinkPrice] = useState<number>(drink.productCost);

  const handleSize = (value: number) => {
    setSizePrice(value);
    calculateTotalDrinkPrice(value, addonsPrice);
  }

  const handleDrinkAddons = (e: React.ChangeEvent<HTMLInputElement>, value: number) => {
    const checkedBoolean = e.target.checked;
    var addonPriceTemp = addonsPrice;
    if (checkedBoolean) {
      addonPriceTemp = addonPriceTemp + value;
    } else {
      addonPriceTemp = addonPriceTemp - value;
    }
    setAddonsPrice(addonPriceTemp);
    calculateTotalDrinkPrice(sizePrice, addonPriceTemp);
  }

  const calculateTotalDrinkPrice = (sizePrice: number, addonsPrice: number) => {
    const totalDrinkPrice = drink.productCost + sizePrice + addonsPrice;
    setTotalDrinkPrice(totalDrinkPrice)
  }

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
                  <input type="radio" name="drinkSize" onChange={(e) => handleSize(value)} />
                  <label className="p-2">
                    {key}: ${String(drink.productCost + value)}
                  </label>
                </div>
              ))}
            </fieldset>
            <fieldset className="flex flex-row gap-2 mt-2">
              <legend>Sweetness Options</legend>
              {drink.drinkSweetnessOptions.map((sweetnessOption: number) => (
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
                    <input type="checkbox" name="drinkAddons" value={value} onChange={(e) => handleDrinkAddons(e, value)} />
                    <label className="p-2">
                      {key}: ${String(value)}.00
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
              <p className="text-center">Size: ${sizePrice}.00</p>
              <p className="text-center">Add-ons: ${addonsPrice}.00</p>
              <p className="font-bold text-center">Total: ${totalDrinkPrice}.00</p>
              <button className="border-2 w-fit mx-auto px-8">Add to Cart</button>
            </div>
          </div>
        </DialogContent>
      </Dialog>
    </div>
  );
};

export default DrinkCard;
