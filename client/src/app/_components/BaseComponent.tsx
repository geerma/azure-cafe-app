import { BaseComponentProps } from "../_types/types";

const BaseComponent: React.FC<BaseComponentProps> = ({
  title,
  imageURL,
}: BaseComponentProps) => {
  return (
    <div
      className="flex justify-center items-center w-[100vw] h-[20vh] bg-cover bg-center text-white"
      style={{
        backgroundImage: `url(${imageURL})`,
        letterSpacing: "10px",
        backgroundColor: "#f5f5dc",
      }}
    >
      <div className="text-center px-6 py-4 bg-black bg-opacity-50 rounded-lg">
        <h1 className="text-2xl sm:text-3xl md:text-4xl uppercase">{title}</h1>
      </div>
    </div>
  );
};

export default BaseComponent;
