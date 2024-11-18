package org.dagraz.LeetCode.Easy.E643MaximumAverageSubarrayI;

class ClaudeImpl {
    public double findMaxAverage(int[] nums, int k) {
        // Handle edge case where array length equals k
        if (nums.length == k) {
            return calculateInitialSum(nums, k) / (double) k;
        }

        // Calculate initial sum of first k elements
        double currentSum = calculateInitialSum(nums, k);
        double maxSum = currentSum;

        // Use sliding window to calculate subsequent sums
        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }

    private double calculateInitialSum(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        ClaudeImpl s = new ClaudeImpl();
        int[] nums = {38,652,626,863,563,59,415,631,106,556,301,834,93,333,661,992,759,322,867,563,157,965,871,81,810,727,904,556,125,204,451,163,856,430,378,772,489,145,755,595,701,56,429,794,389,442,138,501,765,6,64,274,323,287,708,134,366,612,42,491,168,845,6,377,275,384,149,117,529,256,64,583,313,846,729,54,640,868,555,757,226,971,32,549,259,92,683,977,56,77,469,225,923,827,602,550,564,103,19,445,359,84,380,24,930,110,79,570,330,986,328,556,310,712,105,921,156,141,898,212,570,719,789,493,547,743,396,463,846,415,260,558,851,641,934,781,103,13,704,785,352,384,341,662,96,798,583,252,291,833,816,862,553,606,707,452,349,103,915,548,871,527,458,722,168,392,856,623,758,560,408,110,944,101,124,392,900,59,996,191,892,812,53,445,418,761,897,120,216,164,20,87,44,478,162,212,222,18,188,980,930,596,442,226,698,566,618,950,625,614,141,870,778,195,667,197,308,917,669,524,81,41,964,477,519,126,690,93,496,230,74,778,826,868,4,876,435,622,826,412,588,968,634,366,515,302,915,175,219,584,699,652,977,15,130,496,493,172,942,341,402,16,119,228,236,123,457,671,745,283,436,685,603,70,52,118,372,967,293,943,904,345,596,881,712,726,730,206,250,24,547,652,40,667,232,628,790,689,300,888,973,88,573,576,158,977,47,883,297,692,826,553,37,422,786,102,500,516,308,750,540,207,754,932,874,987,561,17,676,213,905,1,301,830,578,811,808,977,46,457,669,873,10,59,647,796,161,500,665,469,602,557,676,357,490,903,344,403,920,372,968,177,374,621,359,304,784,167,281,831,624,302,704,986,361,703,783,522,203,448,343,806,5,372,163,847,627,859,602,899,231,570,76,957,543,435,261,328,955,542,159,931,845,215,918,558,918,701,433,122,149,776,280,154,500,795,354,479,6,956,378,237,527,454,195,422,242,808,750,197,703,261,128,900,476,398,458,747,99,891,221,600,20,501,107,872,648,461,352,654,417,730,243,296,185,790,719,427,599,821,976,302,83,456,202,559,855,12,658,306,904,879,907,924,380,14,796,28,475,148,34,892,879,278,189,416,420,260,195,19,81,523,673,164,979,227,76,186,240,734,493,144,614,400,420,346,766,568,727,241,717,761,485,948,391,26,716,812,286,263,183,720,786,209,236,117,436,312,304,676,399,149,172,365,901,592,711,667,161,790,260,230,904,745,530,647,124,598,811,762,861,995,482,999,204,719,116,640,383,772,669,134,921,841,499,822,434,563,841,947,705,101,177,609,199,59,609,675,657,420,437,518,415,272,517,971,343,985,964,78,110,633,213,31,826,64,206,260,979,47,559,37,501,88,998,700,147,607,375,804,28,164,674,443,788,543,767,131,881,731,210,991,716,775,22,542,191,580,155,171,980,714,560,481,803,558,533,302,166,260,459,194,424,133,989,213,29,756,696,910,839,258,901,555,33,275,98,225,856,253,748,188,319,308,669,122,218,202,777,384,462,236,930,238,369,920,803,750,28,500,660,220,758,913,775,144,189,225,721,397,830,469,585,150,129,606,624,699,160,401,84,622,637,366,212,359,638,368,109,667,220,122,239,330,35,366,474,576,592,195,325,774,16,262,924,497,868,901,197,28,654,633,2,644,999,567,3,638,935,464,657,155,938,896,485,974,262,312,902,206,507,228,981,876,490,257,373,711,510,922,739,165,555,742,809,555,661,164,193,596,980,850,751,919,98,588,245,360,900,147,919,760,375,900,636,218,509,361,929,20,284,668,185,191,762,346,746,423,510,291,371,490,493,474,761,943,63,6,304,963,154,575,75,881,475,711,451,336,73,380,356,709,401,893,900,515,239,999,291,101,642,662,944,488,137,705,431,552,64,87,867,218,662,943,451,489,654,903,826,79,635,534,140,36,428,393,904,19,392,195,121,386,209,65,874,346,122,658,250,186,745,118,756,760,61,208,601,67,463,779,147,98,314,287,487,94,32,391,113,424,938,234,163,147,651,389,846,774,47,96,960,145,214,717,257,627,277,858,695,92,638,842,190,304,481,29,750,514,772,863,290,710,450,805,858,453,195,704,227,594,152,540,91,719,609,348,346,238,559,41,330,197,235,872,853,69,902,603,935,674,818,577,737,268,383,595,74,930,651,301,524,803,193,616,874,154,964,221,392,523,614,74,72,202,947,277,623,201,232,910,227,51,487,964,671,222,911,745,152,562,399,29,718,592,645,592,99,961,165,491};
        int k = 838;
//        int[] nums = {6,8,6,8,0,4,1,2,9,9};
//        int k = 2;
        System.out.println(s.findMaxAverage(nums, k));
    }
}
