import Swal from "sweetalert2";
import { theme } from "../../config/themeConfigMaterialUi";

export const TradAlert = (title,text,icon) => {
    Swal.fire({
        title,
        text,
        icon,
        confirmButtonColor: theme.palette.primary.main
      });
}