package ru.itsjava.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BuyerServiceImpl implements BuyerService {
    private final VeryNecessaryThingService veryNecessaryThingService;
    private final IOService ioService;

    @Override
    public void takeYourProduct() {
        System.out.println("Hello. We are glad to see you!");
        System.out.println("Here are our products");
        veryNecessaryThingService.showingVeryNecessaryThing();
        System.out.println("Enter the exact amount of the product");
        int price = ioService.input();
        System.out.println("Here is your product");
        veryNecessaryThingService.byChoosingVeryNecessaryThingPrice(price);
    }
}
