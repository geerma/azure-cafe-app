import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
        cafeHomepage: "url('/homepage_background.jpg')",
      },
    },
    colors: {
      beigePrimary: "#FAF6ED",
      beigeSecondary: "#faf0e6",
      black: "#000000",
      gold: "#82724d",
      gray: "#42413b",
      yellow: "#FFC226",
    },
  },
  plugins: [],
};
export default config;
