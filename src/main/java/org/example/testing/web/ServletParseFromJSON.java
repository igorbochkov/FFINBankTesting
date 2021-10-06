package org.example.testing.web;

import org.example.testing.model.Goods;
import org.example.testing.util.UtilParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;

@WebServlet(name = "ServletParseFromJSON", value = "/")
public class ServletParseFromJSON extends HttpServlet {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        Goods goods = UtilParser.parseFromGoods(getServletContext().getResourceAsStream("/resources/goods.json"));

        List<Goods.Good> goodList = new ArrayList<>(Arrays.asList(Objects.requireNonNull(goods).getGoods()));
        List<Goods.Good> responseGoodList = new ArrayList<>();

        String category = request.getParameter("category");
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");

        if ("wired-headphones".equals(category) || "wireless-headphones".equals(category) || "smart-watches".equals(category)) {
            for (Goods.Good good : goodList) {
                if (good.getCategory().equals(category)) {
                    responseGoodList.add(good);
                }
            }
        } else {
            responseGoodList.addAll(goodList);
        }

        if (sort != null) {
            switch (sort) {
                case "price":
                    if ("asc".equals(order)) {
                        responseGoodList.sort(Comparator.comparing(Goods.Good::getPrice));
                    } else {
                        responseGoodList.sort(Comparator.comparing(Goods.Good::getPrice).reversed());
                    }
                    break;
                case "date":
                    if ("asc".equals(order)) {
                        responseGoodList.sort(Comparator.comparing(Goods.Good::getTimestamp));
                    } else {
                        responseGoodList.sort(Comparator.comparing(Goods.Good::getTimestamp).reversed());
                    }
                    break;
            }

        }

        request.setAttribute("category", category);
        request.setAttribute("sort", sort);
        request.setAttribute("order", order);
        request.setAttribute("goodList", responseGoodList);
        request.setAttribute("dateTimeFormatter", dateTimeFormatter);

        request.getRequestDispatcher("WEB-INF/jsp/view.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
