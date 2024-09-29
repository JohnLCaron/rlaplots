package org.cryptobiotic.rlaplots

import org.cryptobiotic.rlauxe.util.SRT

fun main() {
    val wtf: ClosedFloatingPointRange<Double> = 0.5 ..0.52
    comparisonFailures(wtf)
    // comparisonFailures(reportedMeanDiff=-.01)
}

fun comparisonFailures(thetaFilter: ClosedRange<Double>? = null, reportedMeanDiff: Double? = null) {
    val filename = "/home/stormy/temp/sim/failures/comparison99.csv"
    val srts: List<SRT> = readAndFilter(filename, thetaFilter, reportedMeanDiff=reportedMeanDiff)

    val ntrials = srts[0].ntrials
    val N = srts[0].N
    val eta0Factor = srts[0].eta0Factor
    val d = srts[0].d

    srtPlot(
        titleS = "Comparison Audit: successRLAs at 40% cutoff",
        subtitleS = "for N=$N d=$d eta0Factor=$eta0Factor ntrials=$ntrials",
        srts,
        "/home/stormy/temp/sim/failures/comparison40n.svg",
        "theta", "pctSuccess", "reportedMeanDiff",
        xfld = { it.theta },
        yfld = { extractDecile(it, 40) },
        catfld = { it.reportedMeanDiff },
    )
}
