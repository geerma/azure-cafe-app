"use client";
import Image from "next/image";
import Link from "next/link";
import Expandable from "./_components/Expandable";
import HoverComponent from "./_components/HoverComponent";
import BaseComponent from "./_components/BaseComponent";

export default function Home() {
  const BASE_CDN_URL: String =
    process.env.BASE_CDN_URL ||
    "https://azure-cafe-app-cdn.azureedge.net/azure-cafe-app-images";

  return (
    <main>
      <div className="flex flex-col h-[98.2vh] min-w-max items-center justify-between py-96 text-yellow">
        <Image
          className="object-cover -z-10"
          src={`${BASE_CDN_URL}/homepage_background.jpg`}
          alt="Homepage background"
          fill={true}
        />
        <div className="flex flex-col items-center gap-4">
          <h1 className="text-4xl">Azure Cafe</h1>
        </div>
        <nav>
          <ul className="flex flex-row max-sm:flex-col divide-x-2 max-sm:divide-x-0 max-sm:py-12 divide-solid text-3xl">
            <li className="px-12 hover:shadow-2xl">
              <Link href="/">Home</Link>
            </li>
            <li className="px-12 hover:shadow-2xl">
              <Link href="/catalog#menu" scroll={false}>
                Menu
              </Link>
            </li>
            <li className="px-12 hover:shadow-2xl">
              <Link href="/catalog#flowers" scroll={false}>
                Flowers
              </Link>
            </li>
            <li className="px-12 hover:shadow-2xl">
              <Link href="/order">Online Order</Link>
            </li>
            <li className="px-12 hover:shadow-2xl">
              <Link href="/reservations">Reservations</Link>
            </li>
            <li className="px-12 hover:shadow-2xl">
              <Link href="/about">About / Contact Us</Link>
            </li>
          </ul>
        </nav>
      </div>

      <div id="about" className="flex flex-col items-center h-[100-vh]">
        {/* First */}
        <Expandable
          HoverComponent={
            <HoverComponent
              title="Drinks"
              description="Refreshing drinks after a long day"
              imageURL={`${BASE_CDN_URL}/homepage_drink.jpg`}
            />
          }
          BaseComponent={
            <BaseComponent
              title="Drinks"
              imageURL={`${BASE_CDN_URL}/homepage_drink.jpg`}
            />
          }
        />
        {/* Second */}
        <Expandable
          HoverComponent={
            <HoverComponent
              title="Food"
              description="Tasty desserts such as cakes, croffles, and macarons"
              imageURL={`${BASE_CDN_URL}/homepage_food.jpg`}
            />
          }
          BaseComponent={
            <BaseComponent
              title="Food"
              imageURL={`${BASE_CDN_URL}/homepage_food.jpg`}
            />
          }
        />
        {/* Third */}
        <Expandable
          HoverComponent={
            <HoverComponent
              title="Flowers"
              description="Carefully arranged flowers for any special occassion"
              imageURL={`${BASE_CDN_URL}/homepage_flower_2.jpg`}
            />
          }
          BaseComponent={
            <BaseComponent
              title="Flowers"
              imageURL={`${BASE_CDN_URL}/homepage_flower_2.jpg`}
            />
          }
        />
        {/* Fourth */}
        <Expandable
          HoverComponent={
            <HoverComponent
              title="Table Reservations"
              description="A perfect space for many activities, whether it be quiet studying
              or to catch up with friends"
              imageURL={`${BASE_CDN_URL}/homepage_table_1.jpg`}
            />
          }
          BaseComponent={
            <BaseComponent
              title="Table Reservations"
              imageURL={`${BASE_CDN_URL}/homepage_table_1.jpg`}
            />
          }
        />
        {/* Fifth */}
        <Expandable
          HoverComponent={
            <HoverComponent
              title="Online Ordering"
              description="Conveniently order your desserts, drinks, and flowers for delivery or pickup"
              imageURL={`${BASE_CDN_URL}/homepage_background.jpg`}
            />
          }
          BaseComponent={
            <BaseComponent
              title="Online Ordering"
              imageURL={`${BASE_CDN_URL}/homepage_background.jpg`}
            />
          }
        />
      </div>
    </main>
  );
}
