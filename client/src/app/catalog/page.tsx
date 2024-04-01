import Image from "next/image";

export default function Catalog() {
    return (
        <main className="flex min-h-screen flex-col items-center justify-between">
            <div>
                <div className="min-h-[15vh] bg-gray text-center">
                    <h1 className="py-12 text-4xl text-yellow">Menu and Flowers</h1>
                </div>
                <div id="#menu" className="min-h-[100vh] w-screen bg-beigePrimary text-center flex flex-row">
                    <Image 
                        src={"/catalog_foods.png"}
                        alt="foods catalog"
                        width={500}
                        height={750}
                        className="m-auto"
                    />
                    <Image 
                        src={"/catalog_drinks.png"}
                        alt="drinks catalog"
                        width={500}
                        height={750}
                        className="m-auto"
                    />
                </div>
                <div id="#flowers" className="min-h-[90vh] w-screen bg-beigePrimary text-center">
                    <Image 
                        src={"/catalog_flowers.png"}
                        alt="flowers catalog"
                        width={500}
                        height={750}
                        className="m-auto"
                    />
                </div>
            </div>
        </main>
    )
}