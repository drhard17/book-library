import {createRoot} from "react-dom/client";
import {HelloButton} from "./HelloButton";
import BookList from "./Booklist";
import CurrentUser from "./CurrentUser";

export function app(container: Element) {
    const root = createRoot(container)
    root.render([
        <HelloButton/>,
        <CurrentUser/>,
        <BookList/>
    ])
}
