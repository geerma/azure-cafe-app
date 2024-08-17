"use client";
import Image from "next/image";
import Navigation from "../_components/Navigation";

export default function Catalog() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between">
      <Navigation />
      <div>
        <div className="min-h-[25vh] bg-lightGray text-center font-notosanskr">
          <h1 className="pt-16 pb-8 text-4xl text-gray">Menu & Merchandise</h1>
          <p className="p-2">
            Choose from a wide variety of food and drink items
          </p>
          <p className="p-2">
            Browse our collection of merchandise that are perfect for gifts or
            personal enjoyment
          </p>
        </div>
        <div
          id="#menu"
          className="min-h-[100vh] w-screen bg-beigePrimary text-center flex flex-row"
        >
          <Image
            src={"/catalog_foods.png"}
            alt="foods catalog"
            width={500}
            height={750}
            className="m-auto"
          />
          <Image
            src={"/catalog_drinks.png"}
            alt="drinks catalog"
            width={500}
            height={750}
            className="m-auto"
          />
        </div>
        <div
          id="#flowers"
          className="min-h-[90vh] w-screen bg-beigePrimary text-center"
        >
          <Image
            src={"/catalog_flowers.png"}
            alt="flowers catalog"
            width={500}
            height={750}
            className="m-auto"
          />
        </div>
      </div>
    </main>
  );
}
