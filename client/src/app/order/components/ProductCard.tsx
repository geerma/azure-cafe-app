import Image from "next/image";
import Link from "next/link";
import React from "react";

const ProductCard = ({ drink }: any) => {
  return (
    <div key={drink.productId} className="w-[230px] h-fit p-4 font-notosanskr hover:shadow-xl">
      <Link href={`products/` + drink.productId}>
        <Image
          src={"/order_bubble_tea.jpg"}
          alt="drink image"
          width={230}
          height={230}
        />
        <p className="text-lg">{drink.productName}</p>
        <p className="text-lg truncate">{drink.productDescription}</p>
        <p className="text-lg">${drink.productCost}.00</p>
      </Link>
    </div>
  );
};

export default ProductCard;
