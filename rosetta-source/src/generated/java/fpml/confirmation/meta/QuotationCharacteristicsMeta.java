package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.QuotationCharacteristics;
import fpml.confirmation.validation.QuotationCharacteristicsTypeFormatValidator;
import fpml.confirmation.validation.QuotationCharacteristicsValidator;
import fpml.confirmation.validation.exists.QuotationCharacteristicsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=QuotationCharacteristics.class)
public class QuotationCharacteristicsMeta implements RosettaMetaData<QuotationCharacteristics> {

	@Override
	public List<Validator<? super QuotationCharacteristics>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuotationCharacteristics, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super QuotationCharacteristics> validator() {
		return new QuotationCharacteristicsValidator();
	}

	@Override
	public Validator<? super QuotationCharacteristics> typeFormatValidator() {
		return new QuotationCharacteristicsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuotationCharacteristics, Set<String>> onlyExistsValidator() {
		return new QuotationCharacteristicsOnlyExistsValidator();
	}
}
