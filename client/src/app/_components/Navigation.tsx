"use client";

import { PersonIcon } from "@radix-ui/react-icons";
import Link from "next/link";
import { useState } from "react";

const navigationItems = [
  "Home",
  "Menu",
  "Flowers",
  "Online Order",
  "Reservations",
];

const Icon = () => {
  return (
    <div>
      <Link href={"/"}>
        <h1 className="text-2xl sm:text-2xl md:text-2xl uppercase">AZURE CAFE</h1>
      </Link>
    </div>
  );
};

export default function Navigation() {
  const [isMenuOpen, setIsMenuOpen] = useState<boolean>(false);

  const toggleMenu = () => setIsMenuOpen(!isMenuOpen);
  const closeMenu = () => setIsMenuOpen(false);

  return (
    <div>
      {isMenuOpen ? (
        <div className="fixed left-0 right-0 py-4 px-4 md:hidden flex flex-col text-center h-[100vh] w-[100vw] opacity-100 text-black bg-beigePrimary z-1">
          <div className="flex justify-between">
            <div></div>
            <button onClick={closeMenu}>X</button>
          </div>
          <div className="mt-12">
            <Icon />
          </div>
          <div className="flex flex-col mt-12 mx-4 border-x-2">
            <ul
              style={{
                letterSpacing: "6px",
              }}
            >
              {navigationItems.map((navigationItem, index) => (
                <li
                  className="m-8 p-4 text-2xl sm:text-3xl md:text-4xl uppercase border-y-[1px]"
                  key={index}
                >
                  <Link href={"/"}>{navigationItem}</Link>
                </li>
              ))}
            </ul>
          </div>
        </div>
      ) : (
        <div className="fixed top-0 left-0 py-4 px-4 md:px-12 w-screen bg-white opacity-100 md:opacity-75 shadow-md">
          <div className="flex justify-between">
            <div>
              <Icon />
            </div>
            <div className="hidden md:flex flex-row gap-8 items-center">
              {navigationItems.map((navigationItem, index) => (
                <Link href={"/"} key={index}>
                  {navigationItem}
                </Link>
              ))}
            </div>
            <div className="hidden md:flex flex-row gap-4 items-center">
              <PersonIcon className="h-6 w-6 text-black" />
              <Link href={"/"} className="text-black">
                Login
              </Link>
              <Link href={"/"} className="text-black">
                Cart
              </Link>
            </div>
            <div className="md:hidden">
              <button onClick={toggleMenu}>☰</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}
