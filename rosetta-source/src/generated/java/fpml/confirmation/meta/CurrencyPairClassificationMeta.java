package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CurrencyPairClassification;
import fpml.confirmation.validation.CurrencyPairClassificationTypeFormatValidator;
import fpml.confirmation.validation.CurrencyPairClassificationValidator;
import fpml.confirmation.validation.exists.CurrencyPairClassificationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CurrencyPairClassification.class)
public class CurrencyPairClassificationMeta implements RosettaMetaData<CurrencyPairClassification> {

	@Override
	public List<Validator<? super CurrencyPairClassification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CurrencyPairClassification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CurrencyPairClassification> validator() {
		return new CurrencyPairClassificationValidator();
	}

	@Override
	public Validator<? super CurrencyPairClassification> typeFormatValidator() {
		return new CurrencyPairClassificationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CurrencyPairClassification, Set<String>> onlyExistsValidator() {
		return new CurrencyPairClassificationOnlyExistsValidator();
	}
}
