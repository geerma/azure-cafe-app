import Navigation from "../_components/Navigation";
import DrinkCard from "./components/DrinkCard";

export default async function Order() {
  const productData = await getProductData();
  const drinks: Drink[] = productData.filter((product: { productCategory: string; }) => product.productCategory === 'Drink');

  return (
    <main className="flex min-h-screen min-w-fit flex-col items-center justify-between p-24 mx-0.5 border-2 border-black bg-beigePrimary">
      <Navigation />
      {/* Drinks */}
      <div>
        <div className="flex flex-row gap-12">
          {drinks?.map((drink: Drink) => (
            <DrinkCard key={drink.productId.toString()} drink={drink} />
          ))}
        </div>
      </div>
    </main>
  );
}

async function getProductData() {
  const BASE_API_URL = process.env.BASE_API_URL;

  const res = await fetch(BASE_API_URL + `/api/v1/products/`, {
    method: "get",
    headers: {
      "Content-Type": "application/json",
    },
  });

  if (!res.ok) {
    throw new Error("Failed to fetch product data");
  }

  return res.json();
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
    throw new Error("Failed to login user");
  }

  return res.json();
}
