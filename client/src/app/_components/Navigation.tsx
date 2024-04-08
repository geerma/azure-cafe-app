'use client'

import { PersonIcon } from "@radix-ui/react-icons"
import Link from "next/link";

const navigationItems = ['Home', 'Menu', 'Flowers', 'Online Order', 'Reservations', '•' ];

export default function Navigation() {
  return (
    <div className="absolute top-0 py-4 px-4 hidden gap-2 md:flex text-white bg-black w-screen opacity-75">
      {navigationItems.map((navigationItem, index) => (
        <Link href={"/"} key={index}>
          {navigationItem}
        </Link>
      ))}
      <PersonIcon className="h-8 w-8" />
      <Link href={"/"}>Login</Link>
      <Link href={"/"}>•</Link>
      <Link href={"/"}>Cart</Link>
    </div>
  );
}