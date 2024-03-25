package io.lenra.app.components;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import io.lenra.app.ViewResponse;

@JsonTypeInfo(use = Id.DEDUCTION, defaultImpl = Wrap.class)
@JsonSubTypes({ @Type(Actionable.class), @Type(Button.class), @Type(Carousel.class), @Type(Checkbox.class), @Type(Container.class), @Type(DropdownButton.class), @Type(Flex.class), @Type(Flexible.class), @Type(Form.class), @Type(Icon.class), @Type(Image.class), @Type(Menu.class), @Type(MenuItem.class), @Type(OverlayEntry.class), @Type(Radio.class), @Type(Slider.class), @Type(Stack.class), @Type(StatusSticker.class), @Type(Text.class), @Type(TextField.class), @Type(Toggle.class), @Type(View.class), @Type(Wrap.class) })
public interface LenraComponent extends ViewResponse {
}
