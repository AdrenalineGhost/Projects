let plot_count = 0;

export class Plot {
    constructor(title) {
        let div = document.createElement("div");
        div.className = "row mt-5";
        div.id = "chartContainer" + plot_count;
        div.style = "height: 370px; width: 100%;";

        let top_level_container = document.getElementById("top-level-container");
        top_level_container.appendChild(div);

        this.dataPoints = [];
        this.chart = new CanvasJS.Chart("chartContainer" + plot_count, {
            theme: "light2",
            title: {
                text: title
            },
            axisY: {
                title: "Price"
            },
            axisX: {
                title: "Date"
            },
            data: [{
                type: "line",
                dataPoints: this.dataPoints
            }]
        });
        plot_count++;
    }

    plotData(data) {
        this.dataPoints.push({x: data[0], y: parseInt(data[1])});
        this.chart.render();
    }
}
