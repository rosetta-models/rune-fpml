package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityBusinessCalendar;
import fpml.confirmation.validation.CommodityBusinessCalendarTypeFormatValidator;
import fpml.confirmation.validation.CommodityBusinessCalendarValidator;
import fpml.confirmation.validation.exists.CommodityBusinessCalendarOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CommodityBusinessCalendar.class)
public class CommodityBusinessCalendarMeta implements RosettaMetaData<CommodityBusinessCalendar> {

	@Override
	public List<Validator<? super CommodityBusinessCalendar>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBusinessCalendar, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityBusinessCalendar> validator() {
		return new CommodityBusinessCalendarValidator();
	}

	@Override
	public Validator<? super CommodityBusinessCalendar> typeFormatValidator() {
		return new CommodityBusinessCalendarTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBusinessCalendar, Set<String>> onlyExistsValidator() {
		return new CommodityBusinessCalendarOnlyExistsValidator();
	}
}
