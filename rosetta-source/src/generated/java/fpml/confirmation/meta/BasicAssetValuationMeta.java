package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasicAssetValuation;
import fpml.confirmation.validation.BasicAssetValuationTypeFormatValidator;
import fpml.confirmation.validation.BasicAssetValuationValidator;
import fpml.confirmation.validation.exists.BasicAssetValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasicAssetValuation.class)
public class BasicAssetValuationMeta implements RosettaMetaData<BasicAssetValuation> {

	@Override
	public List<Validator<? super BasicAssetValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasicAssetValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasicAssetValuation> validator() {
		return new BasicAssetValuationValidator();
	}

	@Override
	public Validator<? super BasicAssetValuation> typeFormatValidator() {
		return new BasicAssetValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasicAssetValuation, Set<String>> onlyExistsValidator() {
		return new BasicAssetValuationOnlyExistsValidator();
	}
}
