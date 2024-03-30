import Link from "next/link";

export default function Home() {
  return (
    <main>
      <div className="flex min-h-screen flex-col items-center justify-between py-96 mx-0.5 border-2 border-black text-yellow bg-cafeHomepage bg-contain">
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
              <Link href="#menu">Menu</Link>
            </li>
            <li className="px-12">
              <Link href="#flowers">Flowers</Link>
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
      <div
        id="menu"
        className="flex min-h-screen flex-col items-center justify-between p-24 mx-0.5 border-2 border-black"
      >
        <ul className="flex flex-row gap-12">
          <li>
            <button>Food</button>
          </li>
          <li>
            <button>Drinks</button>
          </li>
          <li>
            <button>Flowers</button>
          </li>
        </ul>
      </div>
    </main>
  );
}
