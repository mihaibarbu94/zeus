var ctx = document.getElementById("myChart").getContext('2d');
var myChart = new Chart(ctx, {
    type: 'scatter',
    data: {
        labels: "Scatter Dataset",
        datasets: [
            {
                label: 'Chrome',
                fill: false,
                data: [
                    {
                        x: 2,
                        y: 100
                    },{
                        x: 134,
                        y: 100
                    },{
                        x: 265,
                        y: 100
                    },{
                        x: 397,
                        y: 100
                    },{
                        x: 529,
                        y: 99
                    },{
                        x: 662,
                        y: 98
                    },{
                        x: 795,
                        y: 98
                    },{
                        x: 927,
                        y: 97
                    },{
                        x: 1058,
                        y: 96
                    },{
                        x: 1192,
                        y: 96
                    },{
                        x: 1322,
                        y: 95
                    },{
                        x: 1455,
                        y: 94
                    },{
                        x: 1587,
                        y: 94
                    },{
                        x: 1719,
                        y: 93
                    },{
                        x: 1802,
                        y: 93
                    }],
                borderColor: ['rgba(255,99,132,1)'],
                borderWidth: 3
            },
            {
                label: 'Firefox',
                fill: false,
                data: [
                    {
                        x: 2,
                        y: 100
                    },{
                        x: 135,
                        y: 100
                    },{
                        x: 267,
                        y: 100
                    },{
                        x: 399,
                        y: 99
                    },{
                        x: 533,
                        y: 99
                    },{
                        x: 662,
                        y: 98
                    },{
                        x: 794,
                        y: 97
                    },{
                        x: 924,
                        y: 96
                    },{
                        x: 1056,
                        y: 95
                    },{
                        x: 1189,
                        y: 95
                    },{
                        x: 1319,
                        y: 94
                    },{
                        x: 1451,
                        y: 93
                    },{
                        x: 1581,
                        y: 92
                    },{
                        x: 1714,
                        y: 92
                    },{
                        x: 1802,
                        y: 91
                    }],
                borderColor: [   'rgba(54, 162, 235, 1)' ],
                borderWidth: 3
            },
            {
                label: 'Opera Mini',
                fill: false,
                data: [
                    {
                        x: 2,
                        y: 100
                    },{
                        x: 132,
                        y: 100
                    },{
                        x: 263,
                        y: 100
                    },{
                        x: 394,
                        y: 99
                    },{
                        x: 524,
                        y: 98
                    },{
                        x: 655,
                        y: 98
                    },{
                        x: 785,
                        y: 97
                    },{
                        x: 919,
                        y: 96
                    },{
                        x: 1049,
                        y: 96
                    },{
                        x: 1180,
                        y: 95
                    },{
                        x: 1311,
                        y: 94
                    },{
                        x: 1442,
                        y: 94
                    },{
                        x: 1576,
                        y: 93
                    },{
                        x: 1709,
                        y: 92
                    },{
                        x: 1802,
                        y: 92
                    }],
                borderColor: [   'rgba(255, 206, 86, 1)' ],
                borderWidth: 3
            }]
    },
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero:false
                }
            }]
        }
    }
});