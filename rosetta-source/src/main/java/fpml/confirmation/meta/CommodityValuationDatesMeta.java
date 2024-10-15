package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CommodityValuationDates;
import fpml.confirmation.validation.CommodityValuationDatesTypeFormatValidator;
import fpml.confirmation.validation.CommodityValuationDatesValidator;
import fpml.confirmation.validation.exists.CommodityValuationDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CommodityValuationDates.class)
public class CommodityValuationDatesMeta implements RosettaMetaData<CommodityValuationDates> {

	@Override
	public List<Validator<? super CommodityValuationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CommodityValuationDates>create(fpml.confirmation.validation.datarule.CommodityValuationDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityValuationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CommodityValuationDates> validator() {
		return new CommodityValuationDatesValidator();
	}

	@Override
	public Validator<? super CommodityValuationDates> typeFormatValidator() {
		return new CommodityValuationDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityValuationDates, Set<String>> onlyExistsValidator() {
		return new CommodityValuationDatesOnlyExistsValidator();
	}
}
