/** @type {import('next').NextConfig} */
const nextConfig = {
  images: {
    remotePatterns: [
      {
        protocol: "https",
        hostname: "azure-cafe-app-cdn.azureedge.net",
        pathname: "**",
      },
    ],
  },
};

export default nextConfig;
