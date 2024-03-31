import Image from "next/image";
import Link from "next/link";

export default function Home() {
  return (
    <main>
      <div className="flex flex-col min-h-screen items-center justify-between py-96 text-yellow bg-cafeHomepage bg-contain">
        <div className="flex flex-col items-center gap-4">
          <h1 className="text-4xl">Gosohada</h1>
          <p className="text-3xl">고소하다</p>
        </div>
        <nav>
          <ul className="flex flex-row divide-x-2 divide-solid text-3xl">
            <li className="px-12">
              <Link href="/">Home</Link>
            </li>
            <li className="px-12">
              <Link href="/catalog#menu">Menu</Link>
            </li>
            <li className="px-12">
              <Link href="/catalog#flowers">Flowers</Link>
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
      <div id="about" className="flex flex-col items-center">
        {/* First */}
        <div className="flex flex-row min-w-full min-h-[600px]">
          <div className="relative h-[600px] w-[800px]">
            <Image
              src="/homepage_background.jpg"
              alt="drink_image"
              fill={true}
            />
          </div>
          <div className="relative h-[600px] w-[1315px] text-center">
            <h1 className="text-3xl">Drinks</h1>
            <p className="text-2xl">Refreshing drinks after a long day.</p>
          </div>
        </div>
        {/* Second */}
        <div className="flex flex-row min-w-full min-h-[600px]">
          <div className="relative h-[600px] w-[1315px] text-center">
            <h1 className="text-3xl">Food</h1>
            <p className="text-2xl">Tasty desserts such as cakes, croffles, and macarons.</p>
          </div>
          <div className="relative h-[600px] w-[800px]">
            <Image
              src="/homepage_background.jpg"
              alt="food_image"
              fill={true}
            />
          </div>
        </div>
        {/* Third */}
        <div className="flex flex-row min-w-full min-h-[600px]">
          <div className="relative h-[600px] w-[800px]">
            <Image
              src="/homepage_background.jpg"
              alt="flower_image"
              fill={true}
            />
          </div>
          <div className="relative h-[600px] w-[1315px] text-center">
            <h1 className="text-3xl">Flowers</h1>
            <p className="text-2xl">Carefully arranged flowers for any special occassion.</p>
          </div>
        </div>
        {/* Fourth */}
        <div className="flex flex-row min-w-full min-h-[600px]">
          <div className="relative h-[600px] w-[1315px] text-center">
          <h1 className="text-3xl">Table Reservations</h1>
            <p className="text-2xl">A perfect space for many activities, whether it be quiet studying or to catch up with friends.</p>
          </div>
          <div className="relative h-[600px] w-[800px]">
            <Image
              src="/homepage_background.jpg"
              alt="table_image"
              fill={true}
            />
          </div>
        </div>
        {/* Fifth */}
        <div className="flex flex-row min-w-full min-h-[600px]">
          <div className="relative h-[600px] w-[800px]">
            <Image
              src="/homepage_background.jpg"
              alt="order_image"
              fill={true}
            />
          </div>
          <div className="relative h-[600px] w-[1315px] text-center">
            <h1 className="text-3xl">Online Ordering</h1>
            <p className="text-2xl">Conveniently order your desserts, drinks, and flowers on the go. We will make sure that they are ready for pickup when you arrive.</p>
          </div>
        </div>
      </div>
    </main>
  );
}
