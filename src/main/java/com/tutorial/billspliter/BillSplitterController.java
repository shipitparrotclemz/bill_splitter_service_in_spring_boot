package com.tutorial.billspliter;

import com.tutorial.billspliter.models.InputItem;
import com.tutorial.billspliter.models.OutputUser;
import com.tutorial.billspliter.service.BillSplitterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BillSplitterController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello to you %s", name);
    }

    @GetMapping("/splitbill")
    public ArrayList<OutputUser> splitBill(@RequestBody InputItem item) {
        ArrayList<InputItem> items = new ArrayList<InputItem>();
        items.add(item);
        ArrayList<OutputUser> output = BillSplitterService.splitBill(items);
        return output;
    }
}
