import { HoverComponentProps } from "../_types/types";

const HoverComponent: React.FC<HoverComponentProps> = ({
  title,
  description,
  imageURL,
}: HoverComponentProps) => {
  return (
    <div
      className="flex justify-center items-center w-[100vw] h-[40vh] bg-cover bg-center text-white"
      style={{
        backgroundImage: `url(${imageURL})`,
        letterSpacing: "10px",
        backgroundColor: "#f5f5dc",
      }}
    >
      <div className="text-center px-12 py-8 bg-black bg-opacity-50 rounded-lg">
        <h1 className="text-2xl sm:text-3xl md:text-4xl uppercase">{title}</h1>
        <h2 className="text-md sm:text-lg md:text-xl lowercase">
          {description}
        </h2>
      </div>
    </div>
  );
};

export default HoverComponent;
