import {createRoot} from "react-dom/client";
import {HelloButton} from "./HelloButton";
import BookList from "./Booklist";

export function app(container: Element) {
    const root = createRoot(container)
    root.render([
        <HelloButton/>,
        <BookList/>
    ])
}
