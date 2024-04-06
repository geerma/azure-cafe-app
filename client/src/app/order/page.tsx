import Image from "next/image";
import ProductCard from "./components/ProductCard";

interface Drink {
  productId: Number,
  productName: String,
  productDescription: String,
  productCategory: String,
  productCost: Number,
  productImageURL: String | null,
  drinkSizeOptions: {
    S: Number,
    L: Number,
    M: Number,
  },
  drinkSweetnessOptions: Number[],
  drinkTemperatureOptions: String[],
  drinkAddonsOptions: {
    Sago: Number,
    "Grass Jelly": Number,
    Pearls: Number,
  },
}

export default async function Order() {
  const drinks: Drink[] = [
    {
      productId: 1,
      productName: "Matcha Milk Tea",
      productDescription: "Delicious matcha milk tea",
      productCategory: "Drink",
      productCost: 5.0,
      productImageURL: null,
      drinkSizeOptions: {
        S: 0.0,
        L: 2.0,
        M: 1.0,
      },
      drinkSweetnessOptions: [0, 50, 70, 100],
      drinkTemperatureOptions: ["Cold", "Hot"],
      drinkAddonsOptions: {
        Sago: 1.0,
        "Grass Jelly": 2.0,
        Pearls: 1.5,
      },
    },
    {
      productId: 2,
      productName: "Peach Fruit Tea",
      productDescription: "Refreshing peach-flavoured fruit tea",
      productCategory: "Drink",
      productCost: 5.0,
      productImageURL: null,
      drinkSizeOptions: {
        S: 0.0,
        L: 2.0,
        M: 1.0,
      },
      drinkSweetnessOptions: [0, 50, 70, 100],
      drinkTemperatureOptions: ["Cold", "Hot"],
      drinkAddonsOptions: {
        Sago: 1.0,
        "Grass Jelly": 2.0,
        Pearls: 1.5,
      },
    },
  ];

  console.log(drinks);

  return (
    <main className="flex min-h-screen min-w-fit flex-col items-center justify-between p-24 mx-0.5 border-2 border-black bg-beigePrimary">
      {/* Drinks */}
      <div>
        <div className="flex flex-row gap-12">
          {drinks?.map((drink: Drink) => (
            <ProductCard key={drink.productId.toString()} drink={drink} />
          ))}
        </div>
      </div>
    </main>
  );
}

async function getDrinkData() {
  return;
}

async function getFoodData() {
  return;
}

async function loginUser(username: String, password: String) {
  const BASE_API_URL = process.env.BASE_API_URL;

  const res = await fetch(BASE_API_URL + `/api/v1/auth/login/`, {
    method: "post",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      username: username,
      password: password,
    }),
  });

  console.log(res);

  if (!res.ok) {
    throw new Error("Failed to fetch data");
  }

  return res.json();
}
