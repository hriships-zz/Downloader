package com.agoda.downloader.cliutil;

import com.agoda.downloader.domain.CLIOptions;
import org.apache.commons.cli.*;

/**
 * Created by hrishikeshshinde on 01/12/16.
 */
public class CLIUtil {
    private static CommandLineParser parser;
    private static CommandLine commandLine;
    private static Options options;

    public static void initOptions(String[] args) throws ParseException {
        Option firstNDataOption = new Option(CLIOptions.DOWNLOAD_LOCATION_SS.toString(), CLIOptions.DOWNLOAD_LOCATION_LS.toString(),
                                            true, "Local download path");
        Option inputDataOption  = new Option(CLIOptions.DOWNLOAD_SOURCE_SS.toString(),
                                            CLIOptions.DOWNLOAD_SOURCE_LS.toString(), true, "Downlaod data sources in csv form");
        Option helpOption 		= new Option(CLIOptions.HELP_SS.toString(), "Help");

        options = new Options();
        options.addOption(firstNDataOption);
        options.addOption(inputDataOption);
        options.addOption(helpOption);

        parser = new PosixParser();
        commandLine = parser.parse(options, args);

    }

    public static String getOptionValue(CLIOptions switchName) {
        if (commandLine.hasOption(switchName.toString())) {
            return commandLine.getOptionValue(switchName.toString());
        } else {
            return null;
        }
    }

    public static void checkIfNeedHelp() {
        if(commandLine.hasOption(CLIOptions.HELP_SS.toString())) {
            help();
        }
    }

    public static void help() {
        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Sorting Help", options);
        System.exit(0);

    }
}
