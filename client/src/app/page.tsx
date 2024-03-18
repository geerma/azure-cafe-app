import Image from "next/image";

export default function Home() {
  return (
    <main>
      <div className="flex min-h-screen flex-col items-center justify-between p-24 mx-0.5 border-2 border-black">
        <ul className="flex flex-row gap-12">
          <li>Home</li>
          <li>Menu</li>
          <li>Flowers</li>
          <li>Online Order</li>
          <li>Reservations</li>
          <li>About / Contact Us</li>
        </ul>
      </div>
      <div className="flex min-h-screen flex-col items-center justify-between p-24 mx-0.5 border-2 border-black">
        <ul className="flex flex-row gap-12">
          <li><button>Food</button></li>
          <li><button>Drinks</button></li>
          <li><button>Flowers</button></li>
        </ul>
      </div>
    </main>
  );
}
