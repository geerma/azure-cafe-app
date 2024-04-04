import Image from "next/image";
import Link from "next/link";

export default function Home() {
  const BASE_CDN_URL:String = process.env.BASE_CDN_URL || "http://localhost:3000";

  return (
    <main>
      <div className="flex flex-col min-h-screen min-w-max items-center justify-between py-96 text-yellow bg-cafeHomepage bg-cover">
        <div className="flex flex-col items-center gap-4">
          <h1 className="text-4xl">Gosohada</h1>
          <p className="text-3xl">고소하다</p>
        </div>
        <nav>
          <ul className="flex flex-row max-sm:flex-col divide-x-2 max-sm:divide-x-0 max-sm:py-12 divide-solid text-3xl">
            <li className="px-12">
              <Link href="/">Home</Link>
            </li>
            <li className="px-12">
              <Link href="/catalog#menu" scroll={false}>Menu</Link>
            </li>
            <li className="px-12">
              <Link href="/catalog#flowers" scroll={false}>Flowers</Link>
            </li>
            <li className="px-12">
              <Link href="/order">Online Order</Link>
            </li>
            <li className="px-12">
              <Link href="/reservations">Reservations</Link>
            </li>
            <li className="px-12">
              <Link href="/about">About / Contact Us</Link>
            </li>
          </ul>
        </nav>
      </div>
      <div id="about" className="flex flex-col items-center w-fit">
        {/* First */}
        <div className="flex flex-row min-w-full min-h-[600px] bg-beigePrimary">
          <div className="relative h-[600px] w-[800px]">
            <Image
              src={`${BASE_CDN_URL}/homepage_drink.jpg`}
              alt="drink_image"
              fill={true}
            />
          </div>
          <div className="flex flex-col relative h-[600px] w-[60vw] text-center">
            <h1 className="text-4xl my-24 text-gray">Drinks</h1>
            <p className="text-2xl text-gold px-36">Refreshing drinks after a long day.</p>
          </div>
        </div>
        {/* Second */}
        <div className="flex flex-row min-w-full min-h-[600px] bg-beigePrimary">
          <div className="relative h-[600px] w-[60vw] text-center">
            <h1 className="text-4xl my-24 text-gray">Food</h1>
            <p className="text-2xl text-gold px-36">Tasty desserts such as cakes, croffles, and macarons.</p>
          </div>
          <div className="relative h-[600px] w-[800px]">
            <Image
              src={`${BASE_CDN_URL}/homepage_food.jpg`}
              alt="food_image"
              fill={true}
            />
          </div>
        </div>
        {/* Third */}
        <div className="flex flex-row min-w-full min-h-[600px] bg-beigePrimary">
          <div className="relative h-[600px] w-[800px]">
            <Image
              src={`${BASE_CDN_URL}/homepage_flower_2.jpg`}
              alt="flower_image"
              fill={true}
            />
          </div>
          <div className="relative h-[600px] w-[60vw] text-center">
            <h1 className="text-4xl my-24 text-gray">Flowers</h1>
            <p className="text-2xl text-gold px-36">Carefully arranged flowers for any special occassion.</p>
          </div>
        </div>
        {/* Fourth */}
        <div className="flex flex-row min-w-full min-h-[600px] bg-beigePrimary">
          <div className="relative h-[600px] w-[60vw] text-center">
          <h1 className="text-4xl my-24 text-gray">Table Reservations</h1>
            <p className="text-2xl text-gold px-36">A perfect space for many activities, whether it be quiet studying or to catch up with friends.</p>
          </div>
          <div className="relative h-[600px] w-[800px]">
            <Image
              src={`${BASE_CDN_URL}/homepage_table_1.jpg`}
              alt="table_image"
              fill={true}
            />
          </div>
        </div>
        {/* Fifth */}
        <div className="flex flex-row min-w-full min-h-[600px] bg-beigePrimary">
          <div className="relative h-[600px] w-[800px]">
            <Image
              src={`${BASE_CDN_URL}/homepage_background.jpg`}
              alt="order_image"
              fill={true}
            />
          </div>
          <div className="relative h-[600px] w-[60vw] text-center">
            <h1 className="text-4xl my-24 text-gray">Online Ordering</h1>
            <p className="text-2xl text-gold px-36">Conveniently order your desserts, drinks, and flowers on the go. We will make sure that they are ready for pickup when you arrive.</p>
          </div>
        </div>
      </div>
    </main>
  );
}